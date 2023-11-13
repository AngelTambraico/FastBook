package fb.model;

public class Colaborador {
    private Integer id;
    private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private String direccion;
    private String telefono;
    private String estado;

    public Colaborador(Integer id, String nombres, String ape_paterno, String ape_materno, String direccion, String telefono, String estado) {
        this.id = id;
        this.nombres = nombres;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
