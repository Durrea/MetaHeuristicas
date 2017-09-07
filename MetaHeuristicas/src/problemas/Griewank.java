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
public class Griewank implements IntProblema {

    private static Griewank griewank;

    private Griewank() {
    }

    public static Griewank getInstance() {
        if (griewank == null) {
            griewank = new Griewank();
        }
        return griewank;
    }

    @Override
    public double generarEvaluacion(ArrayList<Double> individuo) {
        double sumsq = 0;
        double prod = 1;
        for (int i = 0; i < individuo.size(); ++i) {
            sumsq += individuo.get(i) * individuo.get(i);
            prod *= Math.cos(individuo.get(i) / Math.sqrt(i + 1));
        }
        return 1 + sumsq * (1.0 / 4000.0) - prod;
    }
}
