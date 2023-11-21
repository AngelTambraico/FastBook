package fb.model;

public class Libro {
    private String id;
    private String idAutor;
    private String titulo;
    private double precio;
    private int stock;
    private String estado;

    public Libro(String idAutor, String titulo, double precio, int stock) {
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.precio = precio;
        this.stock = stock;
        this.estado = "ACTIVO";
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
