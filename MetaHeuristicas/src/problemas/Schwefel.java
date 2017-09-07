/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas;

import java.util.ArrayList;

/**
 *
 * @author Urrea
 */
public class Schwefel implements IntProblema {

    private static Schwefel schwefel;

    private Schwefel() {
    }

    public static Schwefel getInstance() {
        if (schwefel == null) {
            schwefel = new Schwefel();
        }
        return schwefel;
    }

    @Override
    public double generarEvaluacion(ArrayList<Double> individuo) {
        double evaluacion = 0;
        double suma = 0;
        for (int i = 0; i < individuo.size(); i++) {
            for (int j = 0; j <= i; j++) {
                suma += individuo.get(i);
            }
            evaluacion += Math.pow(suma, 2);
        }
        return evaluacion;
    }
}
