/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import individuos.IntIndividuo;
import individuos.Individuo;
import java.util.Random;
import problemas.IntProblema;

/**
 *
 * @author ingesis
 */
public class HillClimbingMPR extends AlgoritmoAbstract {

    private int i;
    private final int NUM_VECINOS;

    public HillClimbingMPR(IntProblema problema, int tam, double max, double min, double cambio, double iteraciones, int numVecinos) {
        super(problema, tam, max, min, cambio, iteraciones);
        this.NUM_VECINOS = numVecinos;
    }

    @Override
    public Individuo run(long seed) {
        Random aleatorio = new Random(seed);
        Individuo s = new Individuo(problema);
        Individuo r;
        Individuo w;
        Individuo best;
        s.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
        best = s.clonarIndividuo();
        i = 0;
        do {
            r = s.clonarIndividuo();
            r.tweak(CAMBIO, MIN, MAX, aleatorio);
            for (int j = 0; j < NUM_VECINOS; j++) {
                w = s.clonarIndividuo();
                w.tweak(CAMBIO, MIN, MAX, aleatorio);
                if (w.getEval() < r.getEval()) {
                    r = w;
                }
            }
            s = r;
            if (s.getEval() < best.getEval()) {
                best = s.clonarIndividuo();
            }
            i++;
        } while (i < ITERACIONES);

        //System.out.println("El mejor individuo obtuvo una evaluación final de: " + s.getEval());
        return s;
    }


}
