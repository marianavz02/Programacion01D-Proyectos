package co.edu.uniquindio.poo;

public class Soldado {
    private int id;
    private String nombre;
    private Rango rango;
    private FuncionSoldado funcionSoldado;
    private int edad;
    private EstadoSoldado estadoSoldado;

    public Soldado(int id, String nombre, Rango rango, FuncionSoldado funcionSoldado,
                   int edad, EstadoSoldado estadoSoldado) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.funcionSoldado = funcionSoldado;
        this.edad = edad;
        this.estadoSoldado = estadoSoldado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public FuncionSoldado getFuncionSoldado() {
        return funcionSoldado;
    }

    public void setFuncionSoldado(FuncionSoldado funcionSoldado) {
        this.funcionSoldado = funcionSoldado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public EstadoSoldado getEstadoSoldado() {
        return estadoSoldado;
    }

    public void setEstadoSoldado(EstadoSoldado estadoSoldado) {
        this.estadoSoldado = estadoSoldado;
    }

    @Override
    public String toString() {
        return "Soldado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rango=" + rango +
                ", funcion=" + funcionSoldado +
                ", edad=" + edad +
                ", estadoSoldado=" + estadoSoldado +
                '}';
    }
}
