package mx.tecnm.itorizaba.banquetes.entidades;

public class OpcionSimple {

    private final int id;
    private final String nombre;

    public OpcionSimple(int id, String nombre) {
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
