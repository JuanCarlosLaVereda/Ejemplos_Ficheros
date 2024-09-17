package ficheroaccesoaleatorio;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String direccion;

    public Persona(String nombre, String apellido, int edad, String sexo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getSexo() {
        return sexo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\nApellido: " + getApellido() + "\nEdad: " + getEdad() +
                "\nSexo: " + getSexo() + "\nDireccion: " + getDireccion();
    }
}
