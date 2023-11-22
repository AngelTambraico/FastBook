package fb.model;

public class PedidoDetalle {
    private String id;
    private String idPedido;
    private String idLibro;
    private float Precio;
    private int Cantidad;
    private float Impuesto;
    private float Total;
    private String estado;

    public PedidoDetalle(String id, String idPedido, String idLibro, float Precio, int Cantidad, float Impuesto, float Total, String estado) {
        this.id = id;
        this.idPedido = idPedido;
        this.idLibro = idLibro;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Impuesto = Impuesto;
        this.Total = Total;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(float Impuesto) {
        this.Impuesto = Impuesto;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
