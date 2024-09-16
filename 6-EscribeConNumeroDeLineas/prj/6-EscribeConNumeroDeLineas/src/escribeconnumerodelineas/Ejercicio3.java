package escribeconnumerodelineas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Indicar por favor nombre de fichero y el texto a buscar");
            return;
        }
        String nomFich = args[0];
        String texto = args[1].toLowerCase();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFich))) {
            int i = 1;
            String linea = br.readLine().toLowerCase();
            boolean encontrado = false;
            List<Integer> encontrados = new ArrayList<>();

            while (linea != null) {
                int k = 0;
                for (int j=0; j<linea.length() && k<texto.length(); j++){
                    if (linea.toLowerCase().charAt(j) == texto.charAt(k)) {
                        k++;
                    } else {
                        k = 0;
                    }
                    if (k == texto.length()) {
                        encontrado = true;
                        encontrados.add((j-k)+2);
                        k = 0;
                    }
                }
                if (encontrado){
                    System.out.print("[" + i + "] " + encontrados.get(0));

                    for (int j = 1; j < encontrados.size(); j++) {
                        System.out.print(", " + encontrados.get(j));
                    }
                    System.out.println();
                }
                i++;
                encontrado = false;
                encontrados.clear();
                linea = br.readLine();
            }


        } catch (FileNotFoundException e){
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
