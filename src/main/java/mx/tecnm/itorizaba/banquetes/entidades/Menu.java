package mx.tecnm.itorizaba.banquetes.entidades;

import java.util.List;

public class Menu {

    private final int id;
    private final String nombre;
    private final List<Platillo> platillos;

    public Menu(int id, String nombre, List<Platillo> platillos) {
        this.id = id;
        this.nombre = nombre;
        this.platillos = platillos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Platillo> getPlatillos() {
        return platillos;
    }

}
