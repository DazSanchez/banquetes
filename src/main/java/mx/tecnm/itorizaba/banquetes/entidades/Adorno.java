package mx.tecnm.itorizaba.banquetes.entidades;

public class Adorno {

    private final int id;
    private final String nombre;
    private final String imgUrl;

    public Adorno(int id, String nombre, String imgUrl) {
        this.id = id;
        this.nombre = nombre;
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
