package main.core;

import main.core.entrada.GestorEntrada;
import main.core.modelo.GestorEstudiantes;
import main.core.salida.GestorSalida;

public class Principal {

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        GestorEntrada entrada = new GestorEntrada();
        GestorSalida salida = new GestorSalida();

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