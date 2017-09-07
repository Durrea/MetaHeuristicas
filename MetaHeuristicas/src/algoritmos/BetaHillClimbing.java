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
public class BetaHillClimbing extends AlgoritmoAbstract {

    private int i;
    private double bw;
    private double b;
    Individuo x;
    Individuo x2;
    Individuo w;

    public BetaHillClimbing(IntProblema problema, int tam, double max, double min, double cambio, double iteraciones, double bw, double b) {
        super(problema, tam, max, min, cambio, iteraciones);
        this.bw = bw;
        this.b = b;
    }

    @Override
    public Individuo run(long seed) {
        Random aleatorio = new Random(seed);
        x = new Individuo(problema);
        x.generarConfiguracionRandom(TAM, MIN, MAX, aleatorio);
        i = 0;
        while (i <= ITERACIONES) {
            x2 = x.clonarIndividuo();
            x2.improve(aleatorio, bw, MIN, MAX);
            for (int j = 0; j < x.getSolucion().size(); j++) {
                if (aleatorio.nextDouble() <= b) {
                    x2.getSolucion().set(j, aleatorio.nextDouble() * (MAX - MIN) + MIN);
                }
            }
            x2.getEvaluacion();
            if (x2.getEval() < x.getEval()) {
                x = x2;
            }
            i++;
        }
        return x;
    }

}
