package mx.tecnm.itorizaba.banquetes.entidades;

public class DevolucionContrato {

    private final int id;
    private final double total;
    private final double porcentaje;
    private final boolean dentroDePlazo;

    public DevolucionContrato(int id, double total, double porcentaje, boolean dentroDePlazo) {
        this.id = id;
        this.total = total;
        this.porcentaje = porcentaje;
        this.dentroDePlazo = dentroDePlazo;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalDevolucion() {
        if (dentroDePlazo) {
            return total * porcentaje;
        }

        return 0;
    }

    public boolean isDentroDePlazo() {
        return dentroDePlazo;
    }

}
