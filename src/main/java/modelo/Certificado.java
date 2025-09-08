package modelo;

import java.sql.Date;

public class Certificado {
    private int id;
    private int idPersona;
    private String nombrePersona;
    private String carrera;
    private Date fechaInicio;
    private String institucion;

    // Constructor vacío
    public Certificado() {}

    // Constructor completo
    public Certificado(int id, int idPersona, String nombrePersona, String carrera, Date fechaInicio, String institucion) {
        this.id = id;
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.carrera = carrera;
        this.fechaInicio = fechaInicio;
        this.institucion = institucion;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public String getNombrePersona() { return nombrePersona; }
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }
}

