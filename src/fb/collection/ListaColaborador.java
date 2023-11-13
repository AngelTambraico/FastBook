/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fb.collection;

import fb.model.Colaborador;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ListaColaborador {
    private ArrayList<Colaborador> array;

    public ListaColaborador(ArrayList<Colaborador> array) {
        this.array = array;
    }
    
    public boolean agregar(Colaborador entity){  
        boolean result = false;
        String id;
        if (entity instanceof Colaborador){
            id="CO"+String.valueOf((getCantidad()+1)+10000).substring(1);
            entity.setId(id);
            this.array.add(entity);
            result=true;
        }
        return result;       
    }
    
    public boolean actualizar(Colaborador entity){
        boolean result = false;
        if (entity instanceof Colaborador){
            Colaborador model = buscarPorId(entity.getId());
            model.setNombres(entity.getNombres());
            model.setApe_materno(entity.getApe_materno());
            
        }
        return result;
    }
    
    public boolean eliminar(String id){
        boolean result = false;
        Colaborador model = buscarPorId(id);
        model.setEstado("INACTIVO");
        return result;
    }
    
    public Colaborador buscarPorId(String id){
        Colaborador result = null;
        for (Colaborador entity : array) {
            if(entity.getId().equalsIgnoreCase(id)){
                result = entity;
                break;
            }
        }
        return result;
    }
    
    public ArrayList<Colaborador> buscarPorNombre(String nombre){
        ArrayList<Colaborador> result = null;
        
        return result;
    }

    public ArrayList<Colaborador> getArray() {
        return array;
    }
    
    public Integer getCantidad(){
        return this.array.size();
    }

    public void setArray(ArrayList<Colaborador> array) {
        this.array = array;
    }
}
