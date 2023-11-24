package fb.model;
public class Pedido {
    private String id;
    private String idColaborador;
    private String idCliente;
    private String idLugarInicio;
    private String idLugarDestino;
    private String direccionDestino;
    private String fechaRegistro;
    private String fechaInicioViaje;
    private String fechaFinViaje;
    private double montoTotal;
    private String estado;

    public Pedido(String idColaborador, String idCliente, String idLugarInicio, String idLugarDestino, String direccionDestino, String fechaRegistro, String fechaInicioViaje, String fechaFinViaje, double montoTotal) {        
        this.idColaborador = idColaborador;
        this.idCliente = idCliente;
        this.idLugarInicio = idLugarInicio;
        this.idLugarDestino = idLugarDestino;
        this.direccionDestino = direccionDestino;
        this.fechaRegistro = fechaRegistro;
        this.fechaInicioViaje = fechaInicioViaje;
        this.fechaFinViaje = fechaFinViaje;
        this.montoTotal = montoTotal; 
        this.estado = "PENDIENTE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(String idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdLugarInicio() {
        return idLugarInicio;
    }

    public void setIdLugarInicio(String idLugarInicio) {
        this.idLugarInicio = idLugarInicio;
    }

    public String getIdLugarDestino() {
        return idLugarDestino;
    }

    public void setIdLugarDestino(String idLugarDestino) {
        this.idLugarDestino = idLugarDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaInicioViaje() {
        return fechaInicioViaje;
    }

    public void setFechaInicioViaje(String fechaInicioViaje) {
        this.fechaInicioViaje = fechaInicioViaje;
    }

    public String getFechaFinViaje() {
        return fechaFinViaje;
    }

    public void setFechaFinViaje(String fechaFinViaje) {
        this.fechaFinViaje = fechaFinViaje;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}