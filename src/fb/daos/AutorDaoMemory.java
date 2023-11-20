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
        List<Autor> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getNombres().contains(name)) {
                result.add(lista[i]);
            }
        }
        return result.toArray(new Autor[0]);
    }

    @Override
    public int getCantidad() {
        return indice + 1;
    }
}
