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
 * @author ingesis
 */
public class HillClimbingRR extends AlgoritmoAbstract {

    private int i;
    private int tiempo;
    int t;
    Individuo best;
    Individuo s;
    Individuo r;

    public HillClimbingRR(IntProblema problema, int tam, double max, double min, double cambio, double iteraciones, int tiempo) {
        super(problema, tam, max, min, cambio, iteraciones);
        this.tiempo = tiempo;
    }

    @Override
    public Individuo run(long seed) {
        i = 0;
        Random aleatorio = new Random(seed);
        s = new Individuo(problema);
        s.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
        best = s;
        do {
            t = 0;
            while (t < tiempo) {
                r = s.clonarIndividuo();
                r.tweak(CAMBIO, MIN, MAX, aleatorio);
                if (r.getEval() < s.getEval()) {
                    s = r;
                }
                t++;
            }
            if (s.getEval() < best.getEval()) {
                best = s;
            }
            s = new Individuo(problema);
            s.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
            i++;
        } while (i < ITERACIONES);
        return best;
    }

}
