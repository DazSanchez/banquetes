package mx.tecnm.itorizaba.banquetes.entidades;

public class TipoTematica {

    private final String nombre;
    private final String descripcion;
    private final int id;
    private final String imgUrl;

    public TipoTematica(int id, String nombre, String descripcion, String imgUrl) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.imgUrl = imgUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
