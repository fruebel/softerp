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
import soft.jf.seguridad.modelos.conmonedas;

/**
 * 
 * @author PaulReyes
 * @fecha  2017-03-16
 * 
 */

public class conmonedasDAO{ 
    ConnectionFactory conexionFactory = new ConnectionFactory();
    private boolean resp = false;
    
    public ArrayList<conmonedas> consulta() throws ClassNotFoundException, SQLException {
        Connection conexion = conexionFactory.conectar();
        ArrayList<conmonedas> lista = new ArrayList<>();
        if(conexion != null) {
            String sql = "SELECT * FROM conmonedas ORDER BY idmoneda";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);
            if(rs != null) {
                while (rs.next()) {
                    conmonedas dat = new conmonedas();                    
                    lista.add(dat);
                }
            }
            conexionFactory.desconectar();
        }else{
            return null;
        }
        return lista;
    }   
    
    public boolean crea(conmonedas obj) throws ClassNotFoundException, SQLException {
        Connection conexion = conexionFactory.conectar();
        if(conexion != null) {
            String sql ="INSERT INTO conmonedas(idmoneda,moneda,pais,tipocambio) VALUES ('"+ obj.getIdmoneda() +"','"+ obj.getMoneda() +"','"+ obj.getPais()+"',"+ obj.getTipodecambio()+")";
            boolean exitoso = conexionFactory.ejecutarSQL(sql);
            conexionFactory.desconectar();
            if(exitoso){
                resp = true;
            }
        }
        return resp;
    }
    
    public boolean actualiza(conmonedas obj) throws ClassNotFoundException, SQLException {
        Connection conexion = conexionFactory.conectar();
        if(conexion != null) {
            String sql = "UPDATE conmonedas SET idmoneda='"+obj.getIdmoneda()+"', moneda='"+obj.getMoneda()+"',pais='"+obj.getPais()+"',tipocambio='"+obj.getTipodecambio()+"') WHERE idmoneda="+obj.getIdmoneda()+""; 
            boolean exitoso = conexionFactory.ejecutarSQL(sql);
            conexionFactory.desconectar();
            if(exitoso){
                resp = true;
            }
        }
        return resp;
    }
    
    public boolean elimina(conmonedas obj) throws ClassNotFoundException, SQLException {
        Connection conexion = conexionFactory.conectar();
        if(conexion != null) {
                String sql = "DELETE FROM conmonedas WHERE idmoneda='"+obj.getIdmoneda()+"' AND moneda='"+obj.getMoneda()+"' AND pais='"+obj.getPais()+"' AND tipocambio="+obj.getTipodecambio()+" "; 
                boolean exitoso = conexionFactory.ejecutarSQL(sql);
                conexionFactory.desconectar();
                if(exitoso){
                    resp = true;
                }
        }
        return resp;
    }
    
    public int verifica(conmonedas obj,String operacion) throws ClassNotFoundException, SQLException {
        Connection conexion = conexionFactory.conectar();
        int num_registros = 0;
        String sql = "SELECT COUNT(*) as existe FROM conmonedas WHERE idmoneda='"+obj.getIdmoneda()+"' AND moneda='"+obj.getMoneda()+"' AND pais='"+obj.getPais()+"' AND tipocambio="+obj.getTipodecambio()+" "; 
        if(conexion != null){
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);
            if (rs != null) {
                while (rs.next()) {
                    num_registros = rs.getInt("existe");
                }
            }
        }
        return num_registros;
    }
}