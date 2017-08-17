/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import algoritmos.HillClimbing;
import algoritmos.IntAlgoritmo;
import individuos.IntIndividuo;

/**
 *
 * @author Urrea
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int tam = 2;
        double max = 100;
        double min = -100;
        double cambio = 0.1;
        double iteraciones = 9999;
        
        double sumaEvaluaciones = 0;

        IntAlgoritmo hillClimbing = new HillClimbing(tam, max, min, cambio, iteraciones);
        IntIndividuo individuo;
        
        for (int i = 0; i < 50; i++) {
            individuo = hillClimbing.run();
            sumaEvaluaciones += individuo.getEvaluacion();
        }
        
        System.out.println("La evaluación promedio fue de : " + sumaEvaluaciones/50);
        
    }

}
