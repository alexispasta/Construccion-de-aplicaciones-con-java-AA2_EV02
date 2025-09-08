package modelo;

import java.sql.Date;

public class Reporte {
    private int id;
    private int idAutor;
    private int idPersona;
    private String nombrePersona;
    private String razon;
    private Date fechaReporte;
    private String comentarios;

    public Reporte() {}

    public Reporte(int id, int idAutor, int idPersona, String nombrePersona, String razon, Date fechaReporte, String comentarios) {
        this.id = id;
        this.idAutor = idAutor;
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.razon = razon;
        this.fechaReporte = fechaReporte;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdAutor() { return idAutor; }
    public void setIdAutor(int idAutor) { this.idAutor = idAutor; }

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public String getNombrePersona() { return nombrePersona; }
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }

    public String getRazon() { return razon; }
    public void setRazon(String razon) { this.razon = razon; }

    public Date getFechaReporte() { return fechaReporte; }
    public void setFechaReporte(Date fechaReporte) { this.fechaReporte = fechaReporte; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }
}
