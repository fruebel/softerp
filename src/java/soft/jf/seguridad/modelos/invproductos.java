/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.modelos;

import java.util.Date;

/**
 *
 * @author jbarrientos
 */
public class invproductos {
    
    private String idproducto;
    private invcategoriasproductos idcategoria;
    private String descripcion;
    private String descripcionlarga;    
    private invunidadesmedida idunidadmedida;
    private String codigobarras;
    private invtiposproducto idtipoproducto;
    private String fabricante;
    private float costoactual;
    private float ultimocosto;
    private Date fechaultimacompra;
    private float costodematerial;
    private float costomanoobra;
    private float costosgenerales;   
    private int controlado;
    private int serializado;
    private int descontinuado;
    private float volumen;
    private float peso;
    private float alto;
    private float ancho;
    private double largo;   
    private String imagen;
    private String fichatecnica;
    private contiposimpuesto idtipoimpuesto;

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public invcategoriasproductos getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(invcategoriasproductos idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionlarga() {
        return descripcionlarga;
    }

    public void setDescripcionlarga(String descripcionlarga) {
        this.descripcionlarga = descripcionlarga;
    }

    public invunidadesmedida getIdunidadmedida() {
        return idunidadmedida;
    }

    public void setIdunidadmedida(invunidadesmedida idunidadmedida) {
        this.idunidadmedida = idunidadmedida;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public invtiposproducto getIdtipoproducto() {
        return idtipoproducto;
    }

    public void setIdtipoproducto(invtiposproducto idtipoproducto) {
        this.idtipoproducto = idtipoproducto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getCostoactual() {
        return costoactual;
    }

    public void setCostoactual(float costoactual) {
        this.costoactual = costoactual;
    }

    public float getUltimocosto() {
        return ultimocosto;
    }

    public void setUltimocosto(float ultimocosto) {
        this.ultimocosto = ultimocosto;
    }

    public Date getFechaultimacompra() {
        return fechaultimacompra;
    }

    public void setFechaultimacompra(Date fechaultimacompra) {
        this.fechaultimacompra = fechaultimacompra;
    }

    public float getCostodematerial() {
        return costodematerial;
    }

    public void setCostodematerial(float costodematerial) {
        this.costodematerial = costodematerial;
    }

    public float getCostomanoobra() {
        return costomanoobra;
    }

    public void setCostomanoobra(float costomanoobra) {
        this.costomanoobra = costomanoobra;
    }

    public float getCostosgenerales() {
        return costosgenerales;
    }

    public void setCostosgenerales(float costosgenerales) {
        this.costosgenerales = costosgenerales;
    }

    public int getControlado() {
        return controlado;
    }

    public void setControlado(int controlado) {
        this.controlado = controlado;
    }

    public int getSerializado() {
        return serializado;
    }

    public void setSerializado(int serializado) {
        this.serializado = serializado;
    }

    public int getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(int descontinuado) {
        this.descontinuado = descontinuado;
    }

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFichatecnica() {
        return fichatecnica;
    }

    public void setFichatecnica(String fichatecnica) {
        this.fichatecnica = fichatecnica;
    }

    public contiposimpuesto getIdtipoimpuesto() {
        return idtipoimpuesto;
    }

    public void setIdtipoimpuesto(contiposimpuesto idtipoimpuesto) {
        this.idtipoimpuesto = idtipoimpuesto;
    }
    
    
}
