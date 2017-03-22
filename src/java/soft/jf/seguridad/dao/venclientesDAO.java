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
import soft.jf.seguridad.modelos.venclientes;
import soft.jf.seguridad.modelos.conestados;
import soft.jf.seguridad.modelos.ventiposclientes;
import soft.jf.seguridad.modelos.venterminospago;
import soft.jf.seguridad.modelos.venmetodospago;
import soft.jf.seguridad.modelos.venlistasprecios;
import soft.jf.seguridad.modelos.venhistorialcliente;
import soft.jf.seguridad.modelos.venclientes;



import soft.jf.seguridad.bd.ConnectionFactory;

/**
 *
 * @author jbarrientos
 */
public class venclientesDAO {
    
    ConnectionFactory conexionFactory = new ConnectionFactory();
    
    public boolean CrearClientes(venclientes vencliente) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();

        if (conexion != null) {
            
            

            String sql = "INSERT INTO venclientes(idcliente, nombrecompleto, nombres, apellidopaterno, apellidomaterno, rfc, curp, calle, "
                    + "numexterior, numinterior, colonia, municipio, ciudad, idestado, pais, cp, idtipocliente, idterminopago, idmetodopago, "
                    + "idlistaprecio, idhistorialcliente, descuento, limitecredito, diascredito, ultimopago, fechaultimopago, clientedesde)";
            sql += " VALUES ('" + vencliente.getIdcliente() + "'" 
                    + ",'" + vencliente.getNombrecompleto() + "'" 
                    + ",'" + vencliente.getNombres() + "'" 
                    + ",'" + vencliente.getApellidopaterno() + "'" 
                    + ",'" + vencliente.getApellidomaterno() + "'" 
                    + ",'" + vencliente.getRfc() + "'" 
                    + ",'" + vencliente.getCurp() + "'" 
                    + ",'" + vencliente.getCalle() + "'" 
                    + ",'" + vencliente.getNumexterior() + "'" 
                    + ",'" + vencliente.getNuminterior() + "'" 
                    + ",'" + vencliente.getColonia() + "'" 
                    + ",'" + vencliente.getMunicipio() + "'" 
                    + ",'" + vencliente.getCiudad() + "'" 
                    + ",'" + vencliente.getIdestado().getIdestado() + "'" 
                    + ",'" + vencliente.getPais() + "'" 
                    + ",'" + vencliente.getCp() + "'"
                    + ",'" + vencliente.getIdtipocliente().getIdtipocliente() + "'"
                    + ",'" + vencliente.getIdterminopago().getIdterminopago() + "'"
                    + ",'" + vencliente.getIdmetodopago().getIdmetodopago() + "'"
                    + ",'" + vencliente.getIdlistaprecio().getIdlistaprecio() + "'"
                    + ",'" + vencliente.getIdhistorialcliente().getIdhistorialcliente() + "'"
                    + ",'" + vencliente.getDescuento() + "'"
                    + ",'" + vencliente.getLimitecredito() + "'"
                    + ",'" + vencliente.getDiascredito() + "'"
                    + ",'" + vencliente.getUltimopago() + "'"
                    + ",'" + vencliente.getFechaultimopago() + "'"
                    + ",'" + vencliente.getClientedesde() + "')";
           
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

    public boolean EditaCliente(venclientes vencliente) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();

        if (conexion != null) {

            String sql = "UPDATE venclientes "
                    + "SET nombrecompleto = '" + vencliente.getNombrecompleto() + "',"
                        + "nombres = '" + vencliente.getNombres() + "',"
                        + "apellidopaterno='" + vencliente.getApellidopaterno() + "'," 
                        + "apellidomaterno = '" + vencliente.getApellidomaterno() + "',"
                        + "rfc = '" + vencliente.getRfc() + "',"
                        + "curp = '" + vencliente.getCurp() + "',"
                        + "calle = '" + vencliente.getCalle() + "',"
                        + "numexterior = '" + vencliente.getNumexterior() + "',"
                        + "numinterior = '" + vencliente.getNuminterior() + "',"
                        + "colonia = '" + vencliente.getColonia() + "',"
                        + "municipio = '" + vencliente.getMunicipio() + "',"
                        + "ciudad = '" + vencliente.getCiudad() + "',"
                        + "idestado = '" + vencliente.getIdestado().getIdestado() + "',"
                        + "pais = '" + vencliente.getPais() + "',"
                        + "cp = '" + vencliente.getCp() + "',"
                        + "idtipocliente = '" + vencliente.getIdtipocliente().getIdtipocliente() + "',"
                        + "idterminopago = '" + vencliente.getIdterminopago().getIdterminopago() + "',"
                        + "idmetodopago = '" + vencliente.getIdmetodopago().getIdmetodopago() + "',"
                        + "idlistaprecio = '" + vencliente.getIdlistaprecio().getIdlistaprecio() + "',"
                        + "idhistorialcliente = '" + vencliente.getIdhistorialcliente().getIdhistorialcliente() + "',"
                        + "descuento = '" + vencliente.getDescuento() + "',"
                        + "limitecredito = '" + vencliente.getLimitecredito() + "',"
                        + "diascredito = '" + vencliente.getDiascredito() + "',"
                        + "ultimopago = '" + vencliente.getUltimopago() + "',"
                        + "fechaultimopago = '" + vencliente.getFechaultimopago() + "',"
                        + "clientedesde = '" + vencliente.getClientedesde() + "'"
                    + "WHERE idcliente = '" + vencliente.getIdcliente() + "'";
            
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

    public ArrayList<venclientes> ConsultarClientes() throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<venclientes> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "SELECT   c.idcliente, c.nombrecompleto, c.nombres, c.apellidopaterno, c.apellidomaterno, c.rfc, " +
                            "c.curp, c.calle, c.numexterior, c.numinterior, c.colonia, c.municipio, c.ciudad, c.idestado, " +
                            "c.pais, c.cp, c.idtipocliente, c.idterminopago, c.idmetodopago, c.idlistaprecio, c.idhistorialcliente, " +
                            "c.descuento, c.limitecredito, c.diascredito, c.ultimopago, c.fechaultimopago, c.clientedesde, " +
                            "e.estado, t.tipocliente, p.terminopago, m.metodopago, l.listaprecio, h.historialcliente"
                    + " FROM venclientes c"
                    + "     LEFT JOIN conestados e ON c.idestado = e.idestado "
                    + "     LEFT JOIN ventiposclientes t ON c.idtipocliente = t.idtipocliente"
                    + "     LEFT JOIN venterminospago p ON c.idterminopago = p.idterminopago"
                    + "     LEFT JOIN venmetodospago m ON c.idmetodopago = m.idmetodopago"
                    + "     LEFT JOIN venlistasprecios l ON c.idlistaprecio = l.idlistaprecio"
                    + "     LEFT JOIN venhistorialcliente h ON c.idhistorialcliente = h.idhistorialcliente"
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
                    conestados conestado = new conestados();
                    conestado.setIdestado(rs.getInt("idestado"));
                    vencliente.setIdestado(conestado);
                    
                    
                    vencliente.setPais(rs.getString("pais"));
                    vencliente.setCp(rs.getString("cp"));
                    
                    ventiposclientes ventipocliente = new ventiposclientes();
                    ventipocliente.setIdtipocliente(rs.getInt("idtipocliente"));
                    vencliente.setIdtipocliente(ventipocliente);
                    
                    venterminospago venterminopago = new venterminospago();
                    venterminopago.setIdterminopago(rs.getString("idterminopago"));
                    vencliente.setIdterminopago(venterminopago);
                    
                    venmetodospago venmetodopago = new venmetodospago();
                    venmetodopago.setIdmetodopago(rs.getInt("idmetodopago"));
                    vencliente.setIdmetodopago(venmetodopago);
                    
                    venlistasprecios venlistaprecio = new venlistasprecios();
                    venlistaprecio.setIdlistaprecio(rs.getString("idlistaprecio"));
                    vencliente.setIdlistaprecio(venlistaprecio);
                    
                    
                    venhistorialcliente venhistorialclienteobj = new venhistorialcliente();
                    venhistorialclienteobj.setIdhistorialcliente(rs.getInt("idhistorialcliente"));
                    vencliente.setIdhistorialcliente(venhistorialclienteobj);
                    vencliente.setDescuento(rs.getFloat("descuento"));
                    vencliente.setLimitecredito(rs.getFloat("limitecredito"));
                    vencliente.setDiascredito(rs.getInt("diascredito"));
                    vencliente.setUltimopago(rs.getFloat("ultimopago"));
                    vencliente.setFechaultimopago(rs.getString("fechaultimopago"));
                    vencliente.setClientedesde(rs.getString("clientedesde"));
                    
                    lista.add(vencliente);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }

    public ArrayList<venclientes> ConsultarClientexId(String idcliente) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<venclientes> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "SELECT   c.idcliente, c.nombrecompleto, c.nombres, c.apellidopaterno, c.apellidomaterno, c.rfc, " +
                            "c.curp, c.calle, c.numexterior, c.numinterior, c.colonia, c.municipio, c.ciudad, c.idestado, " +
                            "c.pais, c.cp, c.idtipocliente, c.idterminopago, c.idmetodopago, c.idlistaprecio, c.idhistorialcliente, " +
                            "c.descuento, c.limitecredito, c.diascredito, c.ultimopago, c.fechaultimopago, c.clientedesde, " +
                            "e.estado, t.tipocliente, p.terminopago, m.metodopago, l.listaprecio, h.historialcliente"
                    + " FROM venclientes c"
                    + "     LEFT JOIN conestados e ON c.idestado = e.idestado "
                    + "     LEFT JOIN ventiposclientes t ON c.idtipocliente = t.idtipocliente"
                    + "     LEFT JOIN venterminospago p ON c.idterminopago = p.idterminopago"
                    + "     LEFT JOIN venmetodospago m ON c.idmetodopago = m.idmetodopago"
                    + "     LEFT JOIN venlistasprecios l ON c.idlistaprecio = l.idlistaprecio"
                    + "     LEFT JOIN venhistorialcliente h ON c.idhistorialcliente = h.idhistorialcliente"
                    + " WHERE c.idcliente = '" + idcliente + "'" 
                    + " ORDER BY c.idcliente asc ";
            
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println(sql);
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
                    
                    conestados conestado = new conestados();
                    conestado.setIdestado(rs.getInt("idestado"));
                    vencliente.setIdestado(conestado);
                    
                    
                    vencliente.setPais(rs.getString("pais"));
                    vencliente.setCp(rs.getString("cp"));
                    
                    ventiposclientes ventipocliente = new ventiposclientes();
                    ventipocliente.setIdtipocliente(rs.getInt("idtipocliente"));
                    vencliente.setIdtipocliente(ventipocliente);
                    
                    venterminospago venterminopago = new venterminospago();
                    venterminopago.setIdterminopago(rs.getString("idterminopago"));
                    vencliente.setIdterminopago(venterminopago);
                    
                    venmetodospago venmetodopago = new venmetodospago();
                    venmetodopago.setIdmetodopago(rs.getInt("idmetodopago"));
                    vencliente.setIdmetodopago(venmetodopago);
                    
                    venlistasprecios venlistaprecio = new venlistasprecios();
                    venlistaprecio.setIdlistaprecio(rs.getString("idlistaprecio"));
                    vencliente.setIdlistaprecio(venlistaprecio);
                    
                    
                    venhistorialcliente venhistorialclienteobj = new venhistorialcliente();
                    venhistorialclienteobj.setIdhistorialcliente(rs.getInt("idhistorialcliente"));
                    vencliente.setIdhistorialcliente(venhistorialclienteobj);
                    
                    vencliente.setDescuento(rs.getFloat("descuento"));
                    vencliente.setLimitecredito(rs.getFloat("limitecredito"));
                    vencliente.setDiascredito(rs.getInt("diascredito"));
                    vencliente.setUltimopago(rs.getFloat("ultimopago"));
                    vencliente.setFechaultimopago(rs.getString("fechaultimopago"));
                    vencliente.setClientedesde(rs.getString("clientedesde"));

                    lista.add(vencliente);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }

    public int verificaCliente(String idcliente, String rfc, String operacion) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        int numero_registros = 0;
        String sql;
        if (operacion.equals("nuevo")) {
            sql = "SELECT count(*) as existe FROM venclientes WHERE rfc = '" + rfc + "'";
        } else {
            sql = "SELECT count(*) as existe FROM venclientes WHERE rfc = '" + rfc + "' and idcliente <> '" + idcliente + "'";
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
