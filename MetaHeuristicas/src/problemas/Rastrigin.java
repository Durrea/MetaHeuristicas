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
public class Rastrigin implements IntProblema {

    private static Rastrigin rastrigin;

    private Rastrigin() {
    }

    public static Rastrigin getInstance() {
        if (rastrigin == null) {
            rastrigin = new Rastrigin();
        }
        return rastrigin;
    }

    @Override
    public double generarEvaluacion(ArrayList<Double> individuo) {
        double evaluacion = 0;
        for (int i = 0; i < individuo.size(); i++) {
            evaluacion += Math.pow(individuo.get(i), 2.0) - 10.0 * Math.cos(2 * Math.PI * individuo.get(i)) + 10;
        }
        return evaluacion;
    }
}
