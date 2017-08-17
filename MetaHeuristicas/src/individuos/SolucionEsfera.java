/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuos;

import java.util.ArrayList;
import java.util.List;
import problemas.Esfera;
import problemas.IntProblema;

/**
 *
 * @author Urrea
 */
public class SolucionEsfera implements IntIndividuo {

    private List solucion = new ArrayList();
    private double evaluacion;

    @Override
    public void generarConfiguracionRandom(int tamaño, double min, double max) {
        for (int i = 0; i < tamaño; i++) {
            this.solucion.add((double) (Math.random() * (max - min)) + min);
            //System.out.println(this.solucion.get(i));
        }
        this.getEvaluacion();
    }

    @Override
    public void tweak(double cambio, double min, double max) {
        //int posElemento = (int) (Math.random() * (this.getSolucion().size()));
        for (int posElemento = 0; posElemento < this.getSolucion().size(); posElemento++) {
            Double elementoTweak = ((Double) this.getSolucion().get(posElemento)) + ((double) (Math.random() * (cambio * 2)) - cambio);
            while (elementoTweak < min || elementoTweak > max) {
                elementoTweak = ((Double) this.getSolucion().get(posElemento)) + ((double) (Math.random() * (cambio * 2)) - cambio);
            }
            //System.out.println(elementoTweak);
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
        IntProblema problema = new Esfera();
        this.setEvaluacion(problema.generarEvaluacion(this));
        return this.getEval();
    }

    @Override
    public IntIndividuo clonarIndividuo() {
        IntIndividuo clon = new SolucionEsfera();
        for (int i = 0; i < this.getSolucion().size(); i++) {
            clon.getSolucion().add(this.getSolucion().get(i));
        }
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

    public double getEval() {
        return this.evaluacion;
    }

}
