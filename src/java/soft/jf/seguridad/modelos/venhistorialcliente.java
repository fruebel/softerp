/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.modelos;

/**
 *
 * @author fcantera
 */
public class venhistorialcliente {
    private int idhistorialcliente;
    private String historialcliente;
    private int permitirfacturar;
    private int orden;

    public int getIdhistorialcliente() {
        return idhistorialcliente;
    }

    public void setIdhistorialcliente(int idhistorialcliente) {
        this.idhistorialcliente = idhistorialcliente;
    }

    public String getHistorialcliente() {
        return historialcliente;
    }

    public void setHistorialcliente(String historialcliente) {
        this.historialcliente = historialcliente;
    }

    public int getPermitirfacturar() {
        return permitirfacturar;
    }

    public void setPermitirfacturar(int permitirfacturar) {
        this.permitirfacturar = permitirfacturar;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
    
}
