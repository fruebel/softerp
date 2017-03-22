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
import soft.jf.seguridad.modelos.Estadosusuarios;
import soft.jf.seguridad.modelos.Segperfiles;
import soft.jf.seguridad.modelos.Segusuarios;

/**
 *
 * @author jbarrientos
 */
public class templateDAO {
    
     ConnectionFactory conexionFactory = new ConnectionFactory();
     
     
      public boolean crea(Segusuarios obj) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "insert into seg_usuarios(idUsuario,idUsuarioRegistro,idEstado,superusuario,contrasenia,nombre,apellidopaterno,apellidomaterno,fotografia,telefono"
                    + ",email,tema,lenguaje,ultimaactualizacion,fecharegistro,ultimoacceso,idperfil) ";
            sql += " values ('" + obj.getIdUsuario()+""; 
                   
            System.out.println(sql);

            boolean exitoso = conexionFactory.ejecutarSQL(sql);
            conexionFactory.desconectar();

            if (exitoso) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
    
      
    public boolean actualiza(Segusuarios obj) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "update xx set = xxx ";
            sql += " values ('" + obj.getIdUsuario()+""; 
                   
            System.out.println(sql);

            boolean exitoso = conexionFactory.ejecutarSQL(sql);
            conexionFactory.desconectar();

            if (exitoso) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
    
    public ArrayList<Segusuarios> consulta() throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<Segusuarios> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select u.*,e.estado,p.nombre as perfil from seg_usuarios u,estados_usuarios e,seg_perfiles p "
                    + "where u.idestado = e.idestado and u.idperfil=p.idperfil  order by e.idestado asc ";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta usuarios " + sql);
            if (rs != null) {

                while (rs.next()) {
                    Segusuarios usuario = new Segusuarios();
                    usuario.setIdUsuario(rs.getString("idusuario"));
                    
                    lista.add(usuario);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }    

    public ArrayList<Segusuarios> consulta(String idUsuario) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<Segusuarios> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select u.*,e.estado,p.nombre as perfil from seg_usuarios u,estados_usuarios e,seg_perfiles p "
                    + "where u.idestado = e.idestado and u.idperfil=p.idperfil and u.idusuario='" + idUsuario + "' order by e.idestado asc ";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta usuarios " + sql);
            if (rs != null) {

                while (rs.next()) {
                    Segusuarios usuario = new Segusuarios();
                    usuario.setIdUsuario(rs.getString("idusuario"));
                    
                    lista.add(usuario);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }       
}
