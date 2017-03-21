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
import soft.jf.seguridad.modelos.Segcategorias;
import soft.jf.seguridad.modelos.Segfunciones;
import soft.jf.seguridad.modelos.Segmodulos;
import soft.jf.seguridad.modelos.Segperfiles;
import soft.jf.seguridad.modelos.Segusuarios;

/**
 *
 * @author jbarrientos
 */
public class segPerfilesDAO {

    ConnectionFactory conexionFactory = new ConnectionFactory();
    GeneralesDAO generalesDAO;

    public ArrayList<Segperfiles> ConsultarPerfiles() throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<Segperfiles> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select * from seg_perfiles order by nombre";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta perfiles " + sql);
            if (rs != null) {

                while (rs.next()) {
                    Segperfiles perfiles = new Segperfiles();

                    perfiles.setIdperfil(rs.getInt("idperfil"));
                    perfiles.setPerfil(rs.getString("nombre"));
                    perfiles.setActivo(rs.getInt("activo"));

                    lista.add(perfiles);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }

    public ArrayList<Segperfiles> ConsultarPerfilesxId(String perfil) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<Segperfiles> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select * from seg_perfiles where idperfil="+perfil+" order by nombre";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println(sql);
            if (rs != null) {

                while (rs.next()) {
                    Segperfiles perfiles = new Segperfiles();

                    perfiles.setIdperfil(rs.getInt("idperfil"));
                    perfiles.setPerfil(rs.getString("nombre"));
                    perfiles.setActivo(rs.getInt("activo"));

                    lista.add(perfiles);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }

 
    public boolean Editar(Segperfiles perfil)throws ClassNotFoundException, SQLException{
        
     Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "update seg_perfiles set nombre='"+perfil.getPerfil()+"',activo="+perfil.getActivo()+" where "
                    + " idperfil="+perfil.getIdperfil();

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
    
    public boolean Crear(Segperfiles perfil)throws ClassNotFoundException, SQLException{
        
     Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "insert into seg_perfiles(nombre,activo) values ('"+perfil.getPerfil()+"',"+perfil.getActivo()+")";
            System.out.println(sql);
            boolean exitoso = conexionFactory.ejecutarSQL(sql);
            if (exitoso) {               
                conexionFactory.desconectar();
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }       
    
    public ArrayList<Segfunciones> ConsultarFunciones() throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<Segfunciones> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select f.*,m.titulo as modulo from seg_funciones f,seg_modulos m "
                    + "where f.idmodulo=m.idmodulo order by m.titulo";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println(sql);
            if (rs != null) {

                while (rs.next()) {
                    Segfunciones obj = new Segfunciones();

                    obj.setIdfuncion(rs.getInt("idfuncion"));
                    
                    
                    Segmodulos modulos = new Segmodulos();
                    modulos.setIdmodulo(rs.getInt("idmodulo"));
                    modulos.setTitulo(rs.getString("modulo"));
                    obj.setIdmodulo(modulos);
                    
                    
                    obj.setTitulo(rs.getString("titulo"));
                    obj.setActivo(rs.getInt("activo"));
                    obj.setUrl(rs.getString("url"));
                    
                    Segcategorias cate = new Segcategorias();
                    cate.setIdcategoria(rs.getInt("idcategoria"));
                    obj.setIdcategoria(cate);
                    
                    obj.setDescripcioncorta(rs.getString("descripcioncorta"));
                    obj.setOrden(rs.getInt("orden"));     
                    obj.setComentarios(rs.getString("comentarios"));
                    obj.setIdtipo(rs.getInt("idtipo"));
                    obj.setImagen(rs.getString("imagen"));
                    
                    lista.add(obj);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }
    
    public boolean verificafuncionxperfil(int idperfil,int idfuncion) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        boolean resultado = false;
        int existe=0;

        if (conexion != null) {

            String sql = "select count(*) as existe from seg_funcionxperfil where idfuncion="+idfuncion+" and idperfil="+idperfil;
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println(sql);
            if (rs != null) {

                while (rs.next()) {
                    existe = rs.getInt("existe");
                }

            }
            conexionFactory.desconectar();
        } else {
            return resultado;
        }

        if(existe>0)
            resultado=true;
        
        return resultado;

    }

    public int verificaPerfil(String perfil,String operacion)throws ClassNotFoundException, SQLException{
        
        Connection conexion = conexionFactory.conectar();
        int numero_registros = 0;
        String sql;
        if (operacion.equals("nuevo")) {
            sql = "select count(*) as existe from seg_perfiles where nombre='" + perfil + "'";
        } else {
            sql = "select count(*) as existe from seg_perfiles where nombre='" + perfil + "' and nombre<>'" + perfil + "'";
        }

        if (conexion != null) {
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);
            if (rs != null) {
                while (rs.next()) {
                    numero_registros = rs.getInt("existe");
                }
            }
        }
        return numero_registros;
        
    }
    
    
    public boolean EditaPerfil(Segperfiles perfil,String[] chkfunciones)throws ClassNotFoundException, SQLException{
        
     Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "update seg_perfiles set nombre='"+perfil.getPerfil()+"',activo="+perfil.getActivo()+" where "
                    + " idperfil="+perfil.getIdperfil();

            System.out.println(sql);

            boolean exitoso = conexionFactory.ejecutarSQL(sql);
        
            if (exitoso) {
                conexionFactory.ejecutarSQL("delete from seg_funcionxperfil where idperfil="+perfil.getIdperfil());
                for (int i=0;i<chkfunciones.length;i++){
                    sql = "insert into seg_funcionxperfil(idperfil,idfuncion) values ("+perfil.getIdperfil()+","+chkfunciones[i]+")";
                    System.out.println(sql);
                    conexionFactory.ejecutarSQL(sql);
                }
                conexionFactory.desconectar();
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
   
     public boolean CreaPerfil(Segperfiles perfil,String[] chkfunciones)throws ClassNotFoundException, SQLException{
        
     Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "insert into seg_perfiles(nombre,activo) values ('"+perfil.getPerfil()+"',"+perfil.getActivo()+")";
            System.out.println(sql);

            boolean exitoso = conexionFactory.ejecutarSQL(sql);
            
        
            if (exitoso) {
                generalesDAO = new GeneralesDAO();
                int idperfil = generalesDAO.regresaIdRegistrado("seg_perfiles", "idperfil");
                conexionFactory.ejecutarSQL("delete from seg_funcionxperfil where idperfil="+idperfil);
                for (int i=0;i<chkfunciones.length;i++){
                    sql = "insert into seg_funcionxperfil(idperfil,idfuncion) values ("+idperfil+","+chkfunciones[i]+")";
                    System.out.println(sql);
                    conexionFactory.ejecutarSQL(sql);
                }
                conexionFactory.desconectar();
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }   
    //
}
