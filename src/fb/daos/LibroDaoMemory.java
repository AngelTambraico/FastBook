/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Libro;
import fb.service.EntidadService;
import fb.util.Constantes;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class LibroDaoMemory implements EntidadService<Libro>{
    private Libro[] lista;
    private int indice;

    private static LibroDaoMemory instancia;

    private LibroDaoMemory() {
        lista = new Libro[Constantes.CANTIDAD_MEMO];
        indice = -1;

        //Datos de prueba
        Libro libro1 = new Libro("AU0001", "El señor de los anillos2", 29.99, 10);
        Libro libro2 = new Libro("AU0001", "Hamlet", 50, 30);
        Libro libro3 = new Libro("AU0001", "Casa Blanca", 35, 20);
        Libro libro4 = new Libro("AU0002", "El infinito", 140, 48);
        create(libro1);
        create(libro2);
        create(libro3);
        create(libro4);
    }

    public static LibroDaoMemory getInstancia() {
        if (instancia == null) {
            instancia = new LibroDaoMemory();
        }
        return instancia;
    }

    @Override
    public boolean create(Libro libro) {
        boolean result = false;
        String id;
        if (libro instanceof Libro) {
            indice++;
            id = "LI" + String.valueOf(indice + 10001).substring(1);
            libro.setId(id);
            lista[indice] = libro;
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean update(Libro libro) {
        boolean result = false;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(libro.getId())) {
                lista[i] = libro;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Libro findById(String id) {
        Libro result = null;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                result = lista[i];
                break;
            }
        }
        return result;
    }

    @Override
    public Libro[] findAll() {
        List<Libro> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            result.add(lista[i]);
        }
        return result.toArray(new Libro[0]);
    }

    @Override
    public Libro[] findByName(String title) {
        quickSort();
        
        if (!title.isEmpty()) {
            List<Libro> result = new ArrayList<>();
            String nombreMinusculas = title.toLowerCase();

            int left = 0;
            int right = getCantidad() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                String nombreEnLista = lista[mid].getTitulo().toLowerCase();

                int cmp = nombreEnLista.compareTo(nombreMinusculas);

                if (cmp == 0) {
                    result.add(lista[mid]);
                    for (int i = mid - 1; i >= 0 && lista[i].getTitulo().equalsIgnoreCase(nombreMinusculas); i--) {
                        result.add(lista[i]);
                    }
                    for (int i = mid + 1; i < getCantidad() && lista[i].getTitulo().equalsIgnoreCase(nombreMinusculas); i++) {
                        result.add(lista[i]);
                    }
                    return result.toArray(new Libro[0]);
                } else if (cmp < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result.toArray(new Libro[0]);
        }
        else    {
            return findAll();
        }
    }

    @Override
    public int getCantidad() {
        return indice + 1;
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
        Libro pivot = lista[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (lista[j].getTitulo().compareTo(pivot.getTitulo()) < 0) {
                i++;

                Libro temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        Libro temp = lista[i + 1];
        lista[i + 1] = lista[high];
        lista[high] = temp;

        return i + 1;
    }
}
