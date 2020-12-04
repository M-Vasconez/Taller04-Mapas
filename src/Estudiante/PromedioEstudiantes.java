/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudiante;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matias Vasconez
 */
public class PromedioEstudiantes {

    public static HashMap<Estudiante, List<Double>> estudiantes;
    public static HashMap<Estudiante, Double> promediosEstudiantes;
    private static double minimo = 8.5;
    private static double maximo = 10;

    public static HashMap<Estudiante, List<Double>> leerArchivos(String archivo) {
        estudiantes = new HashMap();
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/Archivos/" + archivo + ".txt"));
            String linea = "";
            lector.readLine();
            while ((linea = lector.readLine()) != null) {
                String[] lineaSep = linea.split(",");
                String[] notas = lineaSep[3].split("/");
                Estudiante est = new Estudiante(Integer.parseInt(lineaSep[0]), lineaSep[1], lineaSep[2]);
                for (String nota1 : notas) {
                    Double nota = Double.parseDouble(nota1);
                    est.getListadoNotas().add(nota);
                }

                estudiantes.put(est, est.getListadoNotas());
//                System.out.println(est+"  =  "+est.getListadoNotas());
            }

            lector.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            System.err.println("Archivo no encontrado: " + ex);
        }

        return estudiantes;
    }

    public static HashMap<Estudiante, Double> calcularPromedios(HashMap<Estudiante, List<Double>> mp) {
        promediosEstudiantes = new HashMap();
        mp.entrySet().forEach(entry -> {
            List<Double> db = entry.getValue();
            double cont = 0;
            for (int i = 0; i < db.size(); i++) {
                cont += db.get(i);
            }
            double avg = cont / db.size();

            promediosEstudiantes.put(entry.getKey(), avg);
//            System.out.println(entry.getKey()+"   =  "+avg);
        });

        return promediosEstudiantes;
    }
    
    public static void obtenerMejoresPromedios(HashMap<Estudiante, Double> mp,double min ,double max ) throws Exception{
        ArrayList<Integer> mejoresEstudiantes = new ArrayList();
        if(min==0 && max ==0 ){
            min= minimo;
            max= maximo;
            System.out.println("\nComo ingreso valores de 0");
            System.out.println("El minimo sera 8.5 y el maximo de 10\n");
        }else if ( min > max){
            throw new Exception("El rango minimo es mayor al maximo");
        }else if (min<0 || max >10){
            throw new Exception("Los rangos estan fuera de los valores permitidos");
        }
        System.out.println("\nLos estudiantes acreditados para la beca son: ");
        for(Map.Entry<Estudiante, Double> entry: mp.entrySet()){
            if (entry.getValue()<=max && entry.getValue()>= min){
                mejoresEstudiantes.add(entry.getKey().getMatricula());
                System.out.println(entry.getKey().toString());
            }
            
            
        }

    }
}
