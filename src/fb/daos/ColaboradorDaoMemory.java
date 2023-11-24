/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Colaborador;
import fb.service.EntidadService;
import fb.util.Constantes;
import java.text.Normalizer;
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
    public Colaborador[] findByName(String nombre) {
        quickSort();
        List<Colaborador> result = new ArrayList<>();
        String nombreMinusculas = normalizarTexto(nombre).toLowerCase(); // Normalizar texto
        int left = 0;
        int right = getCantidad() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String nombresEnLista = normalizarTexto(lista[mid].getNombres()).toLowerCase(); // Normalizar texto

            int cmp = nombresEnLista.compareTo(nombreMinusculas);

            if (cmp == 0) {
                result.add(lista[mid]);
                // Buscar hacia atrás
                for (int i = mid - 1; i >= 0 && normalizarTexto(lista[i].getNombres()).toLowerCase().contains(nombreMinusculas); i--) {
                    result.add(lista[i]);
                }
                // Buscar hacia adelante
                for (int i = mid + 1; i < getCantidad() && normalizarTexto(lista[i].getNombres()).toLowerCase().contains(nombreMinusculas); i++) {
                    result.add(lista[i]);
                }
                return result.toArray(new Colaborador[0]);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        for (int i = 0; i < getCantidad(); i++) {
            String nombreEnLista = normalizarTexto(lista[i].getNombres()).toLowerCase(); // Normalizar texto
            if (nombreEnLista.contains(nombreMinusculas)) {
                result.add(lista[i]);
            }
        }
        return result.toArray(new Colaborador[0]);
    }
    
    private String normalizarTexto(String texto) {
    return Normalizer.normalize(texto, Normalizer.Form.NFD)
            .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
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
    Colaborador pivot = lista[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (compararConNormalizacion(lista[j].getNombres(), pivot.getNombres()) < 0) {
            i++;

            Colaborador temp = lista[i];
            lista[i] = lista[j];
            lista[j] = temp;
        }
    }
    Colaborador temp = lista[i + 1];
    lista[i + 1] = lista[high];
    lista[high] = temp;
    return i + 1;
    }
    
    private int compararConNormalizacion(String str1, String str2) {
        String str1Normalized = normalizarTexto(str1);
        String str2Normalized = normalizarTexto(str2);
        return str1Normalized.compareTo(str2Normalized);
    }
}
