package listadodirectorio;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        String directorioBase = "/home/jsantamariap/Escritorio/pruebas";

        File file = new File(directorioBase+"/Directorio1");
        file.mkdir();
        File file1 = new File(file + "/Directorio2");
        file1.mkdir();
        File file2 = new File(file1 + "/Directorio3");
        file2.mkdir();
        File file3 = new File(file2 + "/MiFichero.txt");
        try {
            file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
