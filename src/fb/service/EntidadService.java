/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fb.service;

/**
 *
 * @author USUARIO
 */
public interface EntidadService<T> {
    public boolean create(T t);
    public boolean delete(String id);
    public boolean update(T t);
    public T findById(String id);
    public T[] findAll();
    public T[] findByName(String name);
    public int getCantidad();
}
