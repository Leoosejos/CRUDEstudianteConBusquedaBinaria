package test.altas;

import test.core.entrada.GestorEntradaTest;
import test.core.modelo.AsignaturaTest;
import test.core.modelo.EstudianteTest;
import test.core.salida.GestorSalidaTest;

import java.util.ArrayList;

public class AltasTest {
    private GestorEntradaTest entrada;
    private GestorSalidaTest salida;
    private ArrayList<EstudianteTest> estudiantes;

    public AltasTest(GestorEntradaTest entrada, GestorSalidaTest salida, ArrayList<EstudianteTest> estudiantes) {
        this.entrada = entrada;
        this.salida = salida;
        this.estudiantes = estudiantes;
    }

    private boolean existeId(int id) {
        return estudiantes.stream().anyMatch(e -> e.getId() == id);
    }

    public void agregarEstudiante() {
        salida.mostrarMensajeAlta();
        int id;
        do {
            id = entrada.leerEntero("Introduce ID (número positivo): ");
            if (id <= 0) {
                salida.mostrarMensajeIDpositivo();
                continue;
            }
            if (existeId(id)) {
                salida.mostrarMensajeIDExistente();
            }
        } while (id <= 0 || existeId(id));

        String nombreCompleto = entrada.leerTexto("Introduce nombre completo: ");

        int edad;
        do {
            edad = entrada.leerEntero("Introduce edad (entre 16 y 120 años): ");
            if (edad < 16 || edad > 120) {
                salida.mostrarMensaleIngresarEdad();
            }
        } while (edad < 16 || edad > 120);

        String fechaNacimiento = entrada.leerTexto("Introduce fecha de nacimiento (DD/MM/AAAA): ");

        EstudianteTest estudiante = new EstudianteTest(id, nombreCompleto, edad, fechaNacimiento);

        salida.mostrarPrimeraAsignatura();
        String nombreAsignatura1 = entrada.leerTexto("Nombre de la asignatura: ");
        double notaAsignatura1;
        do {
            notaAsignatura1 = entrada.leerDecimal("Nota (0-10): ");
            if (notaAsignatura1 < 0 || notaAsignatura1 > 10) {
                salida.mostrarMensajeIngresarNota();
            }
        } while (notaAsignatura1 < 0 || notaAsignatura1 > 10);

        AsignaturaTest asignatura1 = new AsignaturaTest(nombreAsignatura1, notaAsignatura1);

        salida.mostrarSegundaAsignatura();
        String nombreAsignatura2 = entrada.leerTexto("Nombre de la asignatura: ");
        double notaAsignatura2;
        do {
            notaAsignatura2 = entrada.leerDecimal("Nota (0-10): ");
            if (notaAsignatura2 < 0 || notaAsignatura2 > 10) {
                salida.mostrarMensajeIngresarNota();
            }
        } while (notaAsignatura2 < 0 || notaAsignatura2 > 10);

        AsignaturaTest asignatura2 = new AsignaturaTest(nombreAsignatura2, notaAsignatura2);

        estudiante.setAsignaturas(asignatura1, asignatura2);
        estudiantes.add(estudiante);

        salida.mostrarMensajeAltaExitosa();
    }
}