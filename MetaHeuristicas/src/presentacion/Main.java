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
import problemas.IntProblema;
import problemas.Esfera;

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
        
        //Incluir RS - HC RS - TS;
    }

    private static void ejecutar() {
        int tam = 2;
        double max = 100;
        double min = -100;
        double cambio = 0.1;
        double iteraciones = 5000;
        int numVecinos = 5;
        IntProblema problema = Esfera.getInstance();

        AlgoritmoAbstract algoritmo;

        algoritmo = new HillClimbing(problema, tam, max, min, cambio, iteraciones);
        System.out.println("Promedio HC: " + algoritmo.resultadoPromedio(50));
        algoritmo = new HillClimbingMP(problema, tam, max, min, cambio, iteraciones, numVecinos);
        System.out.println("Promedio HCMP: " + algoritmo.resultadoPromedio(50));
        algoritmo = new HillClimbingMPR(problema, tam, max, min, cambio, iteraciones, numVecinos);
        System.out.println("Promedio HCMPR: " + algoritmo.resultadoPromedio(50));
    }

}
