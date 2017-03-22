/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import soft.jf.seguridad.bd.ConnectionFactory;
import soft.jf.seguridad.modelos.venclientes;

/**
 *
 * @author jbarrientos
 */
public class venclientesDAO {
    
    ConnectionFactory conexionFactory = new ConnectionFactory();
    
    public ArrayList<venclientes> consultar() throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<venclientes> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "SELECT c.idcliente, c.nombrecompleto, c.nombres, c.apellidopaterno, c.apellidomaterno, c.rfc, c.curp,"
                    + "c.calle, c.numexterior, c.numinterior, c.colonia, c.municipio, c.ciudad, c.idestado, c.pais, c.cp"
                    + " FROM venclientes c"
                    + " ORDER BY c.idcliente asc ";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta clientes " + sql);
            if (rs != null) {

                while (rs.next()) {
                    venclientes vencliente = new venclientes();

                    vencliente.setIdcliente(rs.getString("idcliente"));
                    vencliente.setNombrecompleto(rs.getString("nombrecompleto"));
                    vencliente.setNombres(rs.getString("nombres"));
                    vencliente.setApellidopaterno(rs.getString("apellidopaterno"));
                    vencliente.setApellidomaterno(rs.getString("apellidomaterno"));
                    vencliente.setRfc(rs.getString("rfc"));
                    vencliente.setCurp(rs.getString("curp"));
                    vencliente.setCalle(rs.getString("calle"));
                    vencliente.setNumexterior(rs.getString("numexterior"));
                    vencliente.setNuminterior(rs.getString("numinterior"));
                    vencliente.setColonia(rs.getString("colonia"));
                    vencliente.setMunicipio(rs.getString("municipio"));
                    vencliente.setCiudad(rs.getString("ciudad"));
                    vencliente.setEstado(rs.getString("idestado"));
                    vencliente.setPais(rs.getString("pais"));
                    vencliente.setCp(rs.getString("cp"));

                    

                    lista.add(vencliente);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }
    public ArrayList<venclientes> consultar(String nombre,String rfc) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<venclientes> lista = new ArrayList<>();

        if (conexion != null) {

            String where= "";     
            if (!nombre.isEmpty())
                where = where + "nombrecompleto like '"+nombre+"%'";
            if (!rfc.isEmpty() && nombre.isEmpty())
                 where = where + "rfc like '"+rfc+"%'";   
            else if(!rfc.isEmpty() && (!nombre.isEmpty())) 
                where = where + "or rfc like '"+rfc+"%'";   
            
            String sql = "SELECT c.idcliente, c.nombrecompleto, c.nombres, c.apellidopaterno, c.apellidomaterno, c.rfc, c.curp,"
                    + "c.calle, c.numexterior, c.numinterior, c.colonia, c.municipio, c.ciudad, c.idestado, c.pais, c.cp"
                    + " FROM venclientes c where " + where
                    + " ORDER BY c.idcliente asc ";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta clientes " + sql);
            if (rs != null) {

                while (rs.next()) {
                    venclientes vencliente = new venclientes();

                    vencliente.setIdcliente(rs.getString("idcliente"));
                    vencliente.setNombrecompleto(rs.getString("nombrecompleto"));
                    vencliente.setNombres(rs.getString("nombres"));
                    vencliente.setApellidopaterno(rs.getString("apellidopaterno"));
                    vencliente.setApellidomaterno(rs.getString("apellidomaterno"));
                    vencliente.setRfc(rs.getString("rfc"));
                    vencliente.setCurp(rs.getString("curp"));
                    vencliente.setCalle(rs.getString("calle"));
                    vencliente.setNumexterior(rs.getString("numexterior"));
                    vencliente.setNuminterior(rs.getString("numinterior"));
                    vencliente.setColonia(rs.getString("colonia"));
                    vencliente.setMunicipio(rs.getString("municipio"));
                    vencliente.setCiudad(rs.getString("ciudad"));
                    vencliente.setEstado(rs.getString("idestado"));
                    vencliente.setPais(rs.getString("pais"));
                    vencliente.setCp(rs.getString("cp"));

                    

                    lista.add(vencliente);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }

}
