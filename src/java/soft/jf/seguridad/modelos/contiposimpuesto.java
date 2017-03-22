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
public class contiposimpuesto {
    
    	private int idtipoimpuesto;
        private String tipoimpuesto;
        private double porcentaje;

    public int getIdtipoimpuesto() {
        return idtipoimpuesto;
    }

    public void setIdtipoimpuesto(int idtipoimpuesto) {
        this.idtipoimpuesto = idtipoimpuesto;
    }

    public String getTipoimpuesto() {
        return tipoimpuesto;
    }

    public void setTipoimpuesto(String tipoimpuesto) {
        this.tipoimpuesto = tipoimpuesto;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

        
}
