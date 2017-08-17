/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import individuos.IntIndividuo;
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

    public abstract IntIndividuo run(long seed);
}
