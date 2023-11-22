/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Punto;
import fb.service.EntidadService;
import fb.util.Constantes;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class PuntoDaoMemory implements EntidadService<Punto>{
    private Punto[] lista;
    private int indice;

    private static PuntoDaoMemory instancia;
    
    private PuntoDaoMemory() {
        lista = new Punto[Constantes.CANTIDAD_MEMO];
        indice = -1;

        //Datos de prueba
        //Punto punto1 = new Punto( "666", "666", callao, Av. Quilca 315, "En alcance");
        //create(libro1);
    }
    
    static EntidadService<Punto> getInstancia() {
         if (instancia == null) {
            instancia = new PuntoDaoMemory();
        }
        return instancia;
    }

    @Override
    public boolean create(Punto punto) {
        boolean result = false;
        String id;
        if (punto instanceof Punto) {
            indice++;
            id = "P" + String.valueOf(indice + 10000).substring(1);
            punto.setId(id);
            lista[indice] = punto;
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                lista[i].setEstado("INACTIVO");
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean update(Punto punto) {
        boolean result = false;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(punto.getId())) {
                lista[i] = punto;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Punto findById(String id) {
        Punto result = null;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                result = lista[i];
                break;
            }
        }
        return result;
    }

    @Override
    public Punto[] findAll() {
        List<Punto> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            result.add(lista[i]);
        }
        return result.toArray(new Punto[0]);
    }

    @Override
    public Punto[] findByName(String name) {
        List<Punto> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getDireccion().contains(name)) {
                result.add(lista[i]);
            }
        }
        return result.toArray(new Punto[0]);
    }

    @Override
    public int getCantidad() {
        return indice + 1;
    }

    @Override
    public void quickSort() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
