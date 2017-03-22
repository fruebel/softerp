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
public class invtempproducto {
    //p.idproducto,p.costoactual as precio,i.cantidad as stock,1 as cantidad , 
    //'codigo' as codigo,p.descripcion as nombreproducto,p.costoactual as preciounitario
    private String idproducto;
    private String precio;
    private String stock;
    private int cantidad;
    private String codigo;
    private String nombreproducto;
    private String preciounitario;
    private String total;
    private String almacen;
    private contiposimpuesto idtipoimpuesto; 

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(String preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public contiposimpuesto getIdtipoimpuesto() {
        return idtipoimpuesto;
    }

    public void setIdtipoimpuesto(contiposimpuesto idtipoimpuesto) {
        this.idtipoimpuesto = idtipoimpuesto;
    }
    
    
}
