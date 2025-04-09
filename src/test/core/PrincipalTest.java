package test.core;

import test.core.entrada.GestorEntradaTest;
import test.core.modelo.GestorEstudiantesTest;
import test.core.salida.GestorSalidaTest;

public class PrincipalTest {

    public static void main(String[] args) {
        GestorEstudiantesTest gestor = new GestorEstudiantesTest();
        GestorEntradaTest entrada = new GestorEntradaTest();
        GestorSalidaTest salida = new GestorSalidaTest();

        boolean ejecutando = true;
        while (ejecutando) {
            salida.mostrarMenu();
            int opcion = entrada.leerEntero("");

            switch (opcion) {
                case 1:
                    gestor.agregarEstudiante();
                    break;
                case 2:
                    gestor.eliminarEstudiante();
                    break;
                case 3:
                    gestor.modificarNota();
                    break;
                case 4:
                    gestor.listarEstudiantes();
                    break;
                case 5:
                    ejecutando = false;
                    salida.mostrarMensajeDespedida();
                    break;
                default:
                    salida.mostrarMensajeOpcionNoValida();
            }
        }
    }
}