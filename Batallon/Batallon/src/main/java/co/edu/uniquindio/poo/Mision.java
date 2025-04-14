package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;


public class Mision {
    private int idMision;
    private LocalDate fecha;
    private String ubicacion;
    private LinkedList<Soldado>personal;
    private Vehiculo vehiculosAsignados;
    private boolean estadoMision;

    public Mision(int idMision, LocalDate fecha, String ubicacion, LinkedList<Soldado>personal,boolean estadoMision) {
        this.idMision = idMision;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.personal = new LinkedList<>();
        this.vehiculosAsignados = vehiculosAsignados;
        this.estadoMision = estadoMision;
    }


    public boolean getEstadoMision() {
        return estadoMision;
    }

    public void setEstadoMision(boolean estadoMision) {
        this.estadoMision = estadoMision;
    }

    public int getIdMision() {
        return idMision;
    }

    public void setIdMision(int idMision) {
        this.idMision = idMision;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LinkedList<Soldado> getPersonal() {
        return personal;
    }

    public void setPersonal(LinkedList<Soldado> personal) {
        this.personal = personal;
    }

    public Vehiculo getVehiculosAsignados() {
        return vehiculosAsignados;
    }

    public void setVehiculosAsignados(Vehiculo vehiculosAsignados) {
        this.vehiculosAsignados = vehiculosAsignados;
    }

    @Override
    public String toString() {
        return "Mision{" +
                "fecha=" + fecha +
                ", ubicacion='" + ubicacion + '\'' +
                ", personalAsignado='" + personal + '\'' +
                ", vehiculosAsignados=" + vehiculosAsignados +
                '}';
    }
}
