public class Contacto {
    private String nombre;
    private String alias;
    private String telefono;
    private String email;
    private String direccion;

    public Contacto(String nombre, String alias,
                    String telefono, String email, String direccion) {
        this.nombre=nombre;
        this.alias=alias;
        this.telefono=telefono;
        this.email=email;
        this.direccion=direccion;
    }

    //GETTERS Y SETTERS

    //Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre){
        this.nombre=nombre;
    }



    //Alias
    public String getAlias() {
        return alias;
    }

    public void setAlias (String alias){
        this.alias=alias;
    }



    //Telefono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono (String telefono) {
        this.telefono=telefono;
    }



    //Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }



    //Direccion
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }




    //toString
    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", alias='" + alias + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

