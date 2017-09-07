/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import individuos.Individuo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import problemas.IntProblema;

/**
 *
 * @author ingesis
 */
public abstract class AlgoritmoAbstract {

    public int i;
    public int TAM;
    public double MAX;
    public double MIN;
    public double CAMBIO;
    public double ITERACIONES;
    public IntProblema problema;

    public AlgoritmoAbstract(IntProblema problema, int tam, double max, double min, double cambio, double iteraciones) {
        this.problema = problema;
        this.TAM = tam;
        this.MAX = max;
        this.MIN = min;
        this.CAMBIO = cambio;
        this.ITERACIONES = iteraciones;
    }

    public abstract Individuo run(long seed);

    public double resultadoPromedio(int valorCentral) {
        ArrayList<Double> resultados = new ArrayList<>();
        double promedio = 0;
        Long tiempoInicio = System.currentTimeMillis();
        for (int j = 0; j < valorCentral; j++) {
            double resultado = this.run(j).getEval();
            resultados.add(resultado);
            promedio += resultado;
        }
        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.print(this.getClass().getSimpleName() + "\n");
        System.out.print("Mejor optimo: " + Collections.min(resultados) + " \t");
        System.out.print(" Peor optimo: " + Collections.max(resultados) + " \t");
        System.out.print(" Promedio de optimos: " + promedio / valorCentral + " \t");
        //Desviacion
        double varianza = 0;
        for (int i = 0; i < resultados.size(); i++) {
            double rango;
            rango = Math.pow(resultados.get(i) - promedio / valorCentral, 2f);
            varianza = varianza + rango;
        }
        varianza = varianza / 10f;//suma de diferencias sobre "n" o "n - 1"
        double desviacion = Math.sqrt(varianza);
        System.out.print(" Desviacion: " + desviacion + " \t");
        System.out.println("Tiempo (milisegundos):" + totalTiempo + " \t");
        System.out.println("");
        return (promedio / valorCentral);
    }
}
