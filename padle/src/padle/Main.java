package padle;

import javax.swing.JOptionPane;

public class Main {
    private static GestorEquipos gestorEquipos = new GestorEquipos();

    public static void main(String[] args) {
        String[] opciones = {"Agregar Jugador", "Buscar Jugador", "Agregar Equipo", "Buscar Equipo", "Jugar Partido", "Mostrar Equipos", "Salir"};
        boolean correrAplicacion = true;
        String[][] equipos = {
            {"Boca Juniors", "Buenos Aires"},
            {"River Plate", "Buenos Aires"},
            {"Independiente", "Avellaneda"},
            {"Racing Club", "Avellaneda"},
            {"San Lorenzo", "Buenos Aires"},
            {"Vélez Sarsfield", "Buenos Aires"},
            {"Estudiantes", "La Plata"},
            {"Gimnasia y Esgrima", "La Plata"},
            {"Rosario Central", "Rosario"},
            {"Newell's Old Boys", "Rosario"}
        };

        // Imprimir la matriz de equipos
        for (int i = 0; i < equipos.length; i++) {
            gestorEquipos.agregarEquipoRelleno(equipos[i][0], equipos[i][1]);
        }

        while (correrAplicacion) {
            String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (eleccion == null || eleccion.equals("Salir")) {
                correrAplicacion = false;
            }

            switch (eleccion) {
                case "Agregar Jugador":
                    gestorEquipos.agregarJugador();
                    break;
                case "Buscar Jugador":
                    gestorEquipos.buscarJugador();
                    break;
                case "Agregar Equipo":
                    gestorEquipos.agregarEquipo();
                    break;
                case "Buscar Equipo":
                    gestorEquipos.buscarEquipo();
                    break;
                case "Jugar Partido":
                    gestorEquipos.jugarPartido();
                    break;
                case "Mostrar Equipos":
                    String descripcionEquipos = "";
                    for (Equipo equipo : gestorEquipos.getEquipos()) {
                        descripcionEquipos += equipo.getNombre() + " de " + equipo.getCiudad() + "\n" + equipo.getJugadores()+ "\n";
                    }
                    JOptionPane.showMessageDialog(null, descripcionEquipos);
                    break;
            }
        }
    }
}


