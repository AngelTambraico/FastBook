/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Punto;
import fb.service.EntidadService;
import fb.util.Constantes;

public class PuntoDaoFactory {
    private static PuntoDaoFactory fabrica;

    private PuntoDaoFactory() {}

    public static PuntoDaoFactory getFabrica() {
        if (fabrica == null) {
            fabrica = new PuntoDaoFactory();
        }
        return fabrica;
    }

    public EntidadService<Punto> getPuntoDao(int tipo) {
        EntidadService<Punto> e = null;
        switch (tipo) {
            case Constantes.MEMO:
                e = PuntoDaoMemory.getInstancia();
                break;
        }
        return e;
    }
}