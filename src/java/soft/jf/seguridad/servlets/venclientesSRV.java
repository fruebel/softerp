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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import soft.jf.seguridad.dao.venclientesDAO;
import java.util.logging.Logger;
import soft.jf.seguridad.modelos.conestados;
import soft.jf.seguridad.modelos.ventiposclientes;
import soft.jf.seguridad.modelos.venterminospago;
import soft.jf.seguridad.modelos.venmetodospago;
import soft.jf.seguridad.modelos.venlistasprecios;
import soft.jf.seguridad.modelos.venhistorialcliente;
import soft.jf.seguridad.modelos.venclientes;
import soft.jf.seguridad.utils.MsgRespuesta;
import java.util.Date;

/**
 *
 * @author jbarrientos
 */
public class venclientesSRV extends HttpServlet {

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
            venclientes vencliente;
            ArrayList<venclientes> lista;
            venclientesDAO venclienteDAO;
            int existecliente;

            String action = request.getParameter("action");
            String idRow = request.getParameter("idRow");
            
            String idcliente = request.getParameter("idcliente");
            String nombrecompleto = request.getParameter("nombrecompleto");
            String nombres = request.getParameter("nombres");
            String apellidopaterno = request.getParameter("apellidopaterno");
            String apellidomaterno = request.getParameter("apellidomaterno");
            String rfc = request.getParameter("rfc");
            String curp = request.getParameter("curp");
            String calle = request.getParameter("calle");
            String numexterior = request.getParameter("numexterior");
            String numinterior = request.getParameter("numinterior");
            String colonia = request.getParameter("colonia");
            String municipio = request.getParameter("municipio");
            String ciudad = request.getParameter("ciudad");
            int idestado = 0;
            if (request.getParameter("idestado") != null) {
                idestado = Integer.parseInt(request.getParameter("idestado"));
            }
            String pais = request.getParameter("pais");
            String cp = request.getParameter("cp");
            int idtipocliente = 0;
            if (request.getParameter("idtipocliente") != null) {
                idtipocliente = Integer.parseInt(request.getParameter("idtipocliente"));
            }
            String idterminopago = request.getParameter("idterminopago");
            int idmetodopago = 0;
            if (request.getParameter("idmetodopago") != null) {
                idmetodopago = Integer.parseInt(request.getParameter("idmetodopago"));
            }
            String idlistaprecio = request.getParameter("idlistaprecio");
            int idhistorialcliente = 0;
            if (request.getParameter("idhistorialcliente") != null) {
                idhistorialcliente = Integer.parseInt(request.getParameter("idhistorialcliente"));
            }
            float descuento = 0;
            if (request.getParameter("idhistorialcliente") != null) {
                descuento = Float.valueOf(request.getParameter("descuento"));
            }
            float limitecredito = 0;
            if (request.getParameter("limitecredito") != null) {
                limitecredito = Float.valueOf(request.getParameter("limitecredito"));
            }
            int diascredito = 0;
            if (request.getParameter("diascredito") != null) {
                diascredito = Integer.parseInt(request.getParameter("diascredito"));
            }
            float ultimopago = 0;
            if (request.getParameter("ultimopago") != null) {
                ultimopago = Float.valueOf(request.getParameter("ultimopago"));
            }
            String fechaultimopago = "1900-01-01";
            if (request.getParameter("fechaultimopago") != null) {
                fechaultimopago = request.getParameter("fechaultimopago");
            }
            String clientedesde = request.getParameter("clientedesde");
            
            
            String data = "";
            String botonEditar = "";
            String botonFoto = "";

            switch (action) {

                case "listar":

                    data = "<thead> ";
                    data = data + "<tr> ";
                    data = data + "<th>Operaciones</th> ";
                    data = data + "<th>Razon Social</th> ";
                    data = data + "<th>Rfc</th> ";
                    data = data + "<th>Curp</th> ";

                    data = data + "</tr> ";
                    data = data + "</thead> ";
                    data = data + "<tfoot> ";
                    data = data + "<tr> ";
                    data = data + "<th></th> ";
                    data = data + "<th>Razon Social</th> ";
                    data = data + "<th>Rfc</th> ";
                    data = data + "<th>Curp</th> ";

                    data = data + "</tr> ";
                    data = data + "</tfoot>";

                    data = data + "<tbody>";

                    vencliente = new venclientes();
                    venclienteDAO = new venclientesDAO();
                    lista = new ArrayList<>();

                    try {
                        lista = venclienteDAO.ConsultarClientes();
                        for (venclientes objcliente : lista) {

                            botonEditar = "<a  href='#' ><button id='" + objcliente.getIdcliente() + "'  onclick='editar(this,event);' </button><i class='fa fa-pencil-square-o' aria-hidden='true'></i></a>";
                            botonFoto = "&nbsp;"; //"<a id='" + objusuario.getIdUsuario() + "'  onclick='editar(this);'  class='btn-floating  waves-effect waves-light red tooltipped' href='#modal2' data-position='left' data-delay='100' data-tooltip='Editar Fotografia' ><i class='material-icons md-18'>person_pin</i></a>";

                            data = data + " <tr> ";
                            data = data + " <td>" + botonEditar + "</td>";
                            data = data + " <td>" + objcliente.getNombrecompleto() + "</td>";
                            data = data + " <td>" + objcliente.getRfc() + "</td>";
                            data = data + " <td>" + objcliente.getCurp() + "</td>";
                            data = data + " </tr>";
                        }

                    } catch (ClassNotFoundException | SQLException ex) {
                        out.print("Error General Intente mas tarde!!!!" + ex.getMessage());
                        Logger.getLogger(venclientesSRV.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    data = data + "</tbody>";
                    out.println(data);
                    break;

                case "consulta":

                    json = new Gson();
                    venclienteDAO = new venclientesDAO();
                    lista = new ArrayList<>();
                     {
                        try {
                            lista = venclienteDAO.ConsultarClientexId(idRow);
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(venclientesSRV.class.getName()).log(Level.SEVERE, null, ex);
                            out.print("Error General Intente mas tarde!!!!" + ex.getMessage());
                        }
                    }
                    out.print(json.toJson(lista));

                    break;
                case "editar":

                    vencliente = new venclientes();
                    vencliente.setIdcliente(idRow);
                    vencliente.setNombrecompleto(nombrecompleto);
                    vencliente.setNombres(nombres);
                    vencliente.setApellidopaterno(apellidopaterno);
                    vencliente.setApellidomaterno(apellidomaterno);
                    vencliente.setRfc(rfc);
                    vencliente.setCurp(curp);
                    vencliente.setCalle(calle);
                    vencliente.setNumexterior(numexterior);
                    vencliente.setNuminterior(numinterior);
                    vencliente.setColonia(colonia);
                    vencliente.setMunicipio(municipio);
                    vencliente.setCiudad(ciudad);
                    
                    conestados conestado = new conestados();
                    conestado.setIdestado(idestado);
                    vencliente.setIdestado(conestado);
                    
                    vencliente.setPais(pais);
                    vencliente.setCp(cp);
                    
                    ventiposclientes ventipocliente = new ventiposclientes();
                    ventipocliente.setIdtipocliente(idtipocliente);
                    vencliente.setIdtipocliente(ventipocliente);
                    
                    venterminospago venterminopago = new venterminospago();
                    venterminopago.setIdterminopago(idterminopago);
                    vencliente.setIdterminopago(venterminopago);
                    
                    venmetodospago venmetodopago = new venmetodospago();
                    venmetodopago.setIdmetodopago(idmetodopago);
                    vencliente.setIdmetodopago(venmetodopago);
                    
                    venlistasprecios venlistaprecio = new venlistasprecios();
                    venlistaprecio.setIdlistaprecio(idlistaprecio);
                    vencliente.setIdlistaprecio(venlistaprecio);
                    
                    venhistorialcliente venhistorialclienteobj = new venhistorialcliente();
                    venhistorialclienteobj.setIdhistorialcliente(idhistorialcliente);
                    vencliente.setIdhistorialcliente(venhistorialclienteobj);
                    
                    vencliente.setDescuento(descuento);
                    vencliente.setLimitecredito(limitecredito);
                    vencliente.setDiascredito(diascredito);
                    vencliente.setUltimopago(ultimopago);
                    
                    vencliente.setFechaultimopago(fechaultimopago);
                    vencliente.setClientedesde(clientedesde);
                    
                    venclienteDAO = new venclientesDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();
                    
                    
                    
                    try {
                        existecliente = venclienteDAO.verificaCliente(idcliente, rfc, "editar");
                        if (existecliente == 0) {
                            try {
                                boolean respuesta = venclienteDAO.EditaCliente(vencliente);
                                if (respuesta) {
                                    resp.setRespuesta(true);
                                    resp.setMensaje("Cliente Editado Correctamente");

                                } else {

                                    resp.setRespuesta(false);
                                    resp.setMensaje("Error al editar el cliente");

                                }

                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(venclientesSRV.class.getName()).log(Level.SEVERE, null, ex);
                                resp.setRespuesta(false);
                                resp.setMensaje("Error al editar el usuario , Consulte al Administrador");

                            }
                        } else {
                            resp.setRespuesta(false);
                            resp.setMensaje("El cliente " + idcliente + " ya existe, registra uno diferente");

                        }

                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(venclientesSRV.class.getName()).log(Level.SEVERE, null, ex);
                        resp.setRespuesta(false);
                        resp.setMensaje("Error al validar , Consulte al Administrador");

                    }
                    out.print(json.toJson(resp));
                    break;
                case "nuevo":

                    vencliente = new venclientes();
                    vencliente.setIdcliente(idcliente);
                    vencliente.setNombrecompleto(nombrecompleto);
                    vencliente.setNombres(nombres);
                    vencliente.setApellidopaterno(apellidopaterno);
                    vencliente.setApellidomaterno(apellidomaterno);
                    vencliente.setRfc(rfc);
                    vencliente.setCurp(curp);
                    vencliente.setCalle(calle);
                    vencliente.setNumexterior(numexterior);
                    vencliente.setNuminterior(numinterior);
                    vencliente.setColonia(colonia);
                    vencliente.setMunicipio(municipio);
                    vencliente.setCiudad(ciudad);
                    
                    conestados conestadonvo = new conestados();
                    conestadonvo.setIdestado(idestado);
                    vencliente.setIdestado(conestadonvo);
                    
                    vencliente.setPais(pais);
                    vencliente.setCp(cp);
                    
                    ventiposclientes ventipoclientenvo = new ventiposclientes();
                    ventipoclientenvo.setIdtipocliente(idtipocliente);
                    vencliente.setIdtipocliente(ventipoclientenvo);
                    
                    venterminospago venterminopagonvo = new venterminospago();
                    venterminopagonvo.setIdterminopago(idterminopago);
                    vencliente.setIdterminopago(venterminopagonvo);
                    
                    venmetodospago venmetodopagonvo = new venmetodospago();
                    venmetodopagonvo.setIdmetodopago(idmetodopago);
                    vencliente.setIdmetodopago(venmetodopagonvo);
                    
                    venlistasprecios venlistaprecionvo = new venlistasprecios();
                    venlistaprecionvo.setIdlistaprecio(idlistaprecio);
                    vencliente.setIdlistaprecio(venlistaprecionvo);
                    
                    venhistorialcliente venhistorialclienteobjnvo = new venhistorialcliente();
                    venhistorialclienteobjnvo.setIdhistorialcliente(idhistorialcliente);
                    vencliente.setIdhistorialcliente(venhistorialclienteobjnvo);
                    
                    vencliente.setDescuento(descuento);
                    vencliente.setLimitecredito(limitecredito);
                    vencliente.setDiascredito(diascredito);
                    vencliente.setUltimopago(ultimopago);
                    
                    vencliente.setFechaultimopago(fechaultimopago);
                    vencliente.setClientedesde(clientedesde);
                    
                    venclienteDAO = new venclientesDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();
                    
                    
                    
                    try {

                        existecliente = venclienteDAO.verificaCliente(idcliente, rfc, "nuevo");
                        if (existecliente == 0) {
                            try {
                                boolean respuesta = venclienteDAO.CrearClientes(vencliente);
                                if (respuesta) {
                                    resp.setRespuesta(true);
                                    resp.setMensaje("Cliente Registrado Correctamente");
                                    //out.print(json.toJson(resp));
                                } else {

                                    resp.setRespuesta(false);
                                    resp.setMensaje("Error al Registrar el cliente");
                                    //out.print(json.toJson(resp));

                                }

                            } catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(venclientesSRV.class.getName()).log(Level.SEVERE, null, ex);
                                resp.setRespuesta(false);
                                resp.setMensaje("Error al registrar el cliente , Consulte al Administrador");
                                //out.print(json.toJson(resp));
                            }
                        } else {
                            resp.setRespuesta(false);
                            resp.setMensaje("El cliente " + idcliente + " ya existe, registra uno diferente");
                            //out.print(json.toJson(resp));
                        }

                    } catch (ClassNotFoundException | SQLException ex) {
                        resp.setRespuesta(false);
                        resp.setMensaje("Error al validar , Consulte al Administrador");

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
