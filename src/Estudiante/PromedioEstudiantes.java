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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matias Vasconez
 */
public class PromedioEstudiantes {

    public static HashMap<Estudiante, List<Double>> estudiantes;
    public static HashMap<Estudiante, Double> promediosEstudiantes;

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
        for (Map.Entry<Estudiante, List<Double>> entry : mp.entrySet()) {
            List<Double> db =entry.getValue();
            System.out.println(db);
            double avg=0;
            for(int i = 0 ; i<db.size();i++){
                System.out.println(db.get(i));
                avg+=db.get(i);
            }
            promediosEstudiantes.put(entry.getKey(),avg);
        }
        

        return promediosEstudiantes;
    }
}
