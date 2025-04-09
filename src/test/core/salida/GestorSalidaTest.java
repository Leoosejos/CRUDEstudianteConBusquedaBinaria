package test.core.salida;

import test.core.modelo.EstudianteTest;

public class GestorSalidaTest {

    public GestorSalidaTest() {
    }
    public void mostrarMensajeIntroduceNumeroValido(){
        System.out.println("Por favor, introduce un número válido.");
    }
    public void mostrarMenu() {
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Eliminar estudiante");
        System.out.println("3. Modificar nota");
        System.out.println("4. Listar estudiantes");
        System.out.println("5. Salir");
        System.out.print("Ingrese la opcion que desee ejecutar:");
    }
    public void mostrarPrimeraAsignatura(){
        System.out.println("Primera Asignatura:");
    }

    public void mostrarSegundaAsignatura(){
        System.out.println("Segunda Asignatura:");
    }

    public void mostrarMensajeAlta() {
        System.out.println("Agregar un nuevo estudiante:");
    }

    public void mostrarMensajeIDpositivo() {
        System.out.println("El ID debe ser un número positivo.");
    }

    public void mostrarMensajeIDExistente() {
        System.out.println("Este ID ya existe. Introduce otro ID.");
    }

    public void mostrarMensaleIngresarEdad() {
        System.out.println("La edad debe estar entre 16 y 120 años.");
    }

    public void mostrarMensajeIngresarNota() {
        System.out.println("La nota debe estar entre 0 y 10.");
    }

    public void mostrarMensajeAltaExitosa() {
        System.out.println("Estudiante agregado exitosamente.");
    }

    public void mostrarMensajeSinEstudiantes() {
        System.out.println("No hay estudiantes en el sistema.");
    }

    public void mostrarMensajeBajaExitosa() {
        System.out.println("Estudiante eliminado exitosamente.");
    }

    public void mostrarMensajeNoSeEncontroId(int id) {
        System.out.println("No se encontró el estudiante con ID: " + id);
    }

    public void mostrarListaEstudiantes() {
        System.out.println("Lista de Estudiantes:");
    }

    public void mostrarEstudiante(String estudianteInfo) {
        System.out.println(estudianteInfo);
    }

    public void mostrarEstudianteDetalles(EstudianteTest estudiante) {
        System.out.println("ID: " + estudiante.getId());
        System.out.println("Nombre: " + estudiante.getNombreCompleto());
        System.out.println("Edad: " + estudiante.getEdad());
        System.out.println("Fecha de Nacimiento: " + estudiante.getFechaNacimiento());
        for (int i = 0; i < estudiante.getAsignaturas().length; i++) {
            System.out.println("Asignatura " + (i + 1) + ": " + estudiante.getAsignaturas()[i].getNombre() +
                    " - Nota: " + estudiante.getAsignaturas()[i].getNota());
        }
    }

    public void mostrarMensajeModificacionExitosa() {
        System.out.println("Nota modificada exitosamente.");
    }

    public void mostrarMensajeAsignaturaNoValida() {
        System.out.println("Número de asignatura no válido.");
    }

    public void mostrarMensajeNoSeEncontroId() {System.out.println("No se encontró el estudiante con el ID especificado.");}
    public void mostrarMensajeDespedida(){System.out.println("¡Gracias por usar el sistema!");}
    public void mostrarMensajeOpcionNoValida(){System.out.println("Opción no válida");}
    public void mostrarMensajePrimeraAsignatura(){System.out.println("Primera asignatura");}
    public void mostrarMnesajeSegundaAsignatura(){System.out.println(" Segunda Asignatura:");}
    public void mostrarMensajeNoValido(){System.out.println("Por favor, introduce un número válido.");}
}