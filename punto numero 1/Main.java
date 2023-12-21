import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definición de la clase Persona
class Persona implements Comparable<Persona> {
    private int identificador;
    private String nombre;

    // Constructor
    public Persona(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    // Getter para identificador
    public int getIdentificador() {
        return identificador;
    }

    // Método para comparar Personas (usado en la ordenación)
    @Override
    public int compareTo(Persona otraPersona) {
        return Integer.compare(this.identificador, otraPersona.getIdentificador());
    }

    // Método para imprimir los datos de Persona
    @Override
    public String toString() {
        return "Persona{" + "identificador=" + identificador + ", nombre='" + nombre + '\'' + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear una lista de Personas
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(3, "Ana"));
        personas.add(new Persona(1, "Carlos"));
        personas.add(new Persona(5, "Sofía"));
        personas.add(new Persona(4, "Luis"));
        personas.add(new Persona(2, "María"));

        // Ordenar la lista por identificador
        Collections.sort(personas);

        // Imprimir la lista ordenada
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}