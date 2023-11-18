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
        //Libro libro1 = new Libro( "J.R.R. Tolkien", "El señor de los anillos", 29.99, 30, "En oferta");
        //create(libro1);
    }

    public static LibroDaoMemory getInstancia() {
        if (instancia == null) {
            instancia = new LibroDaoMemory();
        }
        return instancia;
    }

    public boolean create(Libro libro) {
        boolean result = false;
        String id;
        if (libro instanceof Libro) {
            indice++;
            id = "L" + String.valueOf(indice + 10000).substring(1);
            libro.setId(id);
            lista[indice] = libro;
            result = true;
        }
        return result;
    }

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

    public Libro[] findAll() {
        List<Libro> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            result.add(lista[i]);
        }
        return result.toArray(new Libro[0]);
    }

    public Libro[] findByTitle(String title) {
        List<Libro> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getTitulo().contains(title)) {
                result.add(lista[i]);
            }
        }
        return result.toArray(new Libro[0]);
    }

    public int getCantidad() {
        return indice + 1;
    }

    @Override
    public Libro[] findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
