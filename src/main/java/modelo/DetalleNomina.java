package modelo;

public class DetalleNomina {
    private int id;
    private int idPersona;
    private String cuentaBancaria;
    private double salarioBase;
    private double auxilioTransporte;
    private int horasExtra;
    private double bonificacion;
    private double comisiones;
    private double viaticos;
    private double descuentos;
    private double retencionFuente;
    private double prestamosEmpresa;
    private double embargosJudiciales;
    private int incapacidadesDias;
    private int vacacionesDias;
    private double cesantias;
    private double interesesCesantias;
    private double primaServicios;
    private double totalPagar;

    // Constructor vacío
    public DetalleNomina() {}

    // Constructor completo
    public DetalleNomina(int id, int idPersona, String cuentaBancaria, double salarioBase, double auxilioTransporte,
                         int horasExtra, double bonificacion, double comisiones, double viaticos, double descuentos,
                         double retencionFuente, double prestamosEmpresa, double embargosJudiciales,
                         int incapacidadesDias, int vacacionesDias, double cesantias, double interesesCesantias,
                         double primaServicios, double totalPagar) {
        this.id = id;
        this.idPersona = idPersona;
        this.cuentaBancaria = cuentaBancaria;
        this.salarioBase = salarioBase;
        this.auxilioTransporte = auxilioTransporte;
        this.horasExtra = horasExtra;
        this.bonificacion = bonificacion;
        this.comisiones = comisiones;
        this.viaticos = viaticos;
        this.descuentos = descuentos;
        this.retencionFuente = retencionFuente;
        this.prestamosEmpresa = prestamosEmpresa;
        this.embargosJudiciales = embargosJudiciales;
        this.incapacidadesDias = incapacidadesDias;
        this.vacacionesDias = vacacionesDias;
        this.cesantias = cesantias;
        this.interesesCesantias = interesesCesantias;
        this.primaServicios = primaServicios;
        this.totalPagar = totalPagar;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public String getCuentaBancaria() { return cuentaBancaria; }
    public void setCuentaBancaria(String cuentaBancaria) { this.cuentaBancaria = cuentaBancaria; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    public double getAuxilioTransporte() { return auxilioTransporte; }
    public void setAuxilioTransporte(double auxilioTransporte) { this.auxilioTransporte = auxilioTransporte; }

    public int getHorasExtra() { return horasExtra; }
    public void setHorasExtra(int horasExtra) { this.horasExtra = horasExtra; }

    public double getBonificacion() { return bonificacion; }
    public void setBonificacion(double bonificacion) { this.bonificacion = bonificacion; }

    public double getComisiones() { return comisiones; }
    public void setComisiones(double comisiones) { this.comisiones = comisiones; }

    public double getViaticos() { return viaticos; }
    public void setViaticos(double viaticos) { this.viaticos = viaticos; }

    public double getDescuentos() { return descuentos; }
    public void setDescuentos(double descuentos) { this.descuentos = descuentos; }

    public double getRetencionFuente() { return retencionFuente; }
    public void setRetencionFuente(double retencionFuente) { this.retencionFuente = retencionFuente; }

    public double getPrestamosEmpresa() { return prestamosEmpresa; }
    public void setPrestamosEmpresa(double prestamosEmpresa) { this.prestamosEmpresa = prestamosEmpresa; }

    public double getEmbargosJudiciales() { return embargosJudiciales; }
    public void setEmbargosJudiciales(double embargosJudiciales) { this.embargosJudiciales = embargosJudiciales; }

    public int getIncapacidadesDias() { return incapacidadesDias; }
    public void setIncapacidadesDias(int incapacidadesDias) { this.incapacidadesDias = incapacidadesDias; }

    public int getVacacionesDias() { return vacacionesDias; }
    public void setVacacionesDias(int vacacionesDias) { this.vacacionesDias = vacacionesDias; }

    public double getCesantias() { return cesantias; }
    public void setCesantias(double cesantias) { this.cesantias = cesantias; }

    public double getInteresesCesantias() { return interesesCesantias; }
    public void setInteresesCesantias(double interesesCesantias) { this.interesesCesantias = interesesCesantias; }

    public double getPrimaServicios() { return primaServicios; }
    public void setPrimaServicios(double primaServicios) { this.primaServicios = primaServicios; }

    public double getTotalPagar() { return totalPagar; }
    public void setTotalPagar(double totalPagar) { this.totalPagar = totalPagar; }
}
