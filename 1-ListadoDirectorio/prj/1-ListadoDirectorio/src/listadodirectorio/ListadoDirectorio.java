package listadodirectorio;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListadoDirectorio {
  
    public static void main(String[] args) {        
        String ruta="/etc";
        if(args.length>=1) ruta=args[0];
        File fich=new File(ruta);        
        if(!fich.exists()) {
            System.out.println("No existe el fichero o directorio ("+ruta+").");
        }
        else {
            if(fich.isFile()) {
                System.out.println(ruta+" es un fichero.");
            }
            else {
                System.out.println(ruta+" es un directorio. Contenidos: ");
                File[] ficheros=fich.listFiles(); // Ojo, ficheros o directorios
                for(File f : ficheros) {
                    String textoDescr=f.isDirectory() ? "/" :
                            f.isFile() ? "_" : "?";
                    String textoDatosExtra = "";
                    textoDatosExtra = permisos(textoDatosExtra, f);
                    Date date = new Date(f.lastModified());
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    textoDatosExtra += "ultima vez modificado: " + dateFormat.format(date);
                    if (f.isFile()) {
                        textoDatosExtra += ", tamaño=" + f.getTotalSpace();
                    }
                    System.out.println("("+textoDescr+") "+f.getName() + textoDatosExtra);
                }
            }
        }
    }

    private static String permisos(String textoDatosExtra, File f){
        if (f.canWrite()){
            textoDatosExtra += "es modificable, ";
        }
        if (f.canRead()){
            textoDatosExtra += "es legible, ";
        }
        if (f.canExecute()){
            textoDatosExtra += "es ejecutable, ";
        }
        return textoDatosExtra;
    }
}
