import java.util.Arrays;

public class Grupo {

    private String nombreGrupo;
    private Categoria categoria;
    private Contacto[] listaContactosGrupo;


    public Grupo(String nombreGrupo, Categoria categoria) {
        this.nombreGrupo = nombreGrupo;
        this.categoria = categoria;
        listaContactosGrupo = new Contacto[5];
    }


    //GETTERS Y SETTTERS

    //NOMBRE GRUPO
    public String getNombreGrupo() {
        return nombreGrupo;
    }
    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }


    //CATEGORIA ENUM
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //ENUM categoria: OFICINA, FIESTA, AMIGOS, FAMILIA;


    //LISTA CONTACTOS
    public Contacto[] getListaContactosGrupo() {
        return listaContactosGrupo;
    }
    public void setListaContactosGrupo(Contacto[] listaContactosGrupo) {
        this.listaContactosGrupo = listaContactosGrupo;
    }


    // TO STRING
    @Override
    public String toString() {
        return "Grupo{" +
                "nombreGrupo='" + nombreGrupo + '\'' +
                ", categoria=" + categoria +
                ", listaContactos=" + Arrays.toString(listaContactosGrupo) +
                '}';
    }
}
