package co.edu.uniquindio.poo;

public class Blindado extends Vehiculo{
    private String nivelBlindaje;

    public Blindado(String nivelBlindaje, String id, String modelo, int añoFabricacion, int kilometraje, Estado estadoOperativo) {
        super(id, modelo, añoFabricacion, kilometraje, estadoOperativo);
    }

    public String getNivelBlindaje() {
        return nivelBlindaje;
    }

    public void setNivelBlindaje(String nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }


    @Override
    public void desplazar() {

    }

    @Override
    public String toString() {
        return "Blindado{" +
                "nivelBlindaje='" + nivelBlindaje + '\'' +
                ", id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", añoFabricacion=" + añoFabricacion +
                ", kilometraje=" + kilometraje +
                ", estadoOperativo=" + estadoOperativo +
                '}';
    }
}
