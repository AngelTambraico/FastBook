/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fb.service;

import fb.model.Usuario;

/**
 *
 * @author USUARIO
 */
public interface UsuarioService extends EntidadService<Usuario>{
    public Usuario login(String user, String password);
}
