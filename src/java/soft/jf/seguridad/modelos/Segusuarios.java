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
public class Segusuarios {
    
    private String idUsuario;
    private String idUsuarioRegistro;
    private Estadosusuarios idEstado;
    private Segperfiles idperfil;
    private int superusuario;
    private String contrasenia;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fotografia;
    private String telefono;
    private String email;
    private String tema;
    private String lenguaje;
    private Date ultimaActualizacion;
    private Date fechaRegistro;
    private Date ultimoAcceso;

       
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(String idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Estadosusuarios getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estadosusuarios idEstado) {
        this.idEstado = idEstado;
    }

    public Segperfiles getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Segperfiles idperfil) {
        this.idperfil = idperfil;
    }


    public int getSuperusuario() {
        return superusuario;
    }

    public void setSuperusuario(int superusuario) {
        this.superusuario = superusuario;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Date getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(Date ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
    
    
}
