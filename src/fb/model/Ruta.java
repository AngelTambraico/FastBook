/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.model;
public class Ruta {
    private int orden;
    private String codPuntoInicio;
    private String codPuntoFin;
    private float distancia;
    private int estado;
    private String IdPedido;

    public Ruta(int orden, String codPuntoInicio, String codPuntoFin, float distancia, int estado, String IdPedido) {
        this.orden = orden;
        this.codPuntoInicio = codPuntoInicio;
        this.codPuntoFin = codPuntoFin;
        this.distancia = distancia;
        this.estado = estado;
        this.IdPedido = IdPedido;
    }
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getCodPuntoInicio() {
        return codPuntoInicio;
    }

    public void setCodPuntoInicio(String codPuntoInicio) {
        this.codPuntoInicio = codPuntoInicio;
    }

    public String getCodPuntoFin() {
        return codPuntoFin;
    }

    public void setCodPuntoFin(String codPuntoFin) {
        this.codPuntoFin = codPuntoFin;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(String IdPedido) {
        this.IdPedido = IdPedido;
    }
}