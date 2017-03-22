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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import soft.jf.seguridad.dao.venbuscarproductosDAO;
import soft.jf.seguridad.modelos.invproductos;
import soft.jf.seguridad.modelos.invtempproducto;

/**
 *
 * @author jbarrientos
 */
public class venbuscarproductosSRV extends HttpServlet {

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
            
            String name = request.getParameter("name");
            JSONArray jsonArr = new JSONArray();
            JSONObject json = new JSONObject();
            ArrayList<invtempproducto> lista = new ArrayList<>();
            venbuscarproductosDAO dao = new venbuscarproductosDAO();
            double iva=0;
            
            HttpSession session = request.getSession(true);
            String sessionUsuario = (String) session.getAttribute("sessionUsuaurio");
            int idsucursal = (int) session.getAttribute("idsucursal");
            
            try {
                lista = dao.consultarproductos(name,sessionUsuario,idsucursal);
                
                json.put("value", "");                
                for (invtempproducto data : lista) {
                    if (data.getIdproducto().toLowerCase().contains(name)) {
                        json.put("name", data.getIdproducto());
                        json.put("value", data.getIdproducto());
                        json.put("precio", data.getPrecio());
                        json.put("stock", data.getStock());
                        json.put("cantidad", data.getCantidad());
                        json.put("codigo", data.getCodigo());
                        json.put("nombreproducto", data.getNombreproducto());
                        json.put("preciounitario", data.getPreciounitario());
                        json.put("total", data.getTotal());   
                        json.put("almacen", data.getAlmacen());
                        json.put("idtipoimpuesto", data.getIdtipoimpuesto().getIdtipoimpuesto());
                        json.put("tipoimpuesto", data.getIdtipoimpuesto().getTipoimpuesto());
                        json.put("porcentaje", data.getIdtipoimpuesto().getPorcentaje());
                        iva = data.getIdtipoimpuesto().getPorcentaje()* Double.parseDouble(data.getPreciounitario());
                        json.put("iva", iva);
                        jsonArr.add(json);
                    }
                     
                }
                
                out.println(jsonArr);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(venbuscarproductosSRV.class.getName()).log(Level.SEVERE, null, ex);
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
