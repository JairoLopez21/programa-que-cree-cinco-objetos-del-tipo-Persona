import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Clase Persona
class Persona {
    private int identificador;
    private String nombre;

    public Persona(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }


    public String toString() {
        return "Persona{" + "identificador=" + identificador + ", nombre='" + nombre + '\'' + '}';
    }
}

// Interfaz Factory
interface PersonaFactory {
    List<Persona> crearListaOrdenada();
}

// Factory para orden ascendente
class AscendenteFactory implements PersonaFactory {
    public List<Persona> crearListaOrdenada() {
        List<Persona> personas = new ArrayList<>();
        // Agregar personas
        personas.add(new Persona(3, "Ana"));
        personas.add(new Persona(1, "Carlos"));
        personas.add(new Persona(5, "Sofía"));
        personas.add(new Persona(4, "Luis"));
        personas.add(new Persona(2, "María"));

        personas.sort(Comparator.comparingInt(Persona::getIdentificador));
        return personas;
    }
}

// Factory para orden descendente
class DescendenteFactory implements PersonaFactory {
    public List<Persona> crearListaOrdenada() {
        List<Persona> personas = new ArrayList<>();
        // Agregar personas
        personas.add(new Persona(3, "Ana"));
        personas.add(new Persona(1, "Carlos"));
        personas.add(new Persona(5, "Sofía"));
        personas.add(new Persona(4, "Luis"));
        personas.add(new Persona(2, "María"));

        personas.sort((p1, p2) -> Integer.compare(p2.getIdentificador(), p1.getIdentificador()));
        return personas;
    }
}

// Clase principal del Factory
class FactoryCreator {
    public static PersonaFactory getFactory(String tipoOrden) {
        if ("asc".equalsIgnoreCase(tipoOrden)) {
            return new AscendenteFactory();
        } else if ("desc".equalsIgnoreCase(tipoOrden)) {
            return new DescendenteFactory();
        }
        throw new IllegalArgumentException("Tipo de orden no soportado");
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear una lista ordenada según el criterio especificado
        PersonaFactory factory = FactoryCreator.getFactory("desc");
        List<Persona> personasOrdenadas = factory.crearListaOrdenada();

        // Imprimir la lista ordenada
        for (Persona persona : personasOrdenadas) {
            System.out.println(persona);
        }
    }
}