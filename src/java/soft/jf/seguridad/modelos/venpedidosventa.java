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
public class venpedidosventa {
    
  private int idpedidoventa;
  private venclientes idcliente;
  private vensucursalescliente idsucursalcliente;
  private String rfc;
  private String comentarios;
  private Date fechapedidoventa;
  private String calle;
  private String numexterior;
  private String numinterior;
  private String colonia;
  private String municipio;
  private String ciudad;
  private String estado;
  private String pais;
  private String cp;
  private String telefonocontacto;
  private String emailcontacto;
  private String entregara;
  private Date fechaentrega;
  private Date fechastatuspedido;
  private int idstatuspedido;
  private double subtotal;
  private double impuesto;
  private consucursales idsucursal;
  private String idvendedor; 
  private String idmoneda;
  private String idterminopago;
  private String idmetodopago;
  private String idusuarioidregistro;

    public int getIdpedidoventa() {
        return idpedidoventa;
    }

    public void setIdpedidoventa(int idpedidoventa) {
        this.idpedidoventa = idpedidoventa;
    }

    public venclientes getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(venclientes idcliente) {
        this.idcliente = idcliente;
    }

    public vensucursalescliente getIdsucursalcliente() {
        return idsucursalcliente;
    }

    public void setIdsucursalcliente(vensucursalescliente idsucursalcliente) {
        this.idsucursalcliente = idsucursalcliente;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFechapedidoventa() {
        return fechapedidoventa;
    }

    public void setFechapedidoventa(Date fechapedidoventa) {
        this.fechapedidoventa = fechapedidoventa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumexterior() {
        return numexterior;
    }

    public void setNumexterior(String numexterior) {
        this.numexterior = numexterior;
    }

    public String getNuminterior() {
        return numinterior;
    }

    public void setNuminterior(String numinterior) {
        this.numinterior = numinterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelefonocontacto() {
        return telefonocontacto;
    }

    public void setTelefonocontacto(String telefonocontacto) {
        this.telefonocontacto = telefonocontacto;
    }

    public String getEmailcontacto() {
        return emailcontacto;
    }

    public void setEmailcontacto(String emailcontacto) {
        this.emailcontacto = emailcontacto;
    }

    public String getEntregara() {
        return entregara;
    }

    public void setEntregara(String entregara) {
        this.entregara = entregara;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public Date getFechastatuspedido() {
        return fechastatuspedido;
    }

    public void setFechastatuspedido(Date fechastatuspedido) {
        this.fechastatuspedido = fechastatuspedido;
    }

    public int getIdstatuspedido() {
        return idstatuspedido;
    }

    public void setIdstatuspedido(int idstatuspedido) {
        this.idstatuspedido = idstatuspedido;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public consucursales getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(consucursales idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(String idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }

    public String getIdterminopago() {
        return idterminopago;
    }

    public void setIdterminopago(String idterminopago) {
        this.idterminopago = idterminopago;
    }

    public String getIdmetodopago() {
        return idmetodopago;
    }

    public void setIdmetodopago(String idmetodopago) {
        this.idmetodopago = idmetodopago;
    }

    public String getIdusuarioidregistro() {
        return idusuarioidregistro;
    }

    public void setIdusuarioidregistro(String idusuarioidregistro) {
        this.idusuarioidregistro = idusuarioidregistro;
    }
  
  
  
}
