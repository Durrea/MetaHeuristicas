/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import algoritmos.AlgoritmoAbstract;
import algoritmos.BetaHillClimbing;
import algoritmos.HillClimbing;
import algoritmos.HillClimbingMP;
import algoritmos.HillClimbingMPR;
import algoritmos.HillClimbingRR;
import algoritmos.RandomSearch;
import algoritmos.SimulatedAnnealing;
import java.util.ArrayList;
import problemas.Ackley;
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

        ejecutar(Sphere.getInstance(), 100, -100);
        ejecutar(Step.getInstance(), 100, -100);
        ejecutar(Ackley.getInstance(), 32.768, -32.768);
        ejecutar(Rastrigin.getInstance(), 5.12, -5.12);
        ejecutar(Schwefel.getInstance(), 100, -100);
        ejecutar(Griewank.getInstance(), 600, -600);

        /*problemas.add(Griewank.getInstance());
        problemas.add(Rastrigin.getInstance());
        problemas.add(Schwefel.getInstance());
        problemas.add(Sphere.getInstance());
        problemas.add(Step.getInstance());
        problemas.add(Ackley.getInstance());

        AlgoritmoAbstract algoritmo;
        for (IntProblema problema : problemas) {
            System.out.println(problema.getClass());
            System.out.println("*******************************************************************");
            algoritmo = new HillClimbing(problema, tam, max, min, cambio, iteraciones);
            algoritmo.resultadoPromedio(30);
            //System.out.println("Promedio HC: " + algoritmo.resultadoPromedio(30));
            algoritmo = new HillClimbingMP(problema, tam, max, min, cambio, iteraciones / numVecinos, numVecinos);
            algoritmo.resultadoPromedio(30);
            //System.out.println("Promedio HCMP: " + algoritmo.resultadoPromedio(30));
            algoritmo = new HillClimbingMPR(problema, tam, max, min, cambio, iteraciones / numVecinos, numVecinos);
            algoritmo.resultadoPromedio(30);
            //System.out.println("Promedio HCMPR: " + algoritmo.resultadoPromedio(30));
            algoritmo = new RandomSearch(problema, tam, max, min, cambio, iteraciones);
            algoritmo.resultadoPromedio(30);
            //System.out.println("Promedio RS: " + algoritmo.resultadoPromedio(30));
            algoritmo = new HillClimbingRR(problema, tam, max, min, cambio, iteraciones / tiempo, tiempo);
            algoritmo.resultadoPromedio(30);
            //System.out.println("Promedio HCRR: " + algoritmo.resultadoPromedio(30));
            algoritmo = new SimulatedAnnealing(problema, tam, max, min, cambio, iteraciones);
            algoritmo.resultadoPromedio(30);
            //System.out.println("Promedio SA: " + algoritmo.resultadoPromedio(30));
            algoritmo = new BetaHillClimbing(problema, tam, max, min, cambio, iteraciones, bw, b);
            algoritmo.resultadoPromedio(30);
            //System.out.println("Promedio BHC: " + algoritmo.resultadoPromedio(30));
            System.out.println("*******************************************************************");
    }*/
    }

    private static void ejecutar(IntProblema problema, double max, double min) {
        int tam = 10;
        double cambio = 0.6;
        double iteraciones = 5000;
        int numVecinos = 5;
        int tiempo = 3;
        double bw = 0.6;
        double b = 0.5;

        AlgoritmoAbstract algoritmo;
        System.out.println("*******************************************************************");
        System.out.println(problema.getClass().getSimpleName());
        algoritmo = new HillClimbing(problema, tam, max, min, cambio, iteraciones);
        algoritmo.resultadoPromedio(30);
        //System.out.println("Promedio HC: " + algoritmo.resultadoPromedio(30));
        algoritmo = new HillClimbingMP(problema, tam, max, min, cambio, iteraciones / numVecinos, numVecinos);
        algoritmo.resultadoPromedio(30);
        //System.out.println("Promedio HCMP: " + algoritmo.resultadoPromedio(30));
        algoritmo = new HillClimbingMPR(problema, tam, max, min, cambio, iteraciones / numVecinos, numVecinos);
        algoritmo.resultadoPromedio(30);
        //System.out.println("Promedio HCMPR: " + algoritmo.resultadoPromedio(30));
        algoritmo = new RandomSearch(problema, tam, max, min, cambio, iteraciones);
        algoritmo.resultadoPromedio(30);
        //System.out.println("Promedio RS: " + algoritmo.resultadoPromedio(30));
        algoritmo = new HillClimbingRR(problema, tam, max, min, cambio, iteraciones / tiempo, tiempo);
        algoritmo.resultadoPromedio(30);
        //System.out.println("Promedio HCRR: " + algoritmo.resultadoPromedio(30));
        algoritmo = new SimulatedAnnealing(problema, tam, max, min, cambio, iteraciones);
        algoritmo.resultadoPromedio(30);
        //System.out.println("Promedio SA: " + algoritmo.resultadoPromedio(30));
        algoritmo = new BetaHillClimbing(problema, tam, max, min, cambio, iteraciones, bw, b);
        algoritmo.resultadoPromedio(30);
        //System.out.println("Promedio BHC: " + algoritmo.resultadoPromedio(30));
    }

}
