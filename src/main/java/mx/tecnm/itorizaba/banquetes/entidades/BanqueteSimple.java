package mx.tecnm.itorizaba.banquetes.entidades;

public class BanqueteSimple {

    private final int id;
    private final String nombre;

    public BanqueteSimple(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
