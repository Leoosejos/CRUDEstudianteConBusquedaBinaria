package main.core.modelo;

import main.altas.Altas;
import main.bajas.Bajas;
import main.core.entrada.GestorEntrada;
import main.core.salida.GestorSalida;
import main.lista.Listado;
import main.modificacion.Modificacion;
import main.core.modelo.Asignatura;

import java.util.ArrayList;

public class GestorEstudiantes {
    private ArrayList<Estudiante> estudiantes;
    private GestorEntrada entrada;
    private GestorSalida salida;
    private Altas altas;
    private Bajas bajas;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
        inicializarDatos(); // Se llenan 15 estudiantes de ejemplo
        entrada = new GestorEntrada();
        salida = new GestorSalida();
        altas = new Altas(entrada, salida, estudiantes);
        bajas = new Bajas(entrada, salida, estudiantes);
    }

    // Método para inicializar con 15 estudiantes de prueba
    public void inicializarDatos() {
        estudiantes.add(crearEstudiante(1, "Juan Pérez", 18, "15/02/2005", "Matemáticas", 8.5, "Literatura", 7.5));
        estudiantes.add(crearEstudiante(2, "María Rodríguez", 20, "10/05/2003", "Biología", 9.0, "Química", 8.0));
        estudiantes.add(crearEstudiante(3, "Carlos Sánchez", 19, "12/08/2004", "Historia", 7.0, "Geografía", 6.5));
        estudiantes.add(crearEstudiante(4, "Laura Rodríguez", 22, "22/11/2001", "Física", 8.2, "Matemáticas", 9.1));
        estudiantes.add(crearEstudiante(5, "Ana Martínez", 17, "03/03/2006", "Química", 7.8, "Biología", 8.3));
        estudiantes.add(crearEstudiante(6, "Luis Gómez", 21, "25/01/2002", "Filosofía", 6.5, "Historia", 7.2));
        estudiantes.add(crearEstudiante(7, "Elena Díaz", 20, "30/06/2003", "Literatura", 8.0, "Arte", 8.7));
        estudiantes.add(crearEstudiante(8, "Miguel Torres", 19, "17/09/2004", "Matemáticas", 9.3, "Física", 8.5));
        estudiantes.add(crearEstudiante(9, "Sofía Ramírez", 18, "05/12/2005", "Geografía", 7.9, "Historia", 7.8));
        estudiantes.add(crearEstudiante(10, "Diego Morales", 23, "14/04/2000", "Física", 8.1, "Química", 8.4));
        estudiantes.add(crearEstudiante(11, "Valeria Navarro", 17, "28/07/2006", "Biología", 8.0, "Matemáticas", 8.6));
        estudiantes.add(crearEstudiante(12, "Andrés Romero", 20, "11/11/2003", "Historia", 7.2, "Literatura", 7.9));
        estudiantes.add(crearEstudiante(13, "Camila Herrera", 18, "09/09/2005", "Arte", 8.5, "Filosofía", 8.0));
        estudiantes.add(crearEstudiante(14, "Felipe Morales", 19, "02/02/2004", "Matemáticas", 9.0, "Física", 8.8));
        estudiantes.add(crearEstudiante(15, "Isabella Castro", 22, "16/08/2001", "Química", 7.7, "Biología", 8.2));
    }

    // Método auxiliar para crear un estudiante con dos asignaturas
    private Estudiante crearEstudiante(int id, String nombre, int edad, String fechaNacimiento,
                                       String asignatura1Nombre, double asignatura1Nota,
                                       String asignatura2Nombre, double asignatura2Nota) {
        Estudiante estudiante = new Estudiante(id, nombre, edad, fechaNacimiento);
        Asignatura asignatura1 = new Asignatura(asignatura1Nombre, asignatura1Nota);
        Asignatura asignatura2 = new Asignatura(asignatura2Nombre, asignatura2Nota);
        estudiante.setAsignaturas(asignatura1, asignatura2);
        return estudiante;
    }

    public void agregarEstudiante() {
        altas.agregarEstudiante();
    }

    public void eliminarEstudiante() {
        bajas.eliminarEstudiante();
    }

    public void listarEstudiantes() {
        Listado listado = new Listado(salida, estudiantes);
        listado.listarEstudiantes();
    }

    public void modificarNota() {
        Modificacion modificacion = new Modificacion(entrada, salida, estudiantes);
        modificacion.modificarNota();
    }
}