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
        Random aleatorio = new Random(seed);
        s = new Individuo(problema);
        s.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
        best = s;
        do {
            t = 0;
            do {
                r = s.clonarIndividuo();
                r.tweak(CAMBIO, MIN, MAX, aleatorio);
                if (r.getEval() < s.getEval()) {
                    s = r;
                }
                t++;
            } while (t < tiempo);
            if (s.getEval() < best.getEval()) {
                best = s;
            }
            i++;
        } while (i < ITERACIONES);
        //System.out.println("El mejor individuo obtuvo una evaluación final de: " + s.getEval());
        return best;
    }

}
