
    import javax.swing.*;
    import java.util.LinkedList;

public class Guarderia {

    int cantEstudiantes = 4;
    private String nombre;
    private String nit;
    Estudiante []listEstudiantes;


    public Guarderia(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;

        listEstudiantes = new Estudiante[n];
    }



    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "Guarderia{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\''+
                '}';
    }

    //METODOS DE LA CLASE USANDO ARREGLOS


    //Metodo para obtener la ultiima posicion en el arreglo listEstudiantes

    public int obtenerUltimaPosicionLibre() {
        for (int i = 0; i < listEstudiantes.length; i++) {
            if (listEstudiantes[i] == null) {
                return i;       // Retorna el primer índice disponible
            }
        }
        return -1;              // Indica que no hay espacio disponible
    }





    public boolean agregarEstudiante(Estudiante nuevoEstudiante) {
        boolean flag = true;
        for (int i = 0; i < listEstudiantes.length; i++) {
            if (listEstudiantes[i].getId().equals(nuevoEstudiante.getId())){
                flag = false;
            }
        }
        int index = obtenerUltimaPosicionLibre (i);

        if (flag) {
            listEstudiantes [index] = nuevoEstudiante;
        }
        return flag;
    }




    public boolean actualizarEstudiante (Estudiante updateEstudiante, String id) {
        int posicion = -1;
        for (int i = 0; i < listEstudiantes.length; i++) {
            if (listEstudiantes[i].equals(id)) {
                posicion = i;
            }
        }
        if (posicion != -1) {
            listEstudiantes[posicion] = updateEstudiante;
        }
        return true;
    }



    public boolean eliminarEstudiante(Estudiante deleteEstudiante, String id) {
        int posicion = -1;
        for (int i = 0; i < listEstudiantes.length; i++) {
            if (listEstudiantes[i].equals(id)) {
                posicion = i;
                break;
            }
        }
        if (posicion != -1) {
            listEstudiantes[posicion] = null;
            return true;
        }
        return false;
    }


}

