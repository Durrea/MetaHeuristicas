/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import algoritmos.AlgoritmoAbstract;
import algoritmos.HillClimbing;
import algoritmos.HillClimbingMP;
import algoritmos.HillClimbingMPR;
import individuos.IntIndividuo;
import problemas.Esfera;
import problemas.IntProblema;

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
        ejecutar();
    }

    private static void ejecutar() {
        int tam = 2;
        double max = 100;
        double min = -100;
        double cambio = 0.1;
        double iteraciones = 5000;
        int numVecinos = 5;
        IntProblema problema = Esfera.getInstance();

        double sumaEvaluaciones = 0;

        AlgoritmoAbstract algoritmo = new HillClimbing(problema, tam, max, min, cambio, iteraciones);
        IntIndividuo individuo;

        for (int i = 0; i < 50; i++) {
            individuo = algoritmo.run(i);
            sumaEvaluaciones += individuo.getEvaluacion();
        }
        System.out.println("HC --> La evaluación promedio fue de : " + sumaEvaluaciones / 50);

        algoritmo = new HillClimbingMP(problema, tam, max, min, cambio, iteraciones, numVecinos);

        for (int i = 0; i < 50; i++) {
            individuo = algoritmo.run(i);
            sumaEvaluaciones += individuo.getEvaluacion();
        }
        System.out.println("HC MP --> La evaluación promedio fue de : " + sumaEvaluaciones / 50);

        algoritmo = new HillClimbingMPR(problema, tam, max, min, cambio, iteraciones, numVecinos);

        for (int i = 0; i < 50; i++) {
            individuo = algoritmo.run(i);
            sumaEvaluaciones += individuo.getEvaluacion();
        }
        System.out.println("HC MPR --> La evaluación promedio fue de : " + sumaEvaluaciones / 50);
    }

}
