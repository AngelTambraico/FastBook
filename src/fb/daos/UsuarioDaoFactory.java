/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.daos;

import fb.model.Usuario;
import fb.service.UsuarioService;
import fb.util.Constantes;

/**
 *
 * @author USUARIO
 */
public class UsuarioDaoFactory {
    private static UsuarioDaoFactory fabrica;
    
    private UsuarioDaoFactory(){}

    public static UsuarioDaoFactory getFabrica(){
        if(fabrica==null)
        {
            fabrica = new UsuarioDaoFactory();
        }
        return fabrica;
    }
    
    public UsuarioService getUsuarioDao(int tipo)
    {
        UsuarioService e = null;
        switch (tipo)
        {            
            case Constantes.MEMO: e = UsuarioDaoMemory.getInstancia();break;
        }
        return e;
    }
}
