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
public class Sphere implements IntProblema {

    private static Sphere esfera;

    private Sphere() {
    }

    public static Sphere getInstance() {
        if (esfera == null) {
            esfera = new Sphere();
        }
        return esfera;
    }

    @Override
    public double generarEvaluacion(ArrayList<Double> individuo) {
        double evaluacion = 0;
        for (int i = 0; i < individuo.size(); i++) {
            //evaluacion += Double.parseDouble(individuo.getSolucion().get(i).toString()) * Double.parseDouble(individuo.getSolucion().get(i).toString());
            evaluacion += individuo.get(i) * individuo.get(i);
        }
        //System.out.println("Eval " + evaluacion);
        return evaluacion;
    }
}
