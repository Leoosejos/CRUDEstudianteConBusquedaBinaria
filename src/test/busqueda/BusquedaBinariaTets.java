package test.busqueda;

import test.core.modelo.EstudianteTest;

import java.util.ArrayList;

public class BusquedaBinariaTets {
    public static int buscarEstudiantePorNombre(ArrayList<EstudianteTest> estudiantes, String nombre) {
        int izquierda = 0;
        int derecha = estudiantes.size() - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            String nombreMedio = estudiantes.get(medio).getNombreCompleto();
            int comparacion = nombreMedio.compareToIgnoreCase(nombre);
    }
}