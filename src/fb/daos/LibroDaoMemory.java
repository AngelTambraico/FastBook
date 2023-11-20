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

    @Override
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
        List<Libro> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getTitulo().contains(title)) {
                result.add(lista[i]);
            }
        }
        return result.toArray(new Libro[0]);
    }

    @Override
    public int getCantidad() {
        return indice + 1;
    }
}
