public class Reunion {
    private String descripcion;
    private String fecha;
    private String hora;
    private Contacto[] listaContactosReunion;

    public Reunion (String descripcion, String fecha, String hora, int tamano) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.listaContactosReunion = new Contacto[tamano];
    }



    //GETTERS Y SETTERS
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Contacto[] getListaContactosReunion() {
        return listaContactosReunion;
    }

    public void setListaContactosReunion(Contacto[] listaContactosReunion) {
        this.listaContactosReunion = listaContactosReunion;
    }
}
