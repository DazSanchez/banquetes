package mx.tecnm.itorizaba.banquetes.entidades;

import java.util.List;

public class MenuNavegacion {

    private final List<MenuNavegacionItem> banquetes;
    private final List<MenuNavegacionItem> tematicas;

    public MenuNavegacion(List<MenuNavegacionItem> banquetes, List<MenuNavegacionItem> tematicas) {
        this.banquetes = banquetes;
        this.tematicas = tematicas;
    }

    public List<MenuNavegacionItem> getBanquetes() {
        return banquetes;
    }

    public List<MenuNavegacionItem> getTematicas() {
        return tematicas;
    }

}
