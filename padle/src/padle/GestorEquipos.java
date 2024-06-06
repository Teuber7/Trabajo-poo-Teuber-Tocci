package padle;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GestorEquipos {
    private LinkedList<Equipo> equipos;

    public LinkedList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(LinkedList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public GestorEquipos() {
        this.equipos = new LinkedList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void agregarEquipoRelleno(String nombre, String ciudad) {
        Equipo equipo = new Equipo(nombre, ciudad);
        agregarEquipo(equipo);
    }

    public Equipo buscarEquipoPorNombre(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    public LinkedList<Equipo> obtenerListaEquipos() {
        return equipos;
    }

    public void jugarPartido() {
        Equipo equipo1 = seleccionarEquipo("Ingrese el nombre del primer equipo:");
        if (equipo1 == null || equipo1.obtenerCantidadJugadores() < 2) {
            JOptionPane.showMessageDialog(null, "El primer equipo no tiene suficientes jugadores.");
            return;
        }

        Equipo equipo2 = seleccionarEquipo("Ingrese el nombre del segundo equipo:");
        if (equipo2 == null || equipo2.obtenerCantidadJugadores() < 2) {
            JOptionPane.showMessageDialog(null, "El segundo equipo no tiene suficientes jugadores.");
            return;
        }

        jugarPartido(equipo1, equipo2);
    }

    public void jugarPartido(Equipo equipo1, Equipo equipo2) {
        int setsEquipo1 = 0;
        int setsEquipo2 = 0;

        while (setsEquipo1 < 3 && setsEquipo2 < 3) {
            int juegosEquipo1 = 0;
            int juegosEquipo2 = 0;

            while (juegosEquipo1 < 6 && juegosEquipo2 < 6) {
                int puntoEquipo1 = (int) (Math.random() * 5);
                int puntoEquipo2 = (int) (Math.random() * 5);

                if (puntoEquipo1 > puntoEquipo2) {
                    juegosEquipo1++;
                } else {
                    juegosEquipo2++;
                }
            }

            if (juegosEquipo1 > juegosEquipo2) {
                setsEquipo1++;
            } else {
                setsEquipo2++;
            }
        }

        if (setsEquipo1 > setsEquipo2) {
            JOptionPane.showMessageDialog(null, "El ganador es el equipo: " + equipo1.getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "El ganador es el equipo: " + equipo2.getNombre());
        }
    }

    public void agregarJugador() {
        Equipo equipo = seleccionarEquipo("Ingrese el nombre del equipo para agregar un jugador:");
        if (equipo == null) return;

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
        int edad;
        while (true) {
            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
            if (edad <= 75) {
                break;
            }
            JOptionPane.showMessageDialog(null, "La edad no puede ser mayor a 75 años. Por favor, ingrese una edad válida.");
        }

        Jugador jugador = new Jugador(nombre, edad);
        equipo.agregarJugador(jugador);
        
    }

    public void buscarJugador() {
        Equipo equipo = seleccionarEquipo("Ingrese el nombre del equipo para buscar un jugador:");
        if (equipo == null) return;

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador a buscar:");
        Jugador jugador = equipo.buscarJugadorPorNombre(nombre);
        JOptionPane.showMessageDialog(null, jugador != null ? jugador : "Jugador no encontrado.");
    }

    public void agregarEquipo() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo:");
        String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad del equipo:");

        Equipo equipo = new Equipo(nombre, ciudad);
        agregarEquipo(equipo);
        JOptionPane.showMessageDialog(null, "Equipo agregado exitosamente.");
    }

    public void buscarEquipo() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo a buscar:");
        Equipo equipo = buscarEquipoPorNombre(nombre);
        JOptionPane.showMessageDialog(null, equipo != null ? equipo : "Equipo no encontrado.");
    }

    private Equipo seleccionarEquipo(String mensaje) {
        String nombre = JOptionPane.showInputDialog(mensaje);
        Equipo equipo = buscarEquipoPorNombre(nombre);
        if (equipo == null) {
            JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
        }
        return equipo;
    }
}


	

