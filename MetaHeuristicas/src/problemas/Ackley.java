/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas;

import java.util.ArrayList;

/**
 *
 * @author ingesis
 */
public class Ackley implements IntProblema {

    private int a;
    private double b;
    private double c;

    private static Ackley ackley;

    private Ackley(int a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Ackley getInstance() {
        if (ackley == null) {
            ackley = new Ackley(20, 0.2, 2 * Math.PI);
        }
        return ackley;
    }

    @Override
    public double generarEvaluacion(ArrayList<Double> individuo) {
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < individuo.size(); i++) {
            sum1 += Math.pow(individuo.get(i), 2);
            sum2 += Math.cos(c * individuo.get(i));
        }
        return a + Math.exp(1) - a * Math.exp(-b * Math.sqrt(sum1 / individuo.size())) - Math.exp(sum2 / individuo.size());
    }

}
