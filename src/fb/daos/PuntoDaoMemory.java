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
    public void quickSort() {
        quickSort(0, getCantidad() - 1);
    }
    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        Punto pivot = lista[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (lista[j].getDireccion().compareTo(pivot.getDireccion()) < 0) {
                i++;

                Punto temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        Punto temp = lista[i + 1];
        lista[i + 1] = lista[high];
        lista[high] = temp;

        return i + 1;
    }
    @Override
    public Punto[] findByName(String direccion) {
    quickSort();
    List<Punto> result = new ArrayList<>();
    String nombreMinusculas = direccion.toLowerCase(); 

    int left = 0;
    int right = getCantidad() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        String nombreEnLista = lista[mid].getDireccion().toLowerCase(); 

        int cmp = nombreEnLista.compareTo(nombreMinusculas);

        if (cmp == 0) {
            result.add(lista[mid]);
            for (int i = mid - 1; i >= 0 && lista[i].getDireccion().equalsIgnoreCase(nombreMinusculas); i--) {
                result.add(lista[i]);
            }
            for (int i = mid + 1; i < getCantidad() && lista[i].getDireccion().equalsIgnoreCase(nombreMinusculas); i++) {
                result.add(lista[i]);
            }
            return result.toArray(new Punto[0]);
        } else if (cmp < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return result.toArray(new Punto[0]);
}

    @Override
    public int getCantidad() {
        return indice + 1;
    }
}
