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
public class Segfunciones {
    
    private int idfuncion;
    private Segmodulos idmodulo;
    private String titulo;
    private int activo;
    private String url;	
    private Segcategorias idcategoria;
    private String descripcioncorta;	
    private int orden;
    private String comentarios;
    private int idtipo;
    private String imagen;

    public int getIdfuncion() {
        return idfuncion;
    }

    public void setIdfuncion(int idfuncion) {
        this.idfuncion = idfuncion;
    }

    public Segmodulos getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(Segmodulos idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Segcategorias getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Segcategorias idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

   
    
    
    
    
}
