package ficheroaccesoaleatorio;

import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        Persona persona = new Persona("Pepe", "Flores", 33, "Helicoptero Apache de Combate", "Su casa");


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.dat"))) {
            oos.writeObject(persona);
        } catch (IOException e){
            e.printStackTrace();
        }

        Persona persona1 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.dat"))){
            persona1 = (Persona) ois.readObject();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println(persona1);

    }
}
