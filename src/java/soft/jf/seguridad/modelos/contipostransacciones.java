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
public class contipostransacciones {
 
    private int idtipotransaccion;
    private String tipotransaccion;
    private int numerotransaccion;
    private int enviofiscal;

    public int getIdtipotransaccion() {
        return idtipotransaccion;
    }

    public void setIdtipotransaccion(int idtipotransaccion) {
        this.idtipotransaccion = idtipotransaccion;
    }

    public String getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(String tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public int getNumerotransaccion() {
        return numerotransaccion;
    }

    public void setNumerotransaccion(int numerotransaccion) {
        this.numerotransaccion = numerotransaccion;
    }

    public int getEnviofiscal() {
        return enviofiscal;
    }

    public void setEnviofiscal(int enviofiscal) {
        this.enviofiscal = enviofiscal;
    }
    
    
    
}
