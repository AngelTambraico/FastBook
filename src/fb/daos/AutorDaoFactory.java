/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Autor;
import fb.service.EntidadService;
import fb.util.Constantes;

public class AutorDaoFactory {
    private static AutorDaoFactory fabrica;

    private AutorDaoFactory() {}

    public static AutorDaoFactory getFabrica() {
        if (fabrica == null) {
            fabrica = new AutorDaoFactory();
        }
        return fabrica;
    }

    public EntidadService<Autor> getAutorDao(int tipo) {
        EntidadService<Autor> e = null;
        switch (tipo) {
            case Constantes.MEMO:
                e = AutorDaoMemory.getInstancia();
                break;
        }
        return e;
    }
}
