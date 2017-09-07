/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import individuos.Individuo;
import java.util.Random;
import problemas.IntProblema;

/**
 *
 * @author Urrea
 */
public class SimulatedAnnealing extends AlgoritmoAbstract {

    private double temp;
    private int i;
    Individuo s;
    Individuo best;
    Individuo r;

    public SimulatedAnnealing(IntProblema problema, int tam, double max, double min, double cambio, double iteraciones) {
        super(problema, tam, max, min, cambio, iteraciones);
    }

    @Override
    public Individuo run(long seed) {
        i = 0 ; temp = 100;
        Random aleatorio = new Random(seed);
        s = new Individuo(problema);
        s.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
        best = s;
        do {
            r = s.clonarIndividuo();
            r.tweak(CAMBIO, MIN, MAX, aleatorio);
            if (r.getEval() < s.getEval() || probabilidad(aleatorio)) {
                s = r.clonarIndividuo();
            }
            temp = temp * 0.99;
            if (s.getEval() < best.getEval()) {
                best = s.clonarIndividuo();
            }
            i++;
        } while (i < ITERACIONES);
        return best;
    }

    private boolean probabilidad(Random aleatorio) {
        return aleatorio.nextDouble() < Math.pow(Math.E, (-(r.getEval() - s.getEval()) / temp));
        //return aleatorio.nextDouble() < Math.exp((r.getEval()-s.getEval())/temp);
    }

}
