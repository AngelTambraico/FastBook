/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Cliente;
import fb.service.EntidadService;
import fb.util.Constantes;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoMemory implements EntidadService<Cliente> {

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
                "123456789");
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
        Cliente pivot = lista[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (lista[j].getNombre().compareTo(pivot.getNombre()) < 0) {
                i++;

                Cliente temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        Cliente temp = lista[i + 1];
        lista[i + 1] = lista[high];
        lista[high] = temp;

        return i + 1;
    }
    @Override
        public Cliente[] findByName(String nombre) {
    quickSort();
    List<Cliente> result = new ArrayList<>();
    String nombreMinusculas = nombre.toLowerCase(); 

    int left = 0;
    int right = getCantidad() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        String nombreEnLista = lista[mid].getNombre().toLowerCase(); 

        int cmp = nombreEnLista.compareTo(nombreMinusculas);

        if (cmp == 0) {
            result.add(lista[mid]);
            for (int i = mid - 1; i >= 0 && lista[i].getNombre().equalsIgnoreCase(nombreMinusculas); i--) {
                result.add(lista[i]);
            }
            for (int i = mid + 1; i < getCantidad() && lista[i].getNombre().equalsIgnoreCase(nombreMinusculas); i++) {
                result.add(lista[i]);
            }
            return result.toArray(new Cliente[0]);
        } else if (cmp < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return result.toArray(new Cliente[0]);
}

    @Override
    public int getCantidad() {
        return indice + 1;
    }

   

}
