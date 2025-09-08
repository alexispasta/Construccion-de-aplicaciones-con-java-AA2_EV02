package modelo;

public class Informe {
    private int id;
    private int idAutor;
    private int idEmpresa;
    private String asunto;
    private String comentario;

    public Informe() {}

    public Informe(int id, int idAutor, int idEmpresa, String asunto, String comentario) {
        this.id = id;
        this.idAutor = idAutor;
        this.idEmpresa = idEmpresa;
        this.asunto = asunto;
        this.comentario = comentario;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdAutor() { return idAutor; }
    public void setIdAutor(int idAutor) { this.idAutor = idAutor; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
