package mx.tecnm.itorizaba.banquetes.entidades;

public class MenuNavegacionItem {
    private final int id;
    private final String nombre;

    public MenuNavegacionItem(int id, String nombre) {
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
