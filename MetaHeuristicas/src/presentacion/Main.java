/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import algoritmos.HillClimbing;
import algoritmos.IntAlgoritmo;

/**
 *
 * @author Urrea
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int tam = 1;
        double max = 5;
        double min = -5;
        double cambio = 0.1;
        double iteraciones = 3;

        IntAlgoritmo hillClimbing = new HillClimbing(tam, max, min, cambio, iteraciones);

        hillClimbing.run();
    }

}
