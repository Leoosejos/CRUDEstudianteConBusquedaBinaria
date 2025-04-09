package test.core.modelo;

public class AsignaturaTest {
    private String nombre;
    private double nota;

    public AsignaturaTest(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() { return nombre; }
    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }
}
