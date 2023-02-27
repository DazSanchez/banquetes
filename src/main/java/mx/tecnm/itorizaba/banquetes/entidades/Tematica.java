package mx.tecnm.itorizaba.banquetes.entidades;

import java.util.List;

public class Tematica {

    private final int id;
    private final String nombre;
    private final String mensajePrincipal;
    private final String mensajePrincipalSubtitulo;
    private final String tituloDescripcion;
    private final String contenidoDescripcion;
    private final String icon;
    private final String imagenFondo;
    private final List<Color> colores;
    private final List<Adorno> adornos;

    public Tematica(int id, String nombre, String mensajePrincipal, String mensajePrincipalSubtitulo, String tituloDescripcion, String contenidoDescripcion, String icon, String imagenFondo, List<Color> colores, List<Adorno> adornos) {
        this.id = id;
        this.nombre = nombre;
        this.mensajePrincipal = mensajePrincipal;
        this.mensajePrincipalSubtitulo = mensajePrincipalSubtitulo;
        this.tituloDescripcion = tituloDescripcion;
        this.contenidoDescripcion = contenidoDescripcion;
        this.icon = icon;
        this.imagenFondo = imagenFondo;
        this.colores = colores;
        this.adornos = adornos;
    }

    public String getContenidoDescripcion() {
        return contenidoDescripcion;
    }

    public String getIcon() {
        return icon;
    }

    public String getImagenFondo() {
        return imagenFondo;
    }

    public String getMensajePrincipal() {
        return mensajePrincipal;
    }

    public String getMensajePrincipalSubtitulo() {
        return mensajePrincipalSubtitulo;
    }

    public String getTituloDescripcion() {
        return tituloDescripcion;
    }

    public List<Adorno> getAdornos() {
        return adornos;
    }

    public List<Color> getColores() {
        return colores;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
