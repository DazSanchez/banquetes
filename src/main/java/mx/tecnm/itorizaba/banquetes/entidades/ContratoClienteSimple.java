package mx.tecnm.itorizaba.banquetes.entidades;

public class ContratoClienteSimple {

    private final int id;
    private final String nombreBanquete;
    private final String fecha;
    private final String estatus;

    public ContratoClienteSimple(int id, String nombreBanquete, String fecha, String estatus) {
        this.id = id;
        this.nombreBanquete = nombreBanquete;
        this.fecha = fecha;
        this.estatus = estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }

    public String getNombreBanquete() {
        return nombreBanquete;
    }

}
