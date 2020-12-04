/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Estudiante.Estudiante;
import Estudiante.PromedioEstudiantes;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Matias Vasconez
 */
public class Taller04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            HashMap<Estudiante, List<Double>> est = PromedioEstudiantes.leerArchivos("estudiantes");
            HashMap<Estudiante, Double> PromFinales = PromedioEstudiantes.calcularPromedios(est);

            Scanner sc = new Scanner(System.in);
            System.out.println("Bienvenidos al sistema de becas");
            System.out.println("Ingrese la nota final minima: ");
            double minimo = sc.nextDouble();
            System.out.println("Ingrese la nota final maxima: ");
            double maximo = sc.nextDouble();
            PromedioEstudiantes.obtenerMejoresPromedios(PromFinales, minimo, maximo);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
