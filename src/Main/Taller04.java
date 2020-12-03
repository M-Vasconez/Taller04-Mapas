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

/**
 *
 * @author Matias Vasconez
 */
public class Taller04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<Estudiante, List<Double>> est=PromedioEstudiantes.leerArchivos("estudiantes");
        PromedioEstudiantes.calcularPromedios(est);
    }
    
}
