package modelo;

import java.sql.Date;

public class Permiso {
    private int id;
    private int idAutor;
    private int idPersona;
    private String nombrePersona;
    private String documentoIdentidad;
    private String razon;
    private Date fechaSolicitud;
    private Date fechaAplicacion;

    public Permiso() {}

    public Permiso(int id, int idAutor, int idPersona, String nombrePersona, String documentoIdentidad,
                   String razon, Date fechaSolicitud, Date fechaAplicacion) {
        this.id = id;
        this.idAutor = idAutor;
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.documentoIdentidad = documentoIdentidad;
        this.razon = razon;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaAplicacion = fechaAplicacion;
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

    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; }

    public String getRazon() { return razon; }
    public void setRazon(String razon) { this.razon = razon; }

    public Date getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(Date fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public Date getFechaAplicacion() { return fechaAplicacion; }
    public void setFechaAplicacion(Date fechaAplicacion) { this.fechaAplicacion = fechaAplicacion; }
}
