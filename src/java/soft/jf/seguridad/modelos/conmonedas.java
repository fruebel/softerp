/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.modelos;

/**
 *
 * @author paulreyes
 * @fecha  2017-03-16
 */
public class conmonedas {
    
    private String idmoneda;
    private String moneda;
    private String tipodecambio;
    private String pais;
    
    public String getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }
    
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipodecambio() {
        return tipodecambio;
    }

    public void setTipodecambio(String tipodecambio) {
        this.tipodecambio = tipodecambio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
