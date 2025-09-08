package modelo;

import java.sql.Date;

public class RRHH {
    private int idPersona;
    private Date fechaContratacion;

    // Constructor vacío
    public RRHH() {}

    // Constructor completo
    public RRHH(int idPersona, Date fechaContratacion) {
        this.idPersona = idPersona;
        this.fechaContratacion = fechaContratacion;
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
}
