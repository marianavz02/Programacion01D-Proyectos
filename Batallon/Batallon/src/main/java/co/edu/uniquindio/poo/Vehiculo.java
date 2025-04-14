package co.edu.uniquindio.poo;

import java.util.LinkedList;

public abstract class Vehiculo {
    protected String id;
    protected String modelo;
    protected int añoFabricacion;
    protected int kilometraje;
    protected int misionesCompletadas;
    protected Estado estadoOperativo;
    protected LinkedList<Mision>listaMisiones;


    public Vehiculo(String id, String modelo, int añoFabricacion,
                    int kilometraje, Estado estadoOperativo) {

        this.id = id;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.kilometraje = kilometraje;
        this.estadoOperativo = estadoOperativo;
        this.misionesCompletadas = 0;
        this.listaMisiones = new LinkedList<>();
    }



    public abstract void desplazar();

    public boolean agregarMision(Mision newMision){
        return listaMisiones.add(newMision);
    }



    public int getMisionesCompletadas() {
        return misionesCompletadas;
    }

    public void setMisionesCompletadas(int misionesCompletadas) {
        this.misionesCompletadas = misionesCompletadas;
    }

    public LinkedList<Mision> getListaMisiones() {
        return listaMisiones;
    }

    public void setListaMisiones(LinkedList<Mision> listaMisiones) {
        this.listaMisiones = listaMisiones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Estado getEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(Estado estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", añoFabricacion=" + añoFabricacion +
                ", kilometraje=" + kilometraje +
                ", estadoOperativo=" + estadoOperativo +
                '}';
    }
}
