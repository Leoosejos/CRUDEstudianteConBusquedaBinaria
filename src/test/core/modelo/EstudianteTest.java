package test.core.modelo;

public class EstudianteTest {
    private int id;
    private String nombreCompleto;
    private int edad;
    private String fechaNacimiento;
    private AsignaturaTest[] asignaturas;

    public EstudianteTest(int id, String nombreCompleto, int edad, String fechaNacimiento) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.asignaturas = new AsignaturaTest[2];
    }

    public int getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public int getEdad() { return edad; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public AsignaturaTest[] getAsignaturas() { return asignaturas; }

    public void setAsignaturas(AsignaturaTest asignatura1, AsignaturaTest asignatura2) {
        asignaturas[0] = asignatura1;
        asignaturas[1] = asignatura2;
    }
}
