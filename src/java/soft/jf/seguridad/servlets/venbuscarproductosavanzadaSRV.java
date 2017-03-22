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
import soft.jf.seguridad.dao.venbuscarproductosDAO;
import soft.jf.seguridad.dao.venclientesDAO;
import soft.jf.seguridad.modelos.invproductos;
import soft.jf.seguridad.modelos.venclientes;
import soft.jf.seguridad.utils.MsgRespuesta;

/**
 *
 * @author jbarrientos
 */
public class venbuscarproductosavanzadaSRV extends HttpServlet {

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
            
            String idproducto = request.getParameter("idproducto");
            String descripcion = request.getParameter("descripcion");
            
            
            Gson json;
            MsgRespuesta resp;
            venclientes cliente;
            ArrayList<invproductos> lista;
            venbuscarproductosDAO dao;
            int existe;
            
            String data = "<thead> ";
            data = data + "<tr> ";
            data = data + "<th></th> ";
            data = data + "<th>idProducto</th> ";
            data = data + "<th>Categoria</th> ";
            data = data + "<th>Descripcion</th> ";
            data = data + "<th>Costo</th> ";
            data = data + "<th>U.Medida</th> ";
            data = data + "</tr> ";           
            data = data + "</thead> ";
            
           

            data = data + "<tbody>";
            
            String  selecciona = "";
            dao = new venbuscarproductosDAO();
            lista = new ArrayList<>();
            try {
                lista = dao.consultarproductosavanzado(idproducto, descripcion);
                 for (invproductos obj : lista) {
                         
                           selecciona = "<a  href='#' ><button id='" + obj.getIdproducto() + "'  onclick='seleccionap(this,event);' class='btn btn-primary btn-xs'><i class='fa fa-file-powerpoint-o' aria-hidden='true'></i></button></a>";
                           data = data + " <tr> ";
                           data = data + " <td>" + selecciona + "</td>";
                           data = data + " <td>" + obj.getIdproducto() + "</td>";
                           data = data + " <td>" + obj.getIdcategoria().getCategoria() + "</td>";
                           data = data + " <td>" + obj.getDescripcion() + "</td>";
                           data = data + " <td>" + obj.getCostoactual() + "</td>";
                           data = data + " <td>" + obj.getIdunidadmedida().getUnidadmedida() + "</td>";
                           
                           data = data + " </tr>";
                           
                 }
                 data = data + "</tbody>";
                 out.println(data);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(venbuscarproductosavanzadaSRV.class.getName()).log(Level.SEVERE, null, ex);
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
