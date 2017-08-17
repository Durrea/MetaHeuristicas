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
 * @author Urrea
 */
public class HillClimbing extends AlgoritmoAbstract {

    private int i;
    IntIndividuo s;
    IntIndividuo r;

    public HillClimbing(IntProblema problema, int tam, double max, double min, double cambio, double iteraciones) {
        super(problema, tam, max, min, cambio, iteraciones);
    }

    @Override
    public IntIndividuo run(long seed) {
        Random aleatorio = new Random(seed);
        s = new Individuo(problema);
        s.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
        i = 0;
        do {
            r = s.clonarIndividuo();
            r.tweak(CAMBIO, MIN, MAX, aleatorio);
            if (r.getEval() < s.getEval()) {
                s = r;
            }
            i++;
        } while (i < ITERACIONES);

        //System.out.println("El mejor individuo obtuvo una evaluación final de: " + s.getEval());
        return s;
    }

}
