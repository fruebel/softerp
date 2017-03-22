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
import soft.jf.seguridad.dao.segUsuariosDAO;
import soft.jf.seguridad.dao.venclientesDAO;
import soft.jf.seguridad.modelos.Segusuarios;
import soft.jf.seguridad.modelos.venclientes;
import soft.jf.seguridad.utils.MsgRespuesta;

/**
 *
 * @author jbarrientos
 */
public class venbuscaclientesSRV extends HttpServlet {

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
            
            String txtcliente = request.getParameter("txtcliente");
            String txtrfc = request.getParameter("txtrfc");
            
            
            Gson json;
            MsgRespuesta resp;
            venclientes cliente;
            ArrayList<venclientes> lista;
            venclientesDAO dao;
            int existe;
            
            String data = "<thead> ";
            data = data + "<tr> ";
            data = data + "<th></th> ";
            data = data + "<th>Nombre</th> ";
            data = data + "<th>Rfc</th> ";
            data = data + "<th>Direccion</th> ";
            data = data + "<th>Ciudad</th> ";
            data = data + "<th>Estado</th> ";
            data = data + "</tr> ";           
            data = data + "</thead> ";
            
           

            data = data + "<tbody>";
            
            String  selecciona = "";
            dao = new venclientesDAO();
            lista = new ArrayList<>();
            try {
                lista = dao.consultar(txtcliente, txtrfc);
                 for (venclientes obj : lista) {
                         
                           selecciona = "<a  href='#' ><button id='" + obj.getIdcliente() + "|"+ obj.getNombrecompleto() + "'  onclick='selecciona(this,event);' class='btn btn-primary btn-xs'><i class='fa fa-user' aria-hidden='true'></i></button></a>";
                           data = data + " <tr> ";
                           data = data + " <td>" + selecciona + "</td>";
                           data = data + " <td>" + obj.getNombrecompleto() + "</td>";
                           data = data + " <td>" + obj.getRfc() + "</td>";
                           data = data + " <td>" + obj.getCalle() + "</td>";
                           data = data + " <td>" + obj.getCiudad() + "</td>";
                           data = data + " <td>" + obj.getEstado() + "</td>";
                           data = data + " </tr>";
                           
                 }
                 data = data + "</tbody>";
                 out.println(data);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(venbuscaclientesSRV.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
