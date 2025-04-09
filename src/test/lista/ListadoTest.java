package test.lista;

import test.core.modelo.EstudianteTest;
import test.core.salida.GestorSalidaTest;

import java.util.ArrayList;

public class ListadoTest {
    private GestorSalidaTest salida;
    private ArrayList<EstudianteTest> estudiantes;

    public ListadoTest(GestorSalidaTest salida, ArrayList<EstudianteTest> estudiantes) {
        this.salida = salida;
        this.estudiantes = estudiantes;
    }

    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            salida.mostrarMensajeSinEstudiantes();
            return;
        }

        salida.mostrarListaEstudiantes();
        for (EstudianteTest estudiante : estudiantes) {
            salida.mostrarEstudianteDetalles(estudiante);
        }
    }
}