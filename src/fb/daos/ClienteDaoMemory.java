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

        Cliente cliente1 = new Cliente(
                "John",
                "Casas",
                "Perez",
                "123 Av Peru",
                "123456789");
        create(cliente1);
        Cliente cliente2 = new Cliente("Carlos", "Gomez", "Ramirez", "456 Calle Lima", "987654322");
        create(cliente2);

        Cliente cliente3 = new Cliente("Ana", "Torres", "Cordova", "789 Jirón Arequipa", "234567891");
        create(cliente3);

        Cliente cliente4 = new Cliente("Eva", "Vargas", "Garcia", "101 Avenida Amazonas", "345678902");
        create(cliente4);

        Cliente cliente5 = new Cliente("Luis", "Lopez", "Cruz", "202 Calle Tacna", "456789013");
        create(cliente5);

        Cliente cliente6 = new Cliente("Sofia", "Flores", "Ortega", "303 Jirón Junin", "567890124");
        create(cliente6);

        Cliente cliente7 = new Cliente("Pedro", "Chavez", "Salazar", "404 Avenida Ayacucho", "678901235");
        create(cliente7);

        Cliente cliente8 = new Cliente("Laura", "Rojas", "Torres", "505 Calle Huancayo", "789012346");
        create(cliente8);

        Cliente cliente9 = new Cliente("Juan", "Mendoza", "Ramos", "606 Jirón Iquitos", "890123457");
        create(cliente9);

        Cliente cliente10 = new Cliente("Mariana", "Gutierrez", "Sanchez", "707 Avenida Cusco", "901234568");
        create(cliente10);

        Cliente cliente11 = new Cliente("Diego", "Alvarez", "Castro", "808 Calle Puno", "012345679");
        create(cliente11);

        Cliente cliente12 = new Cliente("Fabiola", "Mendez", "Lopez", "909 Jirón Huancavelica", "123456780");
        create(cliente12);

        Cliente cliente13 = new Cliente("Oscar", "Rivas", "Vega", "111 Avenida Tumbes", "234567891");
        create(cliente13);

        Cliente cliente14 = new Cliente("Rosa", "Herrera", "Soto", "222 Calle Huaraz", "345678902");
        create(cliente14);

        Cliente cliente15 = new Cliente("Hugo", "Carranza", "Delgado", "333 Jirón Trujillo", "456789013");
        create(cliente15);

        Cliente cliente16 = new Cliente("Maria", "Paredes", "Flores", "444 Avenida Chiclayo", "567890124");
        create(cliente16);

        Cliente cliente17 = new Cliente("Eduardo", "Vega", "Hidalgo", "555 Calle Piura", "678901235");
        create(cliente17);

        Cliente cliente18 = new Cliente("Silvia", "Santos", "Morales", "666 Jirón Cajamarca", "789012346");
        create(cliente18);

        Cliente cliente19 = new Cliente("Ricardo", "Castañeda", "Torres", "777 Avenida Ica", "890123457");
        create(cliente19);

        Cliente cliente20 = new Cliente("Amanda", "Moreno", "Rodriguez", "888 Calle Chimbote", "901234568");
        create(cliente20);
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
            id = "CL" + String.valueOf(indice + 10001).substring(1);
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
                for (int i = mid - 1; i >= 0 && (lista[i].getNombre().contains(nombreMinusculas) || lista[i].getDireccion().contains(nombreMinusculas)); i--) {
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

    @Override
    public Cliente[] orderByName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
