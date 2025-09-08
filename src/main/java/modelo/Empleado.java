package modelo;

import java.sql.Date;

public class Empleado {
    private int idPersona;
    private Date fechaContratacion;
    private String cargo;

    // Constructor vacío
    public Empleado() {}

    // Constructor completo
    public Empleado(int idPersona, Date fechaContratacion, String cargo) {
        this.idPersona = idPersona;
        this.fechaContratacion = fechaContratacion;
        this.cargo = cargo;
    }

    // Getters y Setters
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
