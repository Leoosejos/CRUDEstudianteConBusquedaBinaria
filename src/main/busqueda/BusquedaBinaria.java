package main.busqueda;

import main.core.modelo.Estudiante;
import java.util.ArrayList;

public class BusquedaBinaria {
    public static int buscarEstudiantePorNombre(ArrayList<Estudiante> estudiantes, String nombre) {
        int izquierda = 0;
        int derecha = estudiantes.size() - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            String nombreMedio = estudiantes.get(medio).getNombreCompleto();
            int comparacion = nombreMedio.compareToIgnoreCase(nombre);
    }
}