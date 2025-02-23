
public class Empleado {
    private String id;
    private String nombreCompleto;
    private String puesto;
    private String correo;
    private String telefono;
    private String fechaContratacion;

    public Empleado(String id, String nombreCompleto, String fechaContratacion,
                    String puesto, String correo,
                    String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.fechaContratacion = fechaContratacion;
        this.puesto = puesto;
        this.correo = correo;
        this.telefono = telefono;
    }

    //GETTERS
    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }


    //SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }




    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", puesto='" + puesto + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                '}';
    }
}
