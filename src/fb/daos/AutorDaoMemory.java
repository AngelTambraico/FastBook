/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Autor;
import fb.service.EntidadService;
import fb.util.Constantes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class AutorDaoMemory implements EntidadService<Autor>{  
    private Autor[] lista;
    private int indice;

    private static AutorDaoMemory instancia;

    private AutorDaoMemory() {
        lista = new Autor[Constantes.CANTIDAD_MEMO];
        indice = -1;

        Autor autorPrueba = new Autor(
                "Camila",
                "Garcia Chamorro",
                "Peruana"
        );
        create(autorPrueba);
    }

    public static AutorDaoMemory getInstancia() {
        if (instancia == null) {
            instancia = new AutorDaoMemory();
        }
        return instancia;
    }

    @Override
    public boolean create(Autor autor) {
        boolean result = false;
        String id;
        if (autor instanceof Autor) {
            indice++;
            id = "CO" + String.valueOf(indice + 10001).substring(1);
            autor.setId(id);
            lista[indice] = autor;
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
    public boolean update(Autor autor) {
        boolean result = false;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(autor.getId())) {
                lista[i] = autor;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Autor findById(String id) {
        Autor result = null;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                result = lista[i];
                break;
            }
        }
        return result;
    }

    @Override
    public Autor[] findAll() {
        List<Autor> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            result.add(lista[i]);
        }
        return result.toArray(new Autor[0]);
    }

    @Override
    public Autor[] findByName(String name) {
        quickSort();
        List<Autor> result = new ArrayList<>();
        String nombreMinusculas = name.toLowerCase(); 

        int left = 0;
        int right = getCantidad() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String nombreEnLista = lista[mid].getNombres().toLowerCase(); 

            int cmp = nombreEnLista.compareTo(nombreMinusculas);

            if (cmp == 0) {
                result.add(lista[mid]);
                for (int i = mid - 1; i >= 0 && lista[i].getNombres().equalsIgnoreCase(nombreMinusculas); i--) {
                    result.add(lista[i]);
                }
                for (int i = mid + 1; i < getCantidad() && lista[i].getNombres().equalsIgnoreCase(nombreMinusculas); i++) {
                    result.add(lista[i]);
                }
                return result.toArray(new Autor[0]);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result.toArray(new Autor[0]);
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
        Autor pivot = lista[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (lista[j].getNombres().compareTo(pivot.getNombres()) < 0) {
                i++;

                Autor temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        Autor temp = lista[i + 1];
        lista[i + 1] = lista[high];
        lista[high] = temp;

        return i + 1;
    }
    }
