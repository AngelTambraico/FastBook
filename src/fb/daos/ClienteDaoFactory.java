/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Cliente;
import fb.service.EntidadService;
import fb.util.Constantes;

public class ClienteDaoFactory {
    private static ClienteDaoFactory fabrica;

    private ClienteDaoFactory() {}

    public static ClienteDaoFactory getFabrica() {
        if (fabrica == null) {
            fabrica = new ClienteDaoFactory();
        }
        return fabrica;
    }

    public EntidadService<Cliente> getClienteDao(int tipo) {
        EntidadService<Cliente> e = null;
        switch (tipo) {
            case Constantes.MEMO:
                e = ClienteDaoMemory.getInstancia();
                break;
        }
        return e;
    }
}

