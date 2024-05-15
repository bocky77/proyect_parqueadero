/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parkig;

import java.util.ArrayList;
import java.util.Collections;

public class Parking {
    private ArrayList<String> matriculas;
    private String nombre;

    public Parking(String nombre, int posicion ) {
        this.nombre = nombre;
        matriculas = new ArrayList<>(Collections.nCopies(posicion, null));
        
    }

    public String getNombre() {
        return nombre;
    }
    public void entrada(String matricula, int posicion) throws ParkingException{
        if(posicion>=matriculas.size() || posicion <0)
            throw new ParkingException("posicion inexistente ",matricula);
        if(matricula==null ||matricula.length()<4)
            throw new ParkingException("matricula incorrecta ", matricula);
        if(matriculas.get(posicion)!= null)
            throw new ParkingException("posicion ocupada ",matricula);
        if (matriculas.contains(matricula))
            throw new ParkingException("matricula repetida",matricula);
        matriculas.set(posicion, matricula);
          
    }
    public int salida (String matricula) throws ParkingException{
    if(matriculas.contains(matricula))
        throw new ParkingException("matricula no existente ",matricula);
    int posicion = matriculas.indexOf(matricula);
    matriculas.set(posicion, null);
    return posicion;
    }

    private static class ParkingException extends Exception {

        public ParkingException(String posicion_inexistente_, String matricula) {
        }
    }
    
    
}