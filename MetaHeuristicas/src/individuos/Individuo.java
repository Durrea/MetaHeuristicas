/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import problemas.Esfera;
import problemas.IntProblema;

/**
 *
 * @author Urrea
 */
public class Individuo implements IntIndividuo {

    private List solucion = new ArrayList();
    private double evaluacion;
    private IntProblema problema;

    public Individuo(IntProblema problema) {
        this.problema = problema;
    }

    @Override
    public void generarConfiguracionRandom(int tamaño, double min, double max, Random aleatorio) {
        for (int i = 0; i < tamaño; i++) {
            this.solucion.add((double) (aleatorio.nextDouble() * (max - min)) + min);
        }
        this.getEvaluacion();
    }

    @Override
    public void tweak(double cambio, double min, double max, Random aleatorio) {
        for (int posElemento = 0; posElemento < this.getSolucion().size(); posElemento++) {
            Double elementoTweak = ((Double) this.getSolucion().get(posElemento)) + ((double) (aleatorio.nextDouble() * (cambio * 2)) - cambio);
            if (elementoTweak < min) {
                elementoTweak = min;
            }
            if (elementoTweak > max) {
                elementoTweak = max;
            }
            this.getSolucion().set(posElemento, elementoTweak);
        }
        this.getEvaluacion();
    }

    @Override
    public void setEvaluacion(double evaluacion) {
        this.evaluacion = evaluacion;
    }

    @Override
    public double getEvaluacion() {
        this.setEvaluacion(this.problema.generarEvaluacion(this));
        return this.getEval();
    }

    @Override
    public IntIndividuo clonarIndividuo() {
        IntIndividuo clon = new Individuo(this.problema);
        for (int i = 0; i < this.getSolucion().size(); i++) {
            clon.getSolucion().add(this.getSolucion().get(i));
        }
        clon.setProblema(this.getProblema());
        clon.setEvaluacion(this.getEval());
        return clon;
    }

    @Override
    public List getSolucion() {
        return solucion;
    }

    @Override
    public void setSolucion(List solucion) {
        this.solucion = solucion;
    }

    @Override
    public double getEval() {
        return this.evaluacion;
    }

    @Override
    public IntProblema getProblema() {
        return problema;
    }

    @Override
    public void setProblema(IntProblema problema) {
        this.problema = problema;
    }

}
