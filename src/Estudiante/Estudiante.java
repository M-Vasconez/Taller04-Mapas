/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudiante;

/**
 *
 * @author Matias Vasconez
 */
public class Estudiante {
    private int matricula;
    private String apellido;
    private String nombre;
    private float promedioFinal;
    private float []listadoNotas;

    public Estudiante(int matricula, String apellido, String nombre) {
        this.matricula = matricula;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "matricula=" + matricula + ", apellido=" + apellido + ", nombre=" + nombre ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.matricula;
        return hash;
    }
       
    
}
