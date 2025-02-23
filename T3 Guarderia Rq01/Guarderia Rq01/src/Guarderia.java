    import java.util.LinkedList;

public class Guarderia {
    private String nombre;
    private String nit;
    private LinkedList<Estudiante> estudiantes;

    public Guarderia(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        estudiantes = new LinkedList<>();
    }


    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "Guarderia{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", estudiantes=" + estudiantes +
                '}';
    }

    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {

        estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
