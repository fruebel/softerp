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
import soft.jf.seguridad.dao.conmonedasDAO;
import soft.jf.seguridad.modelos.conmonedas;
import soft.jf.seguridad.utils.MsgRespuesta;

/**
 * 
 * @author Paul
 * Catalogo para configuracion de monedas
 * retur  regresa lista de monedas, al igual  verdadero o falso para la actualizacion o insercion de datos
 * fecha  
 * modifico
 */

public class conmonedasSRV extends HttpServlet {

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

            String action = request.getParameter("action");
            String idrow = request.getParameter("idrow"); 
            String idmoneda = request.getParameter("Idmoneda");
            String moneda = request.getParameter("Moneda");
            String pais = request.getParameter("Pais");
            String tipodecambio = request.getParameter("Tipodecambio");

            //HttpSession session = request.getSession(true);
            //String sessionUsuario = (String) session.getAttribute("sessionUsuaurio");

            Gson json;
            MsgRespuesta resp;
            conmonedas obj;
            ArrayList<conmonedas> lista;
            conmonedasDAO objDAO;

            String data = "";
            String botonEditar = "";
            int existe = 0;
            
            switch(action){
                case "listar":

                    data = "<thead> ";
                    data = data + "<tr> ";
                    data = data + "<th></th> ";
                    data = data + "<th>ID</th>";
                    data = data + "<th>Moneda</th>";
                    data = data + "<th>Pa&iacute;s</th> ";
                    data = data + "<th>Tipo de Cambio</th> ";
                    data = data + "</tr> ";
                    data = data + "</thead> ";
                    data = data + "<tbody>";

                    objDAO = new conmonedasDAO();
                    
                    try{
                        lista = objDAO.consulta_todo();
                        if(lista.size()>0){
                            for (conmonedas objmonedas : lista) {
                                botonEditar = "<button id='" + objmonedas.getIdmoneda()+ "' class='btn btn-primary btn-xs btneditar' rel='tooltip' data-placement='top' title='Editar registro'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></button>";
                                data = data + " <tr> ";
                                data = data + " <td>" + botonEditar + "</td>";
                                data = data + " <td>" + objmonedas.getIdmoneda()+ "</td>";
                                data = data + " <td>" + objmonedas.getMoneda() + "</td>";
                                data = data + " <td>" + objmonedas.getPais() + "</td>";
                                data = data + " <td>" + objmonedas.getTipodecambio() + "</td>";
                                data = data + " </tr>";
                            }
                        }else{
                            data = data + " <tr> ";
                            data = data + " <td class='text-center' colspan='5' > Aún no hay información para mostrar. </td>";
                            data = data + " </tr>";
                        }                        
                        data = data + "</tbody>";
                        data = data + "<tfoot> ";
                        data = data + "<tr> ";
                        data = data + "</tr> ";
                        data = data + "</tfoot>";
                        out.println(data);
                        
                    }catch(ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(conmonedasSRV.class.getName()).log(Level.SEVERE, null, ex);
                        out.print("(BD:erx002) Error dentro del sistema, intete nuevamente o comuniquese con Administración." + ex.getMessage());
                    }

                    break;
                    
                case "consulta":
                   
                    obj = new conmonedas();
                    obj.setIdmoneda(idrow);
                    
                    json = new Gson();
                    objDAO = new conmonedasDAO();
                    lista = new ArrayList<>();

                    try {
                        lista = objDAO.consulta(obj);   
                    }catch(ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                        out.print("(BD:erx002) Error dentro del sistema, intete nuevamente o comuniquese con Administración." + ex.getMessage());
                    }
                    
                    out.print(json.toJson(lista));
                    break;
                    
                case "nuevo":

                    obj = new conmonedas();
                    obj.setIdmoneda(idmoneda);
                    obj.setMoneda(moneda);
                    obj.setPais(pais);
                    obj.setTipodecambio(tipodecambio);
                            
                    objDAO = new conmonedasDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();
                    
                    try{
                        existe = objDAO.verifica(obj,"nuevo");
                        if(existe == 0){
                            try{
                                boolean respuesta = objDAO.crea(obj);
                                if (respuesta) {
                                    resp.setRespuesta(true);
                                    resp.setMensaje("Monto Monetario Registrado Correctamente.");
                                }else{
                                    resp.setRespuesta(false);
                                    resp.setMensaje("No pudo registrarse el Monto Monetario.");
                                }
                            }catch (ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                                resp.setRespuesta(false);
                                resp.setMensaje("(BD:erx001) Error al registrar el Monto Monetario.");
                            }
                        }else{
                            resp.setRespuesta(false);
                            resp.setMensaje("(BD:erx001D)El Monto Monetario ya existe, intete nuevamente modificando los datos. .");
                        }
                    }catch(ClassNotFoundException | SQLException ex) {
                        resp.setRespuesta(false);
                        resp.setMensaje("(Sys:erx001) Error dentro del sistema, intete nuevamente o comuniquese con Administración.");
                    }
                    out.print(json.toJson(resp));
                    break;
                    
                case "editar":

                    obj = new conmonedas();
                    obj.setIdmoneda(idmoneda);
                    obj.setMoneda(moneda);
                    obj.setPais(pais);
                    obj.setTipodecambio(tipodecambio);
                            
                    objDAO = new conmonedasDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();

                    try{
                        boolean respuesta = objDAO.actualiza(obj);
                        if (respuesta) {
                            resp.setRespuesta(true);
                            resp.setMensaje("Monto Monetario actualizado correctamente.");
                        }else{
                            resp.setRespuesta(false);
                            resp.setMensaje("No pudo actualizarse el Monto Monetario.");
                        }
                    }catch(ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                        resp.setRespuesta(false);
                        resp.setMensaje("(BD:erx003) Error al actualizar el Monto Monetario.");
                    }
                    out.print(json.toJson(resp));
                    break;

                case "eliminar":
                    
                    obj = new conmonedas();
                    obj.setIdmoneda(idmoneda);
                    obj.setMoneda(moneda);
                    obj.setPais(pais);
                    obj.setTipodecambio(tipodecambio);
                    
                    objDAO = new conmonedasDAO();
                    resp = new MsgRespuesta();
                    json = new Gson();
                    try {
                        boolean respuesta =  objDAO.elimina(obj);
                        if (respuesta) {
                            resp.setRespuesta(true);
                            resp.setMensaje("Monto Monetario fue eliminado correctamente.");
                        }else{
                            resp.setRespuesta(false);
                            resp.setMensaje("No pudo eliminarse el Monto Monetario.");
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(permisosSRV.class.getName()).log(Level.SEVERE, null, ex);
                        out.print("(BD:erx004) Error dentro del sistema, intete nuevamente o comuniquese con Administración." + ex.getMessage());
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
