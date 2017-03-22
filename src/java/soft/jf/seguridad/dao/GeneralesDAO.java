/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import soft.jf.seguridad.bd.ConnectionFactory;

/**
 *
 * @author jbarrientos
 * throws ClassNotFoundException exepcion de clase no encontrada
 */
public class GeneralesDAO {

    ConnectionFactory conexionFactory = new ConnectionFactory();

    public String regresaCombo(String tabla, String where, String id, String texto) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        String contenido = "";
        String query = "select " + id + " as id," + texto + " as texto from " + tabla + " where " + where + "  order by " + texto + " asc";
        System.out.println(query);
        if (conexion != null) {
            ResultSet rs = conexionFactory.ejecutarConsulta(query);
            String s;
            if (rs != null) {
                
                while (rs.next()) {   
                    contenido += "<option  value='" + rs.getString("id") + "'>" + rs.getString("texto") + "</option>";
                }
            }
        }

        return contenido;
    }
    
    public int regresaIdRegistrado(String tabla,String id) throws ClassNotFoundException, SQLException{
    
        Connection conexion = conexionFactory.conectar();
        int identity=0;
        String query = "select " + id + " as id from " + tabla + " order by " + id + " desc limit 1";
        System.out.println(query);
        
        if (conexion != null) {  
            ResultSet rs = conexionFactory.ejecutarConsulta(query);
            while (rs.next()){
                identity = rs.getInt("id");
            }
        }
        
        return identity;
    }

}
