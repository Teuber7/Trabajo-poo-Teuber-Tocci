package padle;

public class Jugador {
    private String nombre;
    private int edad;

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

   
    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre='" + nombre + '\'' + "edad=" + edad + '}';
    }
	}


