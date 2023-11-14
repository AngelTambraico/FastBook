/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Cliente;
import fb.service.ClienteService;
import fb.util.Constantes;

import java.util.ArrayList;
import java.util.List;

public class ClienteDaoMemory implements ClienteService {

    private Cliente[] lista;
    private int indice;

    private static ClienteDaoMemory instancia;

    private ClienteDaoMemory() {
        lista = new Cliente[Constantes.CANTIDAD_MEMO];
        indice = -1;

        Cliente clientePrueba = new Cliente(
                "John",
                "Casas",
                "Perez",
                "123 Av Peru",
                "123456789",
                "ACTIVO"
        );
        create(clientePrueba);
    }

    public static ClienteDaoMemory getInstancia() {
        if (instancia == null) {
            instancia = new ClienteDaoMemory();
        }
        return instancia;
    }

    @Override
    public boolean create(Cliente cliente) {
        boolean result = false;
        String id;
        if (cliente instanceof Cliente) {
            indice++;
            id = "CL" + String.valueOf(indice + 10000).substring(1);
            cliente.setId(id);
            lista[indice] = cliente;
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
    public boolean update(Cliente cliente) {
        boolean result = false;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(cliente.getId())) {
                lista[i] = cliente;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Cliente findById(String id) {
        Cliente result = null;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                result = lista[i];
                break;
            }
        }
        return result;
    }

    @Override
    public Cliente[] findAll() {
        List<Cliente> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            result.add(lista[i]);
        }
        return result.toArray(new Cliente[0]);
    }

    public Cliente[] findByNombre(String nombre) {
        List<Cliente> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getNombre().contains(nombre)) {
                result.add(lista[i]);
            }
        }
        return result.toArray(new Cliente[0]);
    }

    @Override
    public int getCantidad() {
        return indice + 1;
    }

    @Override
    public Cliente[] findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
