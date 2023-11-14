/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fb.service;

import fb.model.Cliente;

public interface ClienteService extends EntidadService<Cliente> {
    public Cliente[] findByNombre(String nombre);
}
