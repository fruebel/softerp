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
import soft.jf.seguridad.modelos.Datavariablessession;
import soft.jf.seguridad.modelos.Estadosusuarios;
import soft.jf.seguridad.modelos.Segperfiles;
import soft.jf.seguridad.modelos.Segusuarios;
import soft.jf.seguridad.modelos.consucursales;

/**
 *
 * @author jbarrientos
 */
public class segUsuariosDAO {

    ConnectionFactory conexionFactory = new ConnectionFactory();

    public boolean CrearUsuario(Segusuarios usuario) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "insert into seg_usuarios(idUsuario,idUsuarioRegistro,idEstado,superusuario,contrasenia,nombre,apellidopaterno,apellidomaterno,fotografia,telefono"
                    + ",email,tema,lenguaje,ultimaactualizacion,fecharegistro,ultimoacceso,idperfil) ";
            sql += " values ('" + usuario.getIdUsuario() + "','" + usuario.getIdUsuarioRegistro() + "','" + usuario.getIdEstado().getIdestado() + "','" + usuario.getSuperusuario() + "','" + usuario.getContrasenia() + "','" + usuario.getNombre()
                    + "','" + usuario.getApellidoPaterno() + "','" + usuario.getApellidoMaterno() + "','" + usuario.getFotografia() + "','" + usuario.getTelefono()
                    + "','" + usuario.getEmail() + "','" + usuario.getTema() + "','" + usuario.getLenguaje() + "',now(),now(),now()," + usuario.getIdperfil().getIdperfil() + ")";

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

    public boolean EditaUsuario(Segusuarios usuario) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "update seg_usuarios set idEstado='" + usuario.getIdEstado().getIdestado() + "',contrasenia='" + usuario.getContrasenia() + "',"
                    + "nombre='" + usuario.getNombre() + "',apellidopaterno='" + usuario.getApellidoPaterno() + "',"
                    + "apellidomaterno='" + usuario.getApellidoMaterno() + "',fotografia='" + usuario.getFotografia() + "',"
                    + "telefono='" + usuario.getTelefono() + "'"
                    + ",email='" + usuario.getEmail() + "',tema='" + usuario.getTema() + "',lenguaje='" + usuario.getLenguaje() + "',"
                    + "ultimaactualizacion=now() where idUsuario='" + usuario.getIdUsuario() + "'";

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

    public ArrayList<Segusuarios> ConsultarUsuarios() throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<Segusuarios> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select u.*,e.estado,p.nombre as perfil from seg_usuarios u,estados_usuarios e,seg_perfiles p "
                    + "where u.idestado = e.idestado and u.idperfil=p.idperfil order by e.idestado asc ";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta usuarios " + sql);
            if (rs != null) {

                while (rs.next()) {
                    Segusuarios usuario = new Segusuarios();

                    usuario.setIdUsuario(rs.getString("idusuario"));
                    usuario.setContrasenia(rs.getString("contrasenia"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellidoPaterno(rs.getString("apellidopaterno"));
                    usuario.setApellidoMaterno(rs.getString("apellidomaterno"));
                    usuario.setFotografia(rs.getString("fotografia"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setUltimoAcceso(rs.getDate("ultimoacceso"));

                    Estadosusuarios estadousuario = new Estadosusuarios();
                    estadousuario.setIdestado(rs.getInt("idestado"));
                    estadousuario.setEstado(rs.getString("estado"));
                    usuario.setIdEstado(estadousuario);

                    Segperfiles perfil = new Segperfiles();
                    perfil.setPerfil(rs.getString("perfil"));
                    perfil.setIdperfil(rs.getInt("idperfil"));
                    usuario.setIdperfil(perfil);

                    usuario.setTema(rs.getString("tema"));
                    usuario.setLenguaje(rs.getString("lenguaje"));
                    usuario.setUltimaActualizacion(rs.getDate("ultimaactualizacion"));
                    usuario.setFechaRegistro(rs.getDate("fecharegistro"));
                    usuario.setIdUsuarioRegistro(rs.getString("idusuarioregistro"));
                    usuario.setSuperusuario(rs.getInt("superusuario"));

                    lista.add(usuario);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }

    public ArrayList<Segusuarios> ConsultarUsuariosxId(String idUsuario) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<Segusuarios> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "select u.*,e.estado,p.nombre as perfil from seg_usuarios u,estados_usuarios e,seg_perfiles p "
                    + "where u.idestado = e.idestado and u.idperfil=p.idperfil and u.idusuario='" + idUsuario + "' order by e.idestado asc ";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println(sql);
            if (rs != null) {

                while (rs.next()) {
                    Segusuarios usuario = new Segusuarios();

                    usuario.setIdUsuario(rs.getString("idusuario"));
                    usuario.setContrasenia(rs.getString("contrasenia"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellidoPaterno(rs.getString("apellidopaterno"));
                    usuario.setApellidoMaterno(rs.getString("apellidomaterno"));
                    usuario.setFotografia(rs.getString("fotografia"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setUltimoAcceso(rs.getDate("ultimoacceso"));

                    Estadosusuarios estadousuario = new Estadosusuarios();
                    estadousuario.setIdestado(rs.getInt("idestado"));
                    estadousuario.setEstado(rs.getString("estado"));
                    usuario.setIdEstado(estadousuario);

                    Segperfiles perfil = new Segperfiles();
                    perfil.setPerfil(rs.getString("perfil"));
                    perfil.setIdperfil(rs.getInt("idperfil"));
                    usuario.setIdperfil(perfil);

                    usuario.setTema(rs.getString("tema"));
                    usuario.setLenguaje(rs.getString("lenguaje"));
                    usuario.setUltimaActualizacion(rs.getDate("ultimaactualizacion"));
                    usuario.setFechaRegistro(rs.getDate("fecharegistro"));
                    usuario.setIdUsuarioRegistro(rs.getString("idusuarioregistro"));
                    usuario.setSuperusuario(rs.getInt("superusuario"));

                    lista.add(usuario);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }

    public ArrayList<Datavariablessession> validaUsuario(String usuario, String contrasenia) throws ClassNotFoundException, SQLException {

        //ConnectionFactory connectionfactory = new ConnectionFactory();
        Connection conexion = conexionFactory.conectar();
        ArrayList<Datavariablessession> lstRespuesta = new ArrayList<>();
        Datavariablessession sessiondata = new Datavariablessession();
        
        String existe = "";
        int existe1 = 0;

        if (conexion != null) {

            //valida nombre de usuario
            String sql = "select count(*) as existe from seg_usuarios where idusuario='" + usuario + "' and idestado=1";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            if (rs != null) {
                while (rs.next()) {
                    existe1 = rs.getInt("existe");
                    if (existe1 > 0) {
                        existe = "";
                    } else {
                        existe = "Usuario No existe / Inactivo"; //usuario no existe
                        sessiondata.setRespuesta(existe);
                        lstRespuesta.add(sessiondata);
                        return lstRespuesta;
                    }
                }
            } else {
                existe = "Consulta de usuario vacia"; //consulta del usuario vacia 
                sessiondata.setRespuesta(existe);
                lstRespuesta.add(sessiondata);
                return lstRespuesta;
            }

            //valida contraseña
            if (existe.equals("")) {

                sql = "select count(*) as existe,concat(u.nombre , ' ', u.apellidopaterno , ' ', u.apellidomaterno) as nombreUsuario,"
                        + "s.sucursal,s.idsucursal as idsucursal "
                        + "from seg_usuarios u,consucursales s where u.contrasenia='" + contrasenia + "'"
                        + "and u.idsucursal=s.idsucursal limit 1";
                System.out.println(sql);    
                ResultSet rsc = conexionFactory.ejecutarConsulta(sql);
                if (rsc != null) {
                    while (rsc.next()) {
                        existe1 = rsc.getInt("existe");
                        if (existe1 > 0) {
                            existe = "";
                            sessiondata.setRespuesta(existe);
                            sessiondata.setIdusuario(usuario);
                            sessiondata.setNombreUsuario(rsc.getString("nombreUsuario"));
                            
                            consucursales sucursal = new consucursales();
                            sucursal.setIdsucursal(rsc.getInt("idsucursal"));
                            sucursal.setSucursal(rsc.getString("sucursal"));
                            
                            sessiondata.setIdsucursal(sucursal);
                            
                            
                        } else {
                            existe = "Error en contraseña"; //contraseña usuario no existe
                            sessiondata.setRespuesta(existe);
                            lstRespuesta.add(sessiondata);
                            return lstRespuesta;
                        }
                    }
                } else {
                    existe = "Consulta de usuario vacia"; //consulta del usuario vacia 
                    sessiondata.setRespuesta(existe);
                    lstRespuesta.add(sessiondata);
                    return lstRespuesta;
                }

            }

            /*if (existe.equals("")){

                                    sql = "select count(*) as existe from usuarios where contrasenia='"+contrasenia+"' "
                                                    + " and usuario= '"+usuario+"' ";

                                    ResultSet rsc = connectionfactory.ejecutarConsulta(sql);
                                    if (rsc != null) {
                                            if (rsc.next()) {
                                                    existe1 = rsc.getInt("existe");
                                                    if (existe1 > 0) {
                                                            existe = "";
                                                    } else {
                                                            existe = ""; //contraseña perfil no coincide
                                                            return existe;
                                                    }
                                            }	
                                    }
                                    else{
                                            existe = -7; //consulta del usuario vacia 
                                            return existe;
                                    }	

                            }*/
        } else {
            existe = "Error en conexion a base de datos"; //errror en conexion
             sessiondata.setRespuesta(existe);
        }
        lstRespuesta.add(sessiondata);
        return lstRespuesta;
    }

    public void actualizaultimoacceso(String usuario) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "update seg_usuarios set ultimoacceso=now() where idusuario='" + usuario + "'";
            boolean r = conexionFactory.ejecutarSQL(sql);

        }

    }

    public int verificaUsuario(String usuario, String operacion) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        int numero_registros = 0;
        String sql;
        if (operacion.equals("nuevo")) {
            sql = "select count(*) as existe from seg_usuarios where idusuario='" + usuario + "'";
        } else {
            sql = "select count(*) as existe from seg_usuarios where idusuario='" + usuario + "' and idusuario<>'" + usuario + "'";
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

}
