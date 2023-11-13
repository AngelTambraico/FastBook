package fb.model;

public class Punto {
	private Integer id;
	private float latitud;
	private float longitud;
	private String distrito;
	private String direccion;
	private int estado;

    public Punto(Integer id, float latitud, float longitud, String distrito, String direccion, int estado) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.distrito = distrito;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
        
        
}   
