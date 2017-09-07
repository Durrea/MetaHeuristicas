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
public class Step implements IntProblema {

    private static Step step;

    private Step() {
    }

    public static Step getInstance() {
        if (step == null) {
            step = new Step();
        }
        return step;
    }

    @Override
    public double generarEvaluacion(ArrayList<Double> individuo) {
        double evaluacion = 0;
        for (int i = 0; i < individuo.size(); i++) {
            evaluacion += Math.floor(individuo.get(i) + 0.5) * Math.floor(individuo.get(i) + 0.5);
        }
        return evaluacion;
    }
}
