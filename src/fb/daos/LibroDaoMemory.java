/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;


import fb.model.Libro;
import fb.service.EntidadService;
import fb.util.Constantes;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
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

         cargarDatosDesdeCSV("Datos-Libros.csv");
    }
    private void cargarDatosDesdeCSV(String ruta) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(ruta), StandardCharsets.UTF_8))) {
        String linea;
        reader.readLine();
        while ((linea = reader.readLine()) != null) {
            String[] campos = linea.split(",");
            if (campos.length == 5) { 
                double precio = Double.parseDouble(campos[3].trim());
                int stock = Integer.parseInt(campos[4].trim());

                Libro libro = new Libro(
                        campos[0].trim(),
                        campos[1].trim(),
                        campos[2].trim(),
                        precio,
                        stock
                );
                createFromFile(libro);
            } else {
                System.err.println("Formato de línea incorrecto en el archivo CSV.");
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
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
            id = "LI" + String.valueOf(indice + 10001).substring(1);
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
        public boolean createFromFile(Libro libro) {
        boolean result = false;
        String id;
        if (libro instanceof Libro) {
            indice++;
            lista[indice] = libro;
            result = true;
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
        quickSort();
        List<Libro> result = new ArrayList<>();
        String nombreMinusculas = normalizarTexto(title).toLowerCase(); // Normalizar texto
        int left = 0;
        int right = getCantidad() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String nombresEnLista = normalizarTexto(lista[mid].getTitulo()).toLowerCase(); // Normalizar texto

            int cmp = nombresEnLista.compareTo(nombreMinusculas);

            if (cmp == 0) {
                result.add(lista[mid]);
                // Buscar hacia atrás
                for (int i = mid - 1; i >= 0 && normalizarTexto(lista[i].getTitulo()).toLowerCase().contains(nombreMinusculas); i--) {
                    result.add(lista[i]);
                }
                // Buscar hacia adelante
                for (int i = mid + 1; i < getCantidad() && normalizarTexto(lista[i].getTitulo()).toLowerCase().contains(nombreMinusculas); i++) {
                    result.add(lista[i]);
                }
                return result.toArray(new Libro[0]);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        for (int i = 0; i < getCantidad(); i++) {
            String nombreEnLista = normalizarTexto(lista[i].getTitulo()).toLowerCase(); // Normalizar texto
            if (nombreEnLista.contains(nombreMinusculas)) {
                result.add(lista[i]);
            }
        }

        return result.toArray(new Libro[0]);
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
        Libro pivot = lista[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compararConNormalizacion(lista[j].getTitulo(), pivot.getTitulo()) < 0) {
                i++;

                Libro temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        Libro temp = lista[i + 1];
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
