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
import algoritmos.HillClimbingRR;
import algoritmos.RandomSearch;
import algoritmos.SimulatedAnnealing;
import java.util.ArrayList;
import problemas.Griewank;
import problemas.IntProblema;
import problemas.Rastrigin;
import problemas.Schwefel;
import problemas.Sphere;
import problemas.Step;

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
        ejecutarTodo();

        //Incluir RS - HC RS - TS;
    }

    private static void ejecutarTodo() {
        ArrayList<AlgoritmoAbstract> algoritmos = new ArrayList();
        ArrayList<IntProblema> problemas = new ArrayList();

        int tam = 2;
        double max = 100;
        double min = -100;
        double cambio = 0.1;
        double iteraciones = 5000;
        int numVecinos = 5;
        int tiempo = 3;

        problemas.add(Griewank.getInstance());
        problemas.add(Rastrigin.getInstance());
        problemas.add(Schwefel.getInstance());
        problemas.add(Sphere.getInstance());
        problemas.add(Step.getInstance());

        AlgoritmoAbstract algoritmo;
        for (IntProblema problema : problemas) {
            System.out.println(problema.getClass());
            System.out.println("*******************************************************************");
            algoritmo = new HillClimbing(problema, tam, max, min, cambio, iteraciones);
            System.out.println("Promedio HC: " + algoritmo.resultadoPromedio(30));
            algoritmo = new HillClimbingMP(problema, tam, max, min, cambio, iteraciones, numVecinos);
            System.out.println("Promedio HCMP: " + algoritmo.resultadoPromedio(30));
            algoritmo = new HillClimbingMPR(problema, tam, max, min, cambio, iteraciones, numVecinos);
            System.out.println("Promedio HCMPR: " + algoritmo.resultadoPromedio(30));
            algoritmo = new RandomSearch(problema, tam, max, min, cambio, iteraciones);
            System.out.println("Promedio RS: " + algoritmo.resultadoPromedio(30));
            algoritmo = new HillClimbingRR(problema, tam, max, min, cambio, iteraciones, tiempo);
            System.out.println("Promedio HCRR: " + algoritmo.resultadoPromedio(30));
            algoritmo = new SimulatedAnnealing(problema, tam, max, min, cambio, iteraciones);
            System.out.println("Promedio SA: " + algoritmo.resultadoPromedio(30));
            System.out.println("*******************************************************************");
        }

    }

    private static void ejecutar() {
        int tam = 2;
        double max = 100;
        double min = -100;
        double cambio = 0.1;
        double iteraciones = 5000;
        int numVecinos = 5;
        int tiempo = 3;
        IntProblema problema = Griewank.getInstance();

        AlgoritmoAbstract algoritmo;

        algoritmo = new HillClimbing(problema, tam, max, min, cambio, iteraciones);
        System.out.println("Promedio HC: " + algoritmo.resultadoPromedio(30));
        algoritmo = new HillClimbingMP(problema, tam, max, min, cambio, iteraciones, numVecinos);
        System.out.println("Promedio HCMP: " + algoritmo.resultadoPromedio(30));
        algoritmo = new HillClimbingMPR(problema, tam, max, min, cambio, iteraciones, numVecinos);
        System.out.println("Promedio HCMPR: " + algoritmo.resultadoPromedio(30));
        algoritmo = new RandomSearch(problema, tam, max, min, cambio, iteraciones);
        System.out.println("Promedio RS: " + algoritmo.resultadoPromedio(30));
        algoritmo = new HillClimbingRR(problema, tam, max, min, cambio, iteraciones, tiempo);
        System.out.println("Promedio HCRR: " + algoritmo.resultadoPromedio(30));
        algoritmo = new SimulatedAnnealing(problema, tam, max, min, cambio, iteraciones);
        System.out.println("Promedio SA: " + algoritmo.resultadoPromedio(30));
    }

}
