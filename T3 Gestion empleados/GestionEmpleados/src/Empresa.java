import java.util.LinkedList;

public class Empresa {
    private int nit;
    private String nombre;
    private LinkedList<Empleado> empleados;


    public Empresa(int nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        empleados = new LinkedList<>();
    }


    public int getNit() {
        return nit;
    }
    public void setNit(int nit) {
        this.nit = nit;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "nit=" + nit +
                ", nombre='" + nombre + '\'' +
                "\n empleados=" + empleados +
                '}';
    }


    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
