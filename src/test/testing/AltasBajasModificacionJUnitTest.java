package test.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import test.altas.AltasTest;
import test.bajas.BajasTest;
import test.modificacion.ModificacionTest;
import test.core.entrada.GestorEntradaTest;
import test.core.modelo.AsignaturaTest;
import test.core.modelo.EstudianteTest;
import test.core.salida.GestorSalidaTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AltasBajasModificacionJUnitTest {


    private static class FakeGestorEntradaTest extends GestorEntradaTest {
        private Queue<Object> inputs = new LinkedList<>();

        public void addInput(Object value) {
            inputs.add(value);
        }

        @Override
        public int leerEntero(String mensaje) {
            Object value = inputs.poll();
            if (value instanceof Integer) {
                return (Integer) value;
            }
            throw new IllegalArgumentException("Se esperaba un entero");
        }

        @Override
        public String leerTexto(String mensaje) {
            Object value = inputs.poll();
            if (value instanceof String) {
                return (String) value;
            }
            throw new IllegalArgumentException("Se esperaba un texto");
        }

        @Override
        public double leerDecimal(String mensaje) {
            Object value = inputs.poll();
            if (value instanceof Double) {
                return (Double) value;
            } else if (value instanceof Integer) {
                return ((Integer) value).doubleValue();
            }
            throw new IllegalArgumentException("Se esperaba un número decimal");
        }
    }

    @Test
    public void testAltaEstudianteHappyPath() {
        FakeGestorEntradaTest entradaFake = new FakeGestorEntradaTest();
        entradaFake.addInput(101);
        entradaFake.addInput("Estudiante Test");
        entradaFake.addInput(20);
        entradaFake.addInput("01/01/2004");
        entradaFake.addInput("Matemáticas");
        entradaFake.addInput(8.5);
        entradaFake.addInput("Historia");
        entradaFake.addInput(7.0);

        ArrayList<EstudianteTest> estudiantes = new ArrayList<>();
        GestorSalidaTest salida = new GestorSalidaTest();
        AltasTest altas = new AltasTest(entradaFake, salida, estudiantes);

        altas.agregarEstudiante();


        assertEquals(1, estudiantes.size());
        EstudianteTest est = estudiantes.get(0);
        assertEquals(101, est.getId());
        assertEquals("Estudiante Test", est.getNombreCompleto());
        assertEquals(20, est.getEdad());
        assertEquals("01/01/2004", est.getFechaNacimiento());

        assertNotNull(est.getAsignaturas());
        assertEquals("Matemáticas", est.getAsignaturas()[0].getNombre());
        assertEquals(8.5, est.getAsignaturas()[0].getNota());
        assertEquals("Historia", est.getAsignaturas()[1].getNombre());
        assertEquals(7.0, est.getAsignaturas()[1].getNota());
    }

    @Test
    public void testBajaEstudianteHappyPath() {
        ArrayList<EstudianteTest> estudiantes = new ArrayList<>();
        EstudianteTest est = new EstudianteTest(202, "Estudiante Baja", 21, "02/02/2003");
        est.setAsignaturas(new AsignaturaTest("Lengua", 7.5), new AsignaturaTest("Ciencias", 8.0));
        estudiantes.add(est);


        FakeGestorEntradaTest entradaFake = new FakeGestorEntradaTest();
        entradaFake.addInput(202);

        GestorSalidaTest salida = new GestorSalidaTest();
        BajasTest bajas = new BajasTest(entradaFake, salida, estudiantes);

        bajas.eliminarEstudiante();

        assertEquals(0, estudiantes.size());
    }

    @Test
    public void testModificacionEstudianteHappyPath() {

        ArrayList<EstudianteTest> estudiantes = new ArrayList<>();
        EstudianteTest est = new EstudianteTest(303, "Estudiante Modificación", 22, "03/03/2002");
        est.setAsignaturas(new AsignaturaTest("Geografía", 6.0), new AsignaturaTest("Historia", 7.0));
        estudiantes.add(est);

        FakeGestorEntradaTest entradaFake = new FakeGestorEntradaTest();
        entradaFake.addInput(303);
        entradaFake.addInput(1);
        entradaFake.addInput(9.0);

        GestorSalidaTest salida = new GestorSalidaTest();
        ModificacionTest modificacion = new ModificacionTest(entradaFake, salida, estudiantes);

        modificacion.modificarNota();


        assertEquals(9.0, est.getAsignaturas()[0].getNota());
    }
}