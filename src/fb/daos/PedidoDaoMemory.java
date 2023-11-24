package fb.daos;

import fb.model.Pedido;
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
public class PedidoDaoMemory implements EntidadService<Pedido> {

    private Pedido[] lista;
    private int indice;

    private static PedidoDaoMemory instancia;

    private PedidoDaoMemory() {
        lista = new Pedido[Constantes.CANTIDAD_MEMO];
        indice = -1;
        
    }
    public static PedidoDaoMemory getInstancia() {
        if (instancia == null) {
            instancia = new PedidoDaoMemory();
        }
        return instancia;
    }

    @Override
    public boolean create(Pedido pedido) {
        boolean result = false;
        String id;
        if (pedido instanceof Pedido) {
            indice++;
            id = "PD" + String.valueOf(indice + 10001).substring(1);
            pedido.setId(id);
            lista[indice] = pedido;
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
    public boolean update(Pedido pedido) {
        boolean result = false;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(pedido.getId())) {
                lista[i] = pedido;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean createFromFile(Pedido pedido) {
        boolean result = false;
        String id;
        if (pedido instanceof Pedido) {
            indice++;
            lista[indice] = pedido;
            quickSort();
            result = true;
        }
        return result;
    }

    @Override
    public Pedido findById(String id) {
        Pedido result = null;
        for (int i = 0; i < getCantidad(); i++) {
            if (lista[i].getId().equals(id)) {
                result = lista[i];
                break;
            }
        }
        return result;
    }

    @Override
    public Pedido[] findAll() {
        List<Pedido> result = new ArrayList<>();
        for (int i = 0; i < getCantidad(); i++) {
            result.add(lista[i]);
        }
        return result.toArray(new Pedido[0]);
    }

    @Override
    public Pedido[] findByName(String nombre) {
        
            
        return null;
        
            
    }

        @Override
    public int getCantidad() {
        return indice + 1;
    }

    @Override
    public void quickSort() {
        
    }
}
