/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import individuos.IntIndividuo;
import individuos.SolucionEsfera;

/**
 *
 * @author Urrea
 */
public class HillClimbing implements IntAlgoritmo {

    private int i;
    private final int TAM;
    private final double MAX;
    private final double MIN;
    private final double CAMBIO;
    private final double ITERACIONES;

    public HillClimbing(int tam, double max, double min, double cambio, double iteraciones) {
        this.TAM = tam;
        this.MAX = max;
        this.MIN = min;
        this.CAMBIO = cambio;
        this.ITERACIONES = iteraciones;
    }

    @Override
    public IntIndividuo run() {
        IntIndividuo s = new SolucionEsfera();
        IntIndividuo r;
        s.generarConfiguracionRandom(TAM, MIN, MAX);
        i = 0;
        do {
            r = s.clonarIndividuo();
            r.tweak(CAMBIO, MIN, MAX);
            if (r.getEval() < s.getEval()) {
                s = r.clonarIndividuo();
            }
            i++;
        } while (i < ITERACIONES);

        //System.out.println("El mejor individuo obtuvo una evaluación final de: " + s.getEval());
        return s;
    }
}
