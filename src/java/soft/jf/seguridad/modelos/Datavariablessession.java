/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.modelos;

/**
 *
 * @author jbarrientos
 */
public class Datavariablessession {
    
    private String respuesta;
    private String nombreUsuario;
    private String idusuario;
    private consucursales idsucursal;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public consucursales getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(consucursales idsucursal) {
        this.idsucursal = idsucursal;
    }
    
    
    
}
