/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas;

import individuos.IntIndividuo;

/**
 *
 * @author Urrea
 */
public class Esfera implements IntProblema {

    @Override
    public double generarEvaluacion(IntIndividuo individuo) {
        double evaluacion = 0;
        for (int i = 0; i < individuo.getSolucion().size(); i++) {
            evaluacion += Double.parseDouble(individuo.getSolucion().get(i).toString()) * Double.parseDouble(individuo.getSolucion().get(i).toString());
        }
        System.out.println("Eval " + evaluacion);
        return evaluacion;
    }
}
