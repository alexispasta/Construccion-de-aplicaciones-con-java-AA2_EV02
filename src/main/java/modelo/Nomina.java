package modelo;

import java.sql.Date;

public class Nomina {
    private int id;
    private int idPersona;
    private Date fechaPago;
    private double cantidad;

    public Nomina() {}

    public Nomina(int id, int idPersona, Date fechaPago, double cantidad) {
        this.id = id;
        this.idPersona = idPersona;
        this.fechaPago = fechaPago;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public Date getFechaPago() { return fechaPago; }
    public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }

    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
}
