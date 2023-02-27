package mx.tecnm.itorizaba.banquetes.entidades;

public class DesglosePago {

    private final int id;
    private final double total;
    private final String fechaSegundoPago;
    private final String fechaTercerPago;

    public DesglosePago(int id, double total, String fechaSegundoPago, String fechaTercerPago) {
        this.id = id;
        this.total = total;
        this.fechaSegundoPago = fechaSegundoPago;
        this.fechaTercerPago = fechaTercerPago;
    }


    public String getFechaSegundoPago() {
        return fechaSegundoPago;
    }

    public String getFechaTercerPago() {
        return fechaTercerPago;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public double getPrimerPago() {
        return total * 0.30;
    }

    public double getSegundoPago() {
        return total * 0.30;
    }

    public double getTercerPago() {
        return total * 0.40;
    }
}
