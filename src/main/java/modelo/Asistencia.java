package modelo;

import java.sql.Date;

public class Asistencia {
    private int id;
    private int idPersona;
    private Date fecha;
    private String estado;

    public Asistencia() {}

    public Asistencia(int id, int idPersona, Date fecha, String estado) {
        this.id = id;
        this.idPersona = idPersona;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
