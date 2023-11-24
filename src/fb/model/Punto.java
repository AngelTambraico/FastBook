package fb.model;

public class Punto {
    private String id;
    private double latitud;
    private double longitud;
    private String distrito;
    private String nombre;
    private String direccion;
    private String tipo;
    private String estado;

    public Punto(float latitud, float longitud, String distrito, String nombre, String direccion, String tipo) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.distrito = distrito;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = "ACTIVO";
    }
    public Punto(String id,double latitud, double longitud, String distrito, String nombre, String direccion, String tipo,String estado) {
        this.id=id;
        this.latitud = (float) latitud;
        this.longitud = (float) longitud;
        this.distrito = distrito;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombreUbicacion(){
        return nombre+". "+direccion+" - "+distrito;
    }

}
