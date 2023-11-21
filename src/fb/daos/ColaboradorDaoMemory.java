/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Colaborador;
import fb.service.EntidadService;
import fb.util.Constantes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ColaboradorDaoMemory implements EntidadService<Colaborador> {

    private Colaborador[] lista;
    private int indice;

    private static ColaboradorDaoMemory instancia;

    private ColaboradorDaoMemory() {
        lista = new Colaborador[Constantes.CANTIDAD_MEMO];
        indice = -1;

        // <editor-fold defaultstate="collapsed" desc="Data de prueba">
        Colaborador t1 = new Colaborador(
                "Ángel",
                "Tambraico",
                "Mauricio",
                "Av. Universitaria 123",
                "941686406"
        );
        Colaborador t2 = new Colaborador(
                "Alvaro",
                "Escudero",
                "Príncipe",
                "Av. Universitaria 456",
                "941686789"
        );
        Colaborador t3 = new Colaborador(
                "Airton",
                "Collachaua",
                "Poma",
                "Av. Universitaria 456",
                "941686178"
        );
        Colaborador t4 = new Colaborador(
                "Juan",
                "Flores",
                "Moreno",
                "Av. Universitaria 295",
                "941686307"
        );
        Colaborador t5 = new Colaborador(
                "Franco Antonio",
                "Matos",
                "Ramos",
                "Av. Universitaria 2184",
                "941686128"
        );
        create(t1);
        create(t2);
        create(t3);
        create(t4);
        create(t5);
        
        // </editor-fold>
    }

    public static ColaboradorDaoMemory getInstancia() {
        if (instancia == null) {
            instancia = new ColaboradorDaoMemory();
        }
        return instancia;
    }

    @Override
    public boolean create(Colaborador t) {
        boolean result = false;
        String id;
        if (t instanceof Colaborador) {
            indice++;
            id = "CO" + String.valueOf(indice + 10001).substring(1);
            t.setId(id);
            lista[indice] = t;
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
    public boolean update(Colaborador t) {
        boolean result = false;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(t.getId())) {
                lista[i] = t;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Colaborador findById(String id) {
        Colaborador result = null;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                result = lista[i];
                break;
            }
        }
        return result;
    }

    @Override
    public Colaborador[] findAll() {
        List<Colaborador> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            result.add(lista[i]);
        }
        return result.toArray(new Colaborador[0]);
    }

    @Override
    public Colaborador[] findByName(String name) {
        List<Colaborador> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getNombres().contains(name)) {
                result.add(lista[i]);
            }
        }
        return result.toArray(new Colaborador[0]);
    }

    @Override
    public int getCantidad() {
        return indice + 1;
    }

    @Override
    public Colaborador[] orderByName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
