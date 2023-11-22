
package fb.dto;

public class PedidoDetalleDTO {
    private String idLibro;
    private String nomLibro;
    private String autorLibro;
    private double precio;
    private int cantidad;
    private double impuesto;
    private double total;

    public PedidoDetalleDTO(String idLibro, String nomLibro, String autorLibro, double precio, int cantidad, double impuesto, double total) {
        this.idLibro = idLibro;
        this.nomLibro = nomLibro;
        this.autorLibro = autorLibro;
        this.precio = precio;
        this.cantidad = cantidad;
        this.impuesto = impuesto;
        this.total = total;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getNomLibro() {
        return nomLibro;
    }

    public void setNomLibro(String nomLibro) {
        this.nomLibro = nomLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
