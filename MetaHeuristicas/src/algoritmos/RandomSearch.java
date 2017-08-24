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
public class RandomSearch extends AlgoritmoAbstract {

    private int i;
    Individuo best;
    Individuo s;

    public RandomSearch(IntProblema problema, int tam, double max, double min, double cambio, double iteraciones) {
        super(problema, tam, max, min, cambio, iteraciones);
    }

    @Override
    public Individuo run(long seed) {
        Random aleatorio = new Random(seed);
        best = new Individuo(problema);
        best.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
        i = 0;
        do {
            s = new Individuo(problema);
            s.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
            if (s.getEval() < best.getEval()) {
                best = s;
            }
            i++;
        } while (i < ITERACIONES);
        //System.out.println("El mejor individuo obtuvo una evaluación final de: " + s.getEval());
        return best;
    }

}
