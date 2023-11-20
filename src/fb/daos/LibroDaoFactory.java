/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Libro;
import fb.service.EntidadService;
import fb.util.Constantes;

/**
 *
 * @author USUARIO
 */
public class LibroDaoFactory {
    private static LibroDaoFactory fabrica;

    private LibroDaoFactory() {}

    public static LibroDaoFactory getFabrica() {
        if (fabrica == null) {
            fabrica = new LibroDaoFactory();
        }
        return fabrica;
    }
//
//    public EntidadService<Libro> getLibroDao(int tipo) {
//        EntidadService<Libro> e = null;
//        switch (tipo) {
//            case Constantes.MEMO: 
//                e = LibroDaoMemory.getInstancia();
//            break;
//        }
//        return e;
//    }
}
