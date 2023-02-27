package mx.tecnm.itorizaba.banquetes.entidades;

import java.util.List;

public class Banquete {

    private final int id;
    private final String nombre;
    private final String mensajePrincipal;
    private final String mensajePrincipalSubtitulo;
    private final String tituloDescripcion;
    private final String contenidoDescripcion;
    private final String icon;
    private final String imagenFondo;
    private final List<Menu> menus;

    public Banquete(int id, String nombre, String mensajePrincipal, String mensajePrincipalSubtitulo, String tituloDescripcion, String contenidoDescripcion, String icon, String imagenFondo, List<Menu> menus) {
        this.id = id;
        this.nombre = nombre;
        this.mensajePrincipal = mensajePrincipal;
        this.mensajePrincipalSubtitulo = mensajePrincipalSubtitulo;
        this.tituloDescripcion = tituloDescripcion;
        this.contenidoDescripcion = contenidoDescripcion;
        this.icon = icon;
        this.imagenFondo = imagenFondo;
        this.menus = menus;
    }

    public String getImagenFondo() {
        return imagenFondo;
    }

    public String getIcon() {
        return icon;
    }

    public String getContenidoDescripcion() {
        return contenidoDescripcion;
    }

    public int getId() {
        return id;
    }

    public String getMensajePrincipal() {
        return mensajePrincipal;
    }

    public String getMensajePrincipalSubtitulo() {
        return mensajePrincipalSubtitulo;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTituloDescripcion() {
        return tituloDescripcion;
    }

}
