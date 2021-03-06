/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudiante;

import java.util.LinkedList;

/**
 *
 * @author Matias Vasconez
 */
public class Estudiante {

    private int matricula;
    private String apellido;
    private String nombre;
    private float promedioFinal;
    private LinkedList<Double> listadoNotas;

    public Estudiante(int matricula, String apellido, String nombre) {
        this.matricula = matricula;
        this.apellido = apellido;
        this.nombre = nombre;
        listadoNotas = new LinkedList();
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " con matricula: " + matricula;
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

    public int getMatricula() {
        return matricula;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPromedioFinal() {
        return promedioFinal;
    }

    public LinkedList<Double> getListadoNotas() {
        return listadoNotas;
    }

}
