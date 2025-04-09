package test.modificacion;

import test.core.entrada.GestorEntradaTest;
import test.core.modelo.EstudianteTest;
import test.core.salida.GestorSalidaTest;

import java.util.ArrayList;

public class ModificacionTest {
    private GestorEntradaTest entrada;
    private GestorSalidaTest salida;
    private ArrayList<EstudianteTest> estudiantes;

    public ModificacionTest(GestorEntradaTest entrada, GestorSalidaTest salida, ArrayList<EstudianteTest> estudiantes) {
        this.entrada = entrada;
        this.salida = salida;
        this.estudiantes = estudiantes;
    }

    private EstudianteTest buscarEstudiantePorId(int id) {
        return estudiantes.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void modificarNota() {
        if (estudiantes.isEmpty()) {
            salida.mostrarMensajeSinEstudiantes();
            return;
        }

        salida.mostrarListaEstudiantes();
        for (EstudianteTest estudiante : estudiantes) {
            salida.mostrarEstudiante("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombreCompleto());
        }

        int id = entrada.leerEntero("Introduce el ID del estudiante a modificar: ");

        EstudianteTest estudiante = buscarEstudiantePorId(id);
        if (estudiante != null) {
            int numAsignatura = entrada.leerEntero("Introduce el número de asignatura a modificar (1 o 2): ");
            if (numAsignatura == 1 || numAsignatura == 2) {
                double nuevaNota = entrada.leerDecimal("Introduce la nueva nota (0-10): ");
                estudiante.getAsignaturas()[numAsignatura - 1].setNota(nuevaNota);
                salida.mostrarMensajeModificacionExitosa();
            } else {
                salida.mostrarMensajeAsignaturaNoValida();
            }
        } else {
            salida.mostrarMensajeNoSeEncontroId();
        }
    }
}