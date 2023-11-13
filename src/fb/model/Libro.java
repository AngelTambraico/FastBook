package fb.model;

public class Libro {
    private int id;
    private Autor autor;
    private String titulo;
    private double precio;
    private int stock;
    private String estado;
    private String dato;

    public Libro(int id, Autor autor, String titulo, double precio, int stock, String estado) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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
