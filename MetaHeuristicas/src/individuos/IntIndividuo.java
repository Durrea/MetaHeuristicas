/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individuos;

import java.util.List;
import java.util.Random;
import problemas.IntProblema;

/**
 *
 * @author Urrea
 */
public interface IntIndividuo {

    public void generarConfiguracionRandom(int tam, double min, double max, Random aleatorio);

    public void tweak(double cambio, double min, double max, Random aleatorio);

    public void setEvaluacion(double evaluacion);

    public double getEvaluacion();

    public double getEval();

    public IntIndividuo clonarIndividuo();

    public List getSolucion();

    public void setSolucion(List solucion);
    
    public IntProblema getProblema();
    
    public void setProblema(IntProblema problema);

}
