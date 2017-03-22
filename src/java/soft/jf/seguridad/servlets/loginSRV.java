/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.servlets;

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
import soft.jf.seguridad.modelos.Datavariablessession;

/**
 *
 * @author jbarrientos
 */
public class loginSRV extends HttpServlet {

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

            String usuario = request.getParameter("usuario");
            String contrasenia = request.getParameter("password");
           
            
            segUsuariosDAO accesoDAO = new segUsuariosDAO();
            try {
                ArrayList<Datavariablessession> respuesta = accesoDAO.validaUsuario(usuario, contrasenia);
                
                
                for (Datavariablessession datavariablessession : respuesta) {
                
                    if (datavariablessession.getRespuesta().isEmpty()) {  //Crea las variables de session
                    
                    HttpSession session = request.getSession(true);
                    session.setAttribute("sessionUsuaurio", datavariablessession.getIdusuario());
                    session.setAttribute("sessionNombreusuario", datavariablessession.getNombreUsuario());
                    session.setAttribute("idsucursal", datavariablessession.getIdsucursal().getIdsucursal());
                    session.setAttribute("sucursal", datavariablessession.getIdsucursal().getSucursal());
                    System.out.println("---"+datavariablessession.getIdsucursal().getSucursal());
                    accesoDAO.actualizaultimoacceso(datavariablessession.getIdusuario());
                   
                    }
                
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");             
                    response.getWriter().write(datavariablessession.getRespuesta());
                    
                }
                
                
               
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(loginSRV.class.getName()).log(Level.SEVERE, null, ex);
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
