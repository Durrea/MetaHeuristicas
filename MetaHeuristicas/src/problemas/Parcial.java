/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemas;

import gestorArchivos.LeerFichero;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ingesis
 */
public class Parcial implements IntProblema {

    private static Parcial parcial;
    ArrayList<ArrayList<Double>> miFichero;
    LeerFichero fichero = new LeerFichero();

    public Parcial() throws IOException {
        miFichero = fichero.muestraContenido("datos.txt");
    }

    public static Parcial getInstance() throws IOException {
        if (parcial == null) {
            parcial = new Parcial();
        }
        return parcial;
    }

    @Override
    public double generarEvaluacion(ArrayList<Double> individuo) {
        double evaluacion;
        double error;
        double errorTotal = 0;
        int contador;
        for (int i = 0; i < miFichero.size(); i++) {
            evaluacion = 0;
            error = 0;
            contador = 1;
            for (int j = 0; j < miFichero.get(i).size() - 1; j++) {
                evaluacion = evaluacion + miFichero.get(i).get(j) * individuo.get(contador);
                contador++;
            }
            for (int j = 0; j < miFichero.get(i).size() - 1; j++) {
                for (int k = j; k < miFichero.get(i).size() - 1; k++) {
                    evaluacion = evaluacion + miFichero.get(i).get(j) * miFichero.get(i).get(k) * individuo.get(contador);
                    //System.out.println(contador);
                    contador++;

                }
            }
            evaluacion = evaluacion + individuo.get(0);
            error = miFichero.get(i).get(9) - evaluacion;
            error = Math.pow(error, 2);
            errorTotal = errorTotal + error;
            if(i==0 || i==1)
            {
                System.out.println("evaluacion:" + evaluacion);
                System.out.println("error:" + error);
            }

        }
        return errorTotal;
    }

}
