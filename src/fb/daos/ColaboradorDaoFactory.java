/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Colaborador;
import fb.service.EntidadService;
import fb.util.Constantes;

/**
 *
 * @author USUARIO
 */
public class ColaboradorDaoFactory {
    private static ColaboradorDaoFactory fabrica;
    
    private ColaboradorDaoFactory(){}

    public static ColaboradorDaoFactory getFabrica(){
        if(fabrica==null)
        {
            fabrica = new ColaboradorDaoFactory();
        }
        return fabrica;
    }
    
    public EntidadService<Colaborador> getColaboradorDao(int tipo)
    {
        EntidadService<Colaborador> e = null;
        switch (tipo)
        {            
            case Constantes.MEMO: e = ColaboradorDaoMemory.getInstancia();break;
        }
        return e;
    }
}
