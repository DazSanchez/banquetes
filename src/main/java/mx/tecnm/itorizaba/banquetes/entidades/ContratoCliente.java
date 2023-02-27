package mx.tecnm.itorizaba.banquetes.entidades;

public class ContratoCliente {

    private final int id;
    private final int idBanquete;
    private final int idTematica;
    private final int idColor;
    private final String fecha;
    private final int asistentes;
    private final String calle;
    private final String colonia;
    private final String ciudad;

    public ContratoCliente(int id, int idBanquete, int idTematica, int idColor, String fecha, int asistentes, String calle, String colonia, String ciudad) {
        this.id = id;
        this.idBanquete = idBanquete;
        this.idTematica = idTematica;
        this.idColor = idColor;
        this.fecha = fecha;
        this.asistentes = asistentes;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }

    public int getAsistentes() {
        return asistentes;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public String getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }

    public int getIdBanquete() {
        return idBanquete;
    }

    public int getIdColor() {
        return idColor;
    }

    public int getIdTematica() {
        return idTematica;
    }

}
