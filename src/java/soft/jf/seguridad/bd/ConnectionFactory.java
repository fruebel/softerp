/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbarrientos
 */
public class ConnectionFactory {
 
    
    /**
     * Permite crear la conexion a la base de datos
     * 
     */
    private Connection conexion;
    /**
     * Obejto que permite ejecutar y crear sentecias SQL
     */
    private Statement sentencia;

    /**
     * Permite generar la conexion a la base de datos
     * @return conexion realizada
     * @throws ClassNotFoundException excepcion generada en caso de no cargar el driver 
     * @throws SQLException excepcion generada en caso de no existir conexion
     */
    public Connection conectar() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.jdbc.Driver");  //Carga del Driver

            //Crear la conexion
            //String url = "jdbc:mysql://104.236.73.213:3306/erp";
            String url = "jdbc:mysql://localhost:3306/softerp";
            String user = "root";
            String password = "mysql";

            conexion = DriverManager.getConnection(url,user,password);


            //habilitar permisos para crear sentencias sql
            sentencia = conexion.createStatement();  //se requiere para crear el sql y debe ser despues de crear la conexion

            return conexion;

    }

    /**
     * Permite cerrar la conexion
     * @return true en caso de descontarse
     * @throws SQLException excepcion en caso de no cerrar la conexion
     */
    public boolean desconectar() throws SQLException{
            /**
             * Metodo que realiza la desconexion a la base de datos
             */

            if (conexion != null) { //si la conexion esta abierta
                    conexion.close();
                    return true;
            } else {
                    return false;
            }

    }
	
    /**
     * Permite ejecutar cualquier sentencia update , inserte y delete
     * @param sql sentencia a ejecutarse
     * @return true en caso de ser exitoso
     * @throws SQLException la excepcion generada en caso de error al ejecutarse la sentencia
     */
    public boolean ejecutarSQL(String sql) throws SQLException{

            System.out.println(sql);
            sentencia.execute(sql);
            return true;

    }

    /**
     * Permite ejecutar cualquier sentencia select 
     * @param sql cadena sql
     * @return regresa el resultado del select 
     * @throws SQLException excepcion generada en caso de error al ejecutar la consulta
     */
    public ResultSet ejecutarConsulta(String sql) throws SQLException {

            ResultSet rs = sentencia.executeQuery(sql);
            return rs;

    }    
    
    
    	/*public static void main(String[] args) {
		ConnectionFactory con = new ConnectionFactory();
                
        try {
            Connection conex = con.conectar();
            if (conex != null) {
                System.out.println("conexion exitosa");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
        */
    
}
