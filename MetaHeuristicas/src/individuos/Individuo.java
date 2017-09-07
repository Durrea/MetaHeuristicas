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
public class Individuo{

    private ArrayList<Double> solucion = new ArrayList();
    private double evaluacion;
    private IntProblema problema;

    public Individuo(IntProblema problema) {
        this.problema = problema;
    }

    
    public void generarConfiguracionRandom(int tamaño, double min, double max, Random aleatorio) {
        for (int i = 0; i < tamaño; i++) {
            this.solucion.add((aleatorio.nextDouble() * (max - min)) + min);
        }
        this.getEvaluacion();
    }

    
    public void tweak(double cambio, double min, double max, Random aleatorio) {
        for (int posElemento = 0; posElemento < this.getSolucion().size(); posElemento++) {
            double elementoTweak = ((double) this.getSolucion().get(posElemento)) + ((aleatorio.nextDouble() * (cambio * 2)) - cambio);
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

}
