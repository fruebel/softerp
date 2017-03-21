/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.dao;

import soft.jf.seguridad.bd.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import soft.jf.seguridad.modelos.Segcategorias;
import soft.jf.seguridad.modelos.Segfunciones;
import soft.jf.seguridad.modelos.Segmodulos;

/**
 *
 * @author jbarrientos
 */
public class SegmodulosDAO {

    ConnectionFactory conexionFactory = new ConnectionFactory();

    public ArrayList<Segmodulos> listarMenuPrincipal() throws ClassNotFoundException, SQLException {

        //se realiza la conexion a la base de datos 
        Connection conexion = conexionFactory.conectar();

        ArrayList<Segmodulos> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select * from seg_modulos where activo = 1  order by orden";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            if (rs != null) {
                while (rs.next()) {
                    Segmodulos Segmodulos = new Segmodulos();

                    Segmodulos.setIdmodulo(rs.getInt("idmodulo"));
                    Segmodulos.setTitulo(rs.getString("titulo"));
                    Segmodulos.setUrl(rs.getString("url"));
                    Segmodulos.setActivo(rs.getInt("activo"));
                    Segmodulos.setOrden(rs.getInt("orden"));
                    Segmodulos.setDescripcioncorta(rs.getString("descripcioncorta"));
                    Segmodulos.setImagen(rs.getString("imagen"));
                    lista.add(Segmodulos);
                }
            }
            conexionFactory.desconectar();
        } else {
            return null;
        }
        return lista;
    }

    public ArrayList<Segfunciones> listarFuncionesXSubmenu(int idmodulo, String Susuario) throws ClassNotFoundException, SQLException {

        //se realiza la conexion a la base de datos 
        Connection conexion = conexionFactory.conectar();

        ArrayList<Segfunciones> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select f.*"
                    + "from seg_funciones f "
                    + "     INNER JOIN seg_funcionxperfil fp on f.idfuncion=fp.idfuncion"
                    + "     INNER JOIN seg_perfiles p on p.idperfil = fp.idperfil "
                    + "     INNER JOIN seg_usuarios pxu on pxu.idperfil = p.idperfil and pxu.idusuario='" + Susuario + "'"
                    + "where f.idmodulo=" + idmodulo + " and f.activo = 1 order by f.orden asc";

            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            if (rs != null) {
                while (rs.next()) {

                    Segfunciones funciones = new Segfunciones();
                    funciones.setIdfuncion(rs.getInt("idfuncion"));

                    Segmodulos sub = new Segmodulos();
                    sub.setIdmodulo(rs.getInt("idmodulo"));
                    funciones.setIdmodulo(sub);

                    funciones.setTitulo(rs.getString("titulo"));
                    funciones.setActivo(rs.getInt("activo"));
                    funciones.setUrl(rs.getString("url"));

                    Segcategorias cat = new Segcategorias();
                    cat.setIdcategoria(rs.getInt("idcategoria"));
                    funciones.setIdcategoria(cat);

                    funciones.setDescripcioncorta(rs.getString("descripcioncorta"));
                    funciones.setOrden(rs.getInt("orden"));
                    funciones.setIdtipo(rs.getInt("idtipo"));

                    lista.add(funciones);
                }
            }
            conexionFactory.desconectar();
        } else {
            return null;
        }
        return lista;
    }

    public int VerificaPaginaxUsuarios(String Susuario, int idfuncion) throws ClassNotFoundException, SQLException {

        //se realiza la conexion a la base de datos 
        Connection conexion = conexionFactory.conectar();
        int respuesta = 0;

        if (conexion != null) {

            String sql = "select f.*"
                    + "from seg_funciones f "
                    + "     INNER JOIN seg_funcionxperfil fp on f.idfuncion=fp.idfuncion"
                    + "     INNER JOIN seg_perfiles p on p.idperfil = fp.idperfil "
                    + "     INNER JOIN seg_usuarios pxu on pxu.idperfil = p.idperfil and pxu.idusuario='" + Susuario + "'"
                    + "where f.activo = 1 and f.idfuncion=" + idfuncion;

            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            if (rs.last()) {
                respuesta = 1;
            }
            conexionFactory.desconectar();
        } else {
            return respuesta;
        }
        return respuesta;
    }

}
