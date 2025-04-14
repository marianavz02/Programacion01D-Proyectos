package co.edu.uniquindio.poo;

public class Apoyo extends Vehiculo{
    private Funcion tipoFuncion;


    public Apoyo(String id, String modelo, int añoFabricacion, int kilometraje, Estado estadoOperativo, Funcion tipoFuncion) {
        super(id, modelo, añoFabricacion, kilometraje, estadoOperativo);
        this.tipoFuncion = tipoFuncion;
    }

    public Funcion getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(Funcion tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }

    @Override
    public void desplazar() {

    }

    @Override
    public String toString() {
        return "Apoyo{" +
                "tipoFuncion=" + tipoFuncion +
                ", id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", añoFabricacion=" + añoFabricacion +
                ", kilometraje=" + kilometraje +
                ", estadoOperativo=" + estadoOperativo +
                '}';
    }
}
