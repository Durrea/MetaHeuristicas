/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorArchivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerFichero {

    ArrayList<Double> dimensiones;
    ArrayList<ArrayList<Double>> datosArchivo = new ArrayList();

    public ArrayList muestraContenido(String archivo) throws FileNotFoundException, IOException {

        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            dimensiones = new ArrayList<>();
            String[] s = cadena.split(" ");
            for (String string : s) {
                if (!string.isEmpty()) {
                    dimensiones.add(Double.parseDouble(string.trim()));
                    //System.out.println(string.trim());
                }

            }
            datosArchivo.add(dimensiones);

        }
        b.close();
        return datosArchivo;
    }

    public ArrayList imprimirContenido() throws IOException {
        muestraContenido("datos.txt");
        /*for (int i = 0; i < datosArchivo.size(); i++) {
            for (int j = 0; j < datosArchivo.get(i).size(); j++) {
                System.out.print(datosArchivo.get(i).get(j) + " ");
                
            }
            System.out.println("");
        }*/
        return datosArchivo;
    }

}
