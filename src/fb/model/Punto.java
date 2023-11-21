package fb.model;

public class Punto {
    
    private String id;
    private float latitud;
    private float longitud;
    private String distrito;
    private String direccion;
    private String estado;

    public Punto(String id, float latitud, float longitud, String distrito, String direccion) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.distrito = distrito;
        this.direccion = direccion;
        this.estado = "ACTIVO";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
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
    
    
    
}
