/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Usuario;
import fb.service.UsuarioService;
import fb.util.Constantes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class UsuarioDaoMemory implements UsuarioService {

    private Usuario[] lista;
    private int indice;

    private static UsuarioDaoMemory instancia;

    private UsuarioDaoMemory() {
        lista = new Usuario[Constantes.CANTIDAD_MEMO];
        indice = -1;

        //Data de prueba
        Usuario t = new Usuario(
                "CO00001",
                "admin",
                "admin",
                "ADMINISTRADOR",
                "ACTIVO"
        );
        create(t);
    }

    public static UsuarioDaoMemory getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDaoMemory();
        }
        return instancia;
    }

    @Override
    public boolean create(Usuario t) {
        boolean result = false;
        String id;
        if (t instanceof Usuario) {
            indice++;
            id = "US" + String.valueOf(indice + 10000).substring(1);
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
    public boolean update(Usuario t) {
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
    public Usuario findById(String id) {
        Usuario result = null;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                result = lista[i];
                break;
            }
        }
        return result;
    }

    @Override
    public Usuario[] findAll() {
        List<Usuario> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            result.add(lista[i]);
        }
        return result.toArray(new Usuario[0]);
    }

    @Override
    public Usuario[] findByName(String name) {
        List<Usuario> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getUserName().contains(name)) {
                result.add(lista[i]);
            }
        }
        return result.toArray(new Usuario[0]);
    }

    @Override
    public int getCantidad() {
        return indice + 1;
    }
    
    @Override
    public Usuario login(String user, String password) {
        Usuario result = null;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getUserName().equals(user) && lista[i].getPassword().equals(password)) {
                result = lista[i];
                break;
            }
        }
        return result;
    }

    @Override
    public void quickSort() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
