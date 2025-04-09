package test.bajas;

import test.core.entrada.GestorEntradaTest;
import test.core.modelo.EstudianteTest;
import test.core.salida.GestorSalidaTest;

import java.util.ArrayList;

public class BajasTest {
    private GestorEntradaTest entrada;
    private GestorSalidaTest salida;
    private ArrayList<EstudianteTest> estudiantes;

    public BajasTest(GestorEntradaTest entrada, GestorSalidaTest salida, ArrayList<EstudianteTest> estudiantes) {
        this.entrada = entrada;
        this.salida = salida;
        this.estudiantes = estudiantes;
    }

    private EstudianteTest buscarEstudiantePorId(int id) {
        return estudiantes.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void eliminarEstudiante() {
        if (estudiantes.isEmpty()) {
            salida.mostrarMensajeSinEstudiantes();
            return;
        }

        salida.mostrarListaEstudiantes();
        for (EstudianteTest estudiante : estudiantes) {
            salida.mostrarEstudiante("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombreCompleto());
        }

        int id = entrada.leerEntero("Introduce el ID del estudiante a eliminar: ");

        EstudianteTest estudiante = buscarEstudiantePorId(id);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
            salida.mostrarMensajeBajaExitosa();
        } else {
            salida.mostrarMensajeNoSeEncontroId(id);
        }
    }
}
