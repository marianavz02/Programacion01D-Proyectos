
    import javax.swing.*;
    import java.util.LinkedList;

public class Guarderia {

    int cantEstudiantes = 4;
    private String nombre;
    private String nit;
    private LinkedList<Estudiante> estudiantes;



    public Guarderia(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        estudiantes = new LinkedList<>();
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
                ", nit='" + nit + '\'' +
                ", estudiantes=" + estudiantes +
                '}';
    }




    //METODOS DE LA CLASE



    //CREAR Y AGREGAR UN ESTUDIANTE A LA GUARDERIA
    public void agregarEstudiante() {

        int id;
        boolean idRepetido;

        do {
            idRepetido = false;
            id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante (Solo números)"));

            for (Estudiante e : estudiantes) {
                if (e.getId() == id) {
                    idRepetido = true;
                    JOptionPane.showMessageDialog(null, "El ID ingresado ya existe. Por favor, ingrese otro.");
                    break;
                }
            }
        } while (idRepetido);
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad (solo numeros)"));
            String genero = JOptionPane.showInputDialog("Ingrese el genero");
            String alergias = JOptionPane.showInputDialog("Ingrese alergias del estudiante");
            String nombreAcudiente = JOptionPane.showInputDialog("Ingrese el nombre acudiente");
            String numeroContacto = JOptionPane.showInputDialog("Ingrese el numero contacto");


            Estudiante newEstudiante = new Estudiante(id, nombre, edad, genero, alergias, nombreAcudiente, numeroContacto);

            JOptionPane.showMessageDialog(null, newEstudiante);
            estudiantes.add(newEstudiante);


    }






    public void eliminarEstudiante() {
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante a eliminar (Solo numeros)"));

        Estudiante estudianteEncontrado = null;
        for (Estudiante e : estudiantes) {
            if (e.getId() == idEliminar) {
                estudianteEncontrado = e;
                break;
            }
        }

        if (estudianteEncontrado != null) {
            estudiantes.remove(estudianteEncontrado);
            JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }





    //ACTUALIZAR UN ESTUDIANTE
    public void actualizarEstudiante() {
        int idEstudiante = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante a actualizar (Solo numeros)"));

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == idEstudiante) {
                // Pide los nuevos datos al usuario
                estudiante.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre", estudiante.getNombre()));
                estudiante.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad", estudiante.getEdad())));
                estudiante.setAlergias(JOptionPane.showInputDialog("Ingrese las nuevas alergias", estudiante.getAlergias()));
                estudiante.setGenero(JOptionPane.showInputDialog("Ingrese el nuevo género", estudiante.getGenero()));
                estudiante.setNombreAcudiente(JOptionPane.showInputDialog("Ingrese el nombre del acudiente", estudiante.getNombreAcudiente()));
                estudiante.setNumeroContacto(JOptionPane.showInputDialog("Ingrese el número de contacto", estudiante.getNumeroContacto()));

                JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un estudiante con ese ID.");
    }





    //MOSTRAR TOTAL ESTUDIANTES
    public void mostrarEstudiantes(){
        String mensaje = "Estudiantes: \n" +estudiantes+"\n";

        JOptionPane.showMessageDialog(null, mensaje);
    }







    //MOSTRAR ESTUDIANTES MAYORES A 5 AÑOS
    public void mostrarEstudiantesMayores(){
        String mensaje = "Estudiantes mayores a 5 años \n";
        for (Estudiante estudiante : estudiantes){
            if (estudiante.getEdad() > 5){
                mensaje += estudiante.getNombre()+" ";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }






    //MENU
    public void menu() {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog("Seleccione una opción:\n1. Registrar estudiante\n2. Mostrar Niños mayores de 5 años\n3. Eliminar estudiante\n4. Actualizar estudiante\n5. Mostrar total estudiantes \n6. Salir");

            switch (opcion) {
                case "1":
                    agregarEstudiante();
                    break;
                case "2":
                    mostrarEstudiantesMayores();
                    break;
                case "3":
                    eliminarEstudiante();
                    break;
                case "4":
                    actualizarEstudiante();
                    break;
                case "5":
                    mostrarEstudiantes();
                    break;
                case "6":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}

