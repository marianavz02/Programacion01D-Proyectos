package co.edu.uniquindio.poo;

public class TransporteTropa extends Vehiculo {
    private int capacidadSoldados;

    public TransporteTropa(String id, String modelo, int añoFabricacion, int kilometraje, Estado estadoOperativo, int capacidadSoldados) {
        super(id, modelo, añoFabricacion, kilometraje, estadoOperativo);
        this.capacidadSoldados = capacidadSoldados;
    }

    public int getCapacidadSoldados() {
        return capacidadSoldados;
    }

    public void setCapacidadSoldados(int capacidadSoldados) {
        this.capacidadSoldados = capacidadSoldados;
    }

    @Override
    public void desplazar() {

    }

    @Override
    public String toString() {
        return "TransporteTropa{" +
                "capacidadSoldados=" + capacidadSoldados +
                ", id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", añoFabricacion=" + añoFabricacion +
                ", kilometraje=" + kilometraje +
                ", estadoOperativo=" + estadoOperativo +
                '}';
    }
}
