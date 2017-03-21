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
import soft.jf.seguridad.dao.segPerfilesDAO;
import soft.jf.seguridad.dao.segUsuariosDAO;
import soft.jf.seguridad.modelos.Estadosusuarios;
import soft.jf.seguridad.modelos.Segfunciones;
import soft.jf.seguridad.modelos.Segperfiles;
import soft.jf.seguridad.modelos.Segusuarios;
import soft.jf.seguridad.utils.MsgRespuesta;

/**
 *
 * @author jbarrientos
 */
public class permisosSRV extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession(true);
            String sessionUsuario = (String) session.getAttribute("sessionUsuaurio");

            Gson json;
            MsgRespuesta resp;
            Segperfiles obj;
            ArrayList<Segperfiles> lista;
            ArrayList<Segfunciones> listaFunciones;
            segPerfilesDAO objDAO;
            int existe;

            String action = request.getParameter("action");
            String idRow = request.getParameter("idRow");
            String nombre = request.getParameter("nombre");
            String[] chkfunciones = request.getParameterValues("chkfunciones");
            
            String activo = "";
            if (request.getParameter("idestado") != null) {
                activo = "1";
            } else {
                activo = "0";
            }
            
            
            String data = "";
            String botonEditar = "";

            switch (action) {

                case "listar":

                    data = "<thead> ";
                    data = data + "<tr> ";
                    data = data + "<th></th> ";
                    data = data + "<th>Nombre</th> ";
                    data = data + "<th>Activo</th> ";
                    data = data + "</tr> ";
                    data = data + "</thead> ";
                    data = data + "<tfoot> ";
                    data = data + "<tr> ";

                    data = data + "<th></th> ";
                    data = data + "<th>Nombre</th> ";
                    data = data + "<th>Activo</th> ";
                    data = data + "</tr> ";
                    data = data + "</tfoot>";

                    data = data + "<tbody>";

                    obj = new Segperfiles();
                    objDAO = new segPerfilesDAO();
                    lista = new ArrayList<>();
                    String strActivo = "";
                    try {
                        lista = objDAO.ConsultarPerfiles();
                        for (Segperfiles objperfiles : lista) {

                            strActivo = "Inactivo";
                            if (objperfiles.getActivo() == 1) {
                                strActivo = "Activo";
                            }

                            botonEditar = "<a  href='#' ><button id='" + objperfiles.getIdperfil() + "'  onclick='editar(this,event);' class='btn btn-primary btn-xs'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></button></a>";

                            data = data + " <tr> ";
                            data = data + " <td>" + botonEditar + "</td>";
                            data = data + " <td>" + objperfiles.getPerfil() + "</td>";
                            data = data + " <td>" + strActivo + "</td>";

                            data = data + " </tr>";
                        }
                        data = data + "</tbody>";
                        out.println(data);
                    } catch (ClassNotFoundException | SQLException ex) {
                        out.print("Error General Intente mas tarde!!!!" + ex.getMessage());
                        Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;

                case "consulta":

                    json = new Gson();
                    objDAO = new segPerfilesDAO();
                    lista = new ArrayList<>();
                     {
                        try {
                            lista = objDAO.ConsultarPerfilesxId(idRow);
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                            out.print("Error General Intente mas tarde!!!!" + ex.getMessage());
                        }
                    }
                    out.print(json.toJson(lista));

                    break;

                case "consultaFunciones":

                    data = "<thead> ";
                    data = data + "<tr> ";
                    data = data + "<th></th> ";
                    
                    data = data + "<th>Modulo</th> ";
                    data = data + "<th>Funcion</th> ";
                    data = data + "<th>Activo</th> ";
                    data = data + "</tr> ";
                    data = data + "</thead> ";

                    data = data + "<tbody>";
                    json = new Gson();
                    objDAO = new segPerfilesDAO();
                    listaFunciones = new ArrayList<>();
                    String selecciona = "";
                    boolean resultado = false;
                    strActivo = "";
                     {
                        try {
                            listaFunciones = objDAO.ConsultarFunciones();
                            //crear una funcion donde pasemos idperfil = idRow y idfuncion para saber si esta funncion ya esta en el 
                            //perfil seleccionado
                            for (Segfunciones objfunciones : listaFunciones) {

                                selecciona = "";
                                resultado = objDAO.verificafuncionxperfil(Integer.parseInt(idRow), objfunciones.getIdfuncion());
                                if (resultado) {
                                    selecciona = "checked";
                                }

                                strActivo = "Inactivo";
                                if (objfunciones.getActivo() == 1) {
                                    strActivo = "Activo";
                                }

                                botonEditar = "<input " + selecciona + " type='checkbox' id='chk_" + objfunciones.getIdfuncion() + "' name='chkfunciones' value='"+objfunciones.getIdfuncion()+"' /><label for='chk_" + objfunciones.getIdfuncion() + "'>&nbsp;</label>";
                                data = data + " <tr> ";
                                
                                data = data + " <td>" + botonEditar + "</td>";
                                
                                data = data + " <td>" + objfunciones.getIdmodulo().getTitulo() + "</td>";
                                data = data + " <td>" + objfunciones.getTitulo() + "</td>";
                                data = data + " <td>" + strActivo + "</td>";
                                data = data + " </tr>";
                            }

                            data = data + "</tbody>";
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                            out.print("Error General Intente mas tarde!!!!" + ex.getMessage());
                        }
                    }
                    //out.print(json.toJson(listaFunciones));
                    out.print(data);
                    break;
                case "editar":

                    obj = new Segperfiles();
                    obj.setIdperfil(Integer.parseInt(idRow));
                    obj.setPerfil(nombre);
                    obj.setActivo(Integer.parseInt(activo));
                    
                   
                    objDAO = new segPerfilesDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();

                    try {
                        existe = objDAO.verificaPerfil(nombre, "editar");
                        if (existe == 0) {
                            try {

                                boolean respuesta = objDAO.EditaPerfil(obj,chkfunciones);
                                if (respuesta) {
                                    resp.setRespuesta(true);
                                    resp.setMensaje("Perfil Editado Correctamente");

                                } else {

                                    resp.setRespuesta(false);
                                    resp.setMensaje("Error al editar el perfil");

                                }

                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                                resp.setRespuesta(false);
                                resp.setMensaje("Error al editar el perfil , Consulte al Administrador");

                            }
                        } else {
                            resp.setRespuesta(false);
                            resp.setMensaje("El perfil " + nombre + " ya existe, registra uno diferente");

                        }

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                        resp.setRespuesta(false);
                        resp.setMensaje("Error al validar , Consulte al Administrador");

                    }
                    out.print(json.toJson(resp));
                    break;
                case "nuevo":

                    obj = new Segperfiles();
                    obj.setIdperfil(0);
                    obj.setPerfil(nombre);
                    obj.setActivo(Integer.parseInt(activo));

                    objDAO = new segPerfilesDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();

                     {
                        try {

                            existe = objDAO.verificaPerfil(nombre, "nuevo");
                            if (existe == 0) {
                                try {
                                    boolean respuesta = objDAO.CreaPerfil(obj,chkfunciones);
                                    if (respuesta) {
                                        resp.setRespuesta(true);
                                        resp.setMensaje("Perfil Registrado Correctamente");
                                        //out.print(json.toJson(resp));
                                    } else {

                                        resp.setRespuesta(false);
                                        resp.setMensaje("Error al Registrar el Perfil");
                                        //out.print(json.toJson(resp));

                                    }

                                } catch (ClassNotFoundException | SQLException ex) {
                                    Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                                    resp.setRespuesta(false);
                                    resp.setMensaje("Error al registrar el perfil , Consulte al Administrador");
                                    //out.print(json.toJson(resp));
                                }
                            } else {
                                resp.setRespuesta(false);
                                resp.setMensaje("El perfil " + nombre + " ya existe, registra uno diferente");
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
