public class Empresa {
    private int nit;
    private String nombre;

    public Empresa(int nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
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
                '}';
    }
}
