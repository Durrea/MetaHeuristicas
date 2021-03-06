/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import problemas.Sphere;
import problemas.IntProblema;

/**
 *
 * @author Urrea
 */
public class Individuo {

    private ArrayList<Double> solucion = new ArrayList();
    private double evaluacion;
    private IntProblema problema;

    public Individuo(IntProblema problema) {
        this.problema = problema;
    }

    public void generarConfiguracionRandom(int tamaño, double min, double max, Random aleatorio) {

        for (int i = 0; i < tamaño; i++) {
            if (aleatorio.nextDouble() > 0.5) {
                double valor = Redondear(aleatorio.nextDouble() * (max - min) + min);
                //System.out.println("vlor" + valor);
                this.solucion.add(valor);
            } else {
                this.solucion.add(0.0);
            }

        }
        this.getEvaluacion();
    }

    public void tweak(double cambio, double min, double max, Random aleatorio) {
        for (int posElemento = 0; posElemento < this.getSolucion().size(); posElemento++) {
            double elementoTweak = Redondear((double) this.getSolucion().get(posElemento) + ((aleatorio.nextDouble() * (cambio * 2)) - cambio));
            if (elementoTweak < min) {
                elementoTweak = min;
            }
            if (elementoTweak > max) {
                elementoTweak = max;
            }
            if (aleatorio.nextDouble() > 0.5) {
                this.getSolucion().set(posElemento, elementoTweak);
            } else {
                this.getSolucion().set(posElemento, 0.0);
            }

        }
        this.getEvaluacion();
    }

    public void setEvaluacion(double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public double getEvaluacion() {
        this.setEvaluacion(this.problema.generarEvaluacion(this.getSolucion()));
        return this.getEval();
    }

    public Individuo clonarIndividuo() {
        Individuo clon = new Individuo(this.problema);
        for (int i = 0; i < this.getSolucion().size(); i++) {
            clon.getSolucion().add(this.getSolucion().get(i));
        }
        clon.setProblema(this.getProblema());
        clon.setEvaluacion(this.getEval());
        return clon;
    }

    public ArrayList getSolucion() {
        return solucion;
    }

    public void setSolucion(ArrayList solucion) {
        this.solucion = solucion;
    }

    public double getEval() {
        return this.evaluacion;
    }

    public IntProblema getProblema() {
        return problema;
    }

    public void setProblema(IntProblema problema) {
        this.problema = problema;
    }

    public void improve(Random aleatorio, double bw, double min, double max) {
        int dimMod = aleatorio.nextInt(this.solucion.size());
        double elementoImprove = Redondear((double) this.getSolucion().get(dimMod) + aleatorio.nextDouble() * (bw * 2) - bw);
        if (elementoImprove < min) {
            elementoImprove = min;
        }
        if (elementoImprove > max) {
            elementoImprove = max;
        }
        if (aleatorio.nextDouble() > 0.5) {
            this.getSolucion().set(dimMod, elementoImprove);
        } else {
            this.getSolucion().set(dimMod, 0.0);
        }

    }

    public double Redondear(double numero) {
        return Math.rint(numero * 10) / 10;
    }
}
