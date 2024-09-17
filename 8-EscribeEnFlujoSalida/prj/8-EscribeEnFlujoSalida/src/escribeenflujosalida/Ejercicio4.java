package escribeenflujosalida;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    public static void main(String[] args) {
        String fichero_a_copiar_ruta = args[0];
        if (fichero_a_copiar_ruta.length()<1){
            System.out.println("El fichero de copiado no es valido");
            return;
        }
        File archivo = new File(fichero_a_copiar_ruta);

        List<String> lineas = new ArrayList<>();
        String linea = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter("fichero_copia.txt"));
            linea = br.readLine();
            System.out.println("Fichero a copiar ----------------------------------------------------------");
            int j = 1;
            while (linea != null) {
                lineas.add(linea);
                System.out.println("[" + j + "] " + linea);
                j++;
                linea = br.readLine();
            }
            System.out.println("Fichero copiado a la inversa ---------------------------------------------------------");
            for(int i = lineas.size(); i>0; i--){
                bw.write(lineas.get(i-1));
                bw.newLine();
                System.out.println("[" + i + "] " + lineas.get(i-1));
            }
            bw.close();
            System.out.println("Fichero copiado e invertido con exito.");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
