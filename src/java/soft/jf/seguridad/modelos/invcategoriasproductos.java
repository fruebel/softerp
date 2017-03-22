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
public class invcategoriasproductos {
    
    
    private String idcategoria;
    private int idlineaproducto;
    private String categoria; 
    private int textopartidaventa;
    private int facturarenrojo; 
    private int modificarprecio;
    private double margenprecio; 
    private double margencosto;

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdlineaproducto() {
        return idlineaproducto;
    }

    public void setIdlineaproducto(int idlineaproducto) {
        this.idlineaproducto = idlineaproducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTextopartidaventa() {
        return textopartidaventa;
    }

    public void setTextopartidaventa(int textopartidaventa) {
        this.textopartidaventa = textopartidaventa;
    }

    public int getFacturarenrojo() {
        return facturarenrojo;
    }

    public void setFacturarenrojo(int facturarenrojo) {
        this.facturarenrojo = facturarenrojo;
    }

    public int getModificarprecio() {
        return modificarprecio;
    }

    public void setModificarprecio(int modificarprecio) {
        this.modificarprecio = modificarprecio;
    }

    public double getMargenprecio() {
        return margenprecio;
    }

    public void setMargenprecio(double margenprecio) {
        this.margenprecio = margenprecio;
    }

    public double getMargencosto() {
        return margencosto;
    }

    public void setMargencosto(double margencosto) {
        this.margencosto = margencosto;
    }
    
    
                
}
