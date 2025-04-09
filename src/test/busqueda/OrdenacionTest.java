package test.busqueda;

import test.core.modelo.EstudianteTest;

import java.util.ArrayList;

public class OrdenacionTest {

    public static void ordenarEstudiantes(ArrayList<EstudianteTest> estudiantes) {
        int n = estudiantes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String nombreActual = estudiantes.get(j).getNombreCompleto();
                String nombreSiguiente = estudiantes.get(j + 1).getNombreCompleto();
                if (nombreActual.compareToIgnoreCase(nombreSiguiente) > 0) {
                    EstudianteTest temp = estudiantes.get(j);
                    estudiantes.set(j, estudiantes.get(j + 1));
                    estudiantes.set(j + 1, temp);
                }
            }
        }
    }
}