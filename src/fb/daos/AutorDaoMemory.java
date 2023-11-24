/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Autor;
import fb.service.EntidadService;
import fb.util.Constantes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class AutorDaoMemory implements EntidadService<Autor> {

    private Autor[] lista;
    private int indice;

    private static AutorDaoMemory instancia;

    private AutorDaoMemory() {
        lista = new Autor[Constantes.CANTIDAD_MEMO];
        indice = -1;
        cargarDatosDesdeCSV("Autores.csv");
    }

    private void cargarDatosDesdeCSV(String ruta) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            reader.readLine();
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(";");
                if (campos.length == 5) {

                    Autor autor = new Autor(
                            campos[0].trim(),
                            campos[1].trim(),
                            campos[2].trim(),
                            campos[3].trim(),
                            campos[4].trim()
                    );

                    createFromFile(autor);
                } else {
                    System.err.println("Formato de línea incorrecto en el archivo CSV.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            id = "AU" + String.valueOf(indice + 10001).substring(1);
            autor.setId(id);
            lista[indice] = autor;
            quickSort();
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

    public boolean createFromFile(Autor autor) {
        boolean result = false;
        String id;
        if (autor instanceof Autor) {
            indice++;
            lista[indice] = autor;
            quickSort();
            result = true;
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
    public Autor[] findByName(String nombre) {
        quickSort();
        List<Autor> result = new ArrayList<>();
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
                return result.toArray(new Autor[0]);
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

        return result.toArray(new Autor[0]);
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
        Autor pivot = lista[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compararConNormalizacion(lista[j].getNombreCompleto(), pivot.getNombreCompleto()) < 0) {
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

    private int compararConNormalizacion(String str1, String str2) {
        String str1Normalized = normalizarTexto(str1);
        String str2Normalized = normalizarTexto(str2);
        return str1Normalized.compareTo(str2Normalized);
    }
}
