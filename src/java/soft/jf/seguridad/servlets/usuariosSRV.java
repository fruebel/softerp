/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import soft.jf.seguridad.dao.segUsuariosDAO;
import soft.jf.seguridad.modelos.Estadosusuarios;
import soft.jf.seguridad.modelos.Segperfiles;
import soft.jf.seguridad.modelos.Segusuarios;
import soft.jf.seguridad.utils.MsgRespuesta;

/**
 *
 * @author jbarrientos
 */
public class usuariosSRV extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession(true);
            String sessionUsuario = (String) session.getAttribute("sessionUsuaurio");

            Gson json;
            MsgRespuesta resp;
            Segusuarios usuario;
            ArrayList<Segusuarios> lista;
            segUsuariosDAO usuarioDAO;
            int existeUsuario;

            String action = request.getParameter("action");
            String idRow = request.getParameter("idRow");
            String idusuario = request.getParameter("idusuario");
            String contrasenia = request.getParameter("contrasenia");
            String nombre = request.getParameter("nombre");
            String apellidopaterno = request.getParameter("apellidopaterno");
            String apellidomaterno = request.getParameter("apellidomaterno");
            String idperfil = request.getParameter("idperfil");
            String fotografia = request.getParameter("fotografia");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            String tema = request.getParameter("tema");
            String lenguaje = request.getParameter("lenguaje");
            String estatus = request.getParameter("estatus");
            String idestado = "";
            if (request.getParameter("idestado") != null) {
                idestado = "1";
            } else {
                idestado = "0";
            }

            String data = "";
            String botonEditar = "";
            String botonFoto = "";

            switch (action) {

                case "listar":

                    data = "<thead> ";
                    data = data + "<tr> ";
                    data = data + "<th>Operaciones</th> ";
                    
                    data = data + "<th>Usuario</th> ";
                    data = data + "<th>Nombre</th> ";
                    data = data + "<th>Estatus</th> ";
                    data = data + "<th>Perfil</th> ";
                    data = data + "<th>Fecha Registro</th> ";
                    data = data + "<th>Fecha Ultimo Acceso</th> ";
                    data = data + "<th>Usuario Registro</th> ";
                    data = data + "<th>Fotografia</th> ";

                    data = data + "</tr> ";
                    data = data + "</thead> ";
                    data = data + "<tfoot> ";
                    data = data + "<tr> ";

                    data = data + "<th></th> ";
                    data = data + "<th>Usuario</th> ";
                    data = data + "<th>Nombre</th> ";
                    data = data + "<th>Estatus</th> ";
                    data = data + "<th>Perfil</th> ";
                    data = data + "<th>Fecha Registro</th> ";
                    data = data + "<th>Fecha Ultimo Acceso</th> ";
                    data = data + "<th>Usuario Registro</th> ";
                    data = data + "<th></th> ";

                    data = data + "</tr> ";
                    data = data + "</tfoot>";

                    data = data + "<tbody>";

                    usuario = new Segusuarios();
                    usuarioDAO = new segUsuariosDAO();
                    lista = new ArrayList<>();

                    try {
                        lista = usuarioDAO.ConsultarUsuarios();
                        for (Segusuarios objusuario : lista) {

                            botonEditar = "<a  href='#' ><button id='" + objusuario.getIdUsuario() + "'  onclick='editar(this,event);' class='btn btn-primary btn-xs'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></button></a>";
                            botonFoto = "&nbsp;"; //"<a id='" + objusuario.getIdUsuario() + "'  onclick='editar(this);'  class='btn-floating  waves-effect waves-light red tooltipped' href='#modal2' data-position='left' data-delay='100' data-tooltip='Editar Fotografia' ><i class='material-icons md-18'>person_pin</i></a>";
                            
                            data = data + " <tr> ";
                            data = data + " <td>" + botonEditar + "</td>";
                            data = data + " <td>" + objusuario.getIdUsuario() + "</td>";
                            data = data + " <td>" + objusuario.getNombre() + "</td>";
                            data = data + " <td>" + objusuario.getIdEstado().getEstado() + "</td>";
                            data = data + " <td>" + objusuario.getIdperfil().getPerfil() + "</td>";
                            data = data + " <td>" + objusuario.getFechaRegistro() + "</td>";
                            data = data + " <td>" + objusuario.getUltimoAcceso() + "</td>";
                            data = data + " <td>" + objusuario.getIdUsuarioRegistro() + "</td>";
                            data = data + " <td>" + botonFoto + "</td>";
                            data = data + " </tr>";
                        }
                        
                    } catch (ClassNotFoundException | SQLException ex) {
                        out.print("Error General Intente mas tarde!!!!" + ex.getMessage());
                        Logger.getLogger(usuariosSRV.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    data = data + "</tbody>";
                    out.println(data);
                    break;

                case "consulta":
                    
                    json = new Gson();
                    usuarioDAO = new segUsuariosDAO();
                    lista = new ArrayList<>();
                    {
                        try {
                            lista = usuarioDAO.ConsultarUsuariosxId(idRow);
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(usuariosSRV.class.getName()).log(Level.SEVERE, null, ex);
                            out.print("Error General Intente mas tarde!!!!" + ex.getMessage());
                        }
                    }
                    out.print(json.toJson(lista));

                    break;
                case "editar":

                    usuario = new Segusuarios();
                    usuario.setIdUsuario(idRow);
                    usuario.setNombre(nombre);
                    usuario.setApellidoMaterno(apellidomaterno);
                    usuario.setApellidoPaterno(apellidopaterno);
                    usuario.setEmail(email);

                    Segperfiles perfil = new Segperfiles();
                    perfil.setIdperfil(Integer.parseInt(idperfil));
                    usuario.setIdperfil(perfil);

                    usuario.setTelefono(telefono);
                    usuario.setTema(tema);
                    usuario.setLenguaje(lenguaje);
                    usuario.setFotografia(fotografia);
                    usuario.setContrasenia(contrasenia);

                    Estadosusuarios estadousuarios = new Estadosusuarios();
                    estadousuarios.setIdestado(Integer.parseInt(idestado));
                    usuario.setIdEstado(estadousuarios);

                    usuarioDAO = new segUsuariosDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();

                    try {
                        existeUsuario = usuarioDAO.verificaUsuario(idusuario, "editar");
                        if (existeUsuario == 0) {
                            try {

                                boolean respuesta = usuarioDAO.EditaUsuario(usuario);
                                if (respuesta) {
                                    resp.setRespuesta(true);
                                    resp.setMensaje("Usuario Editado Correctamente");
                                   
                                } else {

                                    resp.setRespuesta(false);
                                    resp.setMensaje("Error al editar el usuario");
                                   

                                }

                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(usuariosSRV.class.getName()).log(Level.SEVERE, null, ex);
                                resp.setRespuesta(false);
                                resp.setMensaje("Error al editar el usuario , Consulte al Administrador");
                                
                            }
                        } else {
                            resp.setRespuesta(false);
                            resp.setMensaje("El usuario " + idusuario + " ya existe, registra uno diferente");
                           
                        }

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(usuariosSRV.class.getName()).log(Level.SEVERE, null, ex);
                        resp.setRespuesta(false);
                        resp.setMensaje("Error al validar , Consulte al Administrador");
                        
                    }
                    out.print(json.toJson(resp));
                    break;
                case "nuevo":

                    usuario = new Segusuarios();
                    usuario.setIdUsuario(idusuario);
                    usuario.setNombre(nombre);
                    usuario.setApellidoMaterno(apellidomaterno);
                    usuario.setApellidoPaterno(apellidopaterno);
                    usuario.setEmail(email);
                    usuario.setIdUsuarioRegistro(sessionUsuario);

                    Segperfiles perfiltemp = new Segperfiles();
                    perfiltemp.setIdperfil(Integer.parseInt(idperfil));
                    usuario.setIdperfil(perfiltemp);

                    usuario.setTelefono(telefono);
                    usuario.setTema(tema);
                    usuario.setLenguaje(lenguaje);
                    usuario.setFotografia(fotografia);
                    usuario.setContrasenia(contrasenia);

                    Estadosusuarios estadousuariostemp = new Estadosusuarios();
                    estadousuariostemp.setIdestado(Integer.parseInt(idestado));
                    usuario.setIdEstado(estadousuariostemp);

                    usuarioDAO = new segUsuariosDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();

                     {
                        try {

                            existeUsuario = usuarioDAO.verificaUsuario(idusuario, "nuevo");
                            if (existeUsuario == 0) {
                                try {
                                    boolean respuesta = usuarioDAO.CrearUsuario(usuario);
                                    if (respuesta) {
                                        resp.setRespuesta(true);
                                        resp.setMensaje("Usuario Registrado Correctamente");
                                        //out.print(json.toJson(resp));
                                    } else {

                                        resp.setRespuesta(false);
                                        resp.setMensaje("Error al Registrar el usuario");
                                        //out.print(json.toJson(resp));

                                    }

                                } catch (ClassNotFoundException | SQLException ex) {
                                    Logger.getLogger(usuariosSRV.class.getName()).log(Level.SEVERE, null, ex);
                                    resp.setRespuesta(false);
                                    resp.setMensaje("Error al registrar el usuario , Consulte al Administrador");
                                    //out.print(json.toJson(resp));
                                }
                            } else {
                                resp.setRespuesta(false);
                                resp.setMensaje("El usuario " + idusuario + " ya existe, registra uno diferente");
                                //out.print(json.toJson(resp));
                            }

                        } catch (ClassNotFoundException | SQLException ex) {
                            resp.setRespuesta(false);
                            resp.setMensaje("Error al validar , Consulte al Administrador");
                            
                        }
                    }
                    out.print(json.toJson(resp)); 
                    break;

                default:
                    break;

            }
            out.flush();
            out.close();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
