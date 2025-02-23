import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        int cantEstudiantes = 4;

        //CREAR GUARDERIA
        Guarderia guarderia = new Guarderia("Guarderia el Sol", "12345678");


        for (int i = 0; i < cantEstudiantes; i++) {

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el edad"));
            String genero = JOptionPane.showInputDialog("Ingrese el genero");
            int identificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificacion"));
            String alergias = JOptionPane.showInputDialog("Ingrese el alergias");
            String nombreAcudiente = JOptionPane.showInputDialog("Ingrese el nombre acudiente");
            String numeroContacto = JOptionPane.showInputDialog("Ingrese el numero contacto");


            Estudiante newEstudiante =
                    new Estudiante(nombre, edad, genero, identificacion, alergias, nombreAcudiente, numeroContacto);

            JOptionPane.showMessageDialog(null, newEstudiante);
            guarderia.agregarEstudiante(newEstudiante);
        }




        //CREAR ESTUDIANTES
        Estudiante estudiante1 = new Estudiante("Lina", 2, "Femenino", 109488997, "No alergias", "Diana", "31234567");
        Estudiante estudiante2 = new Estudiante ("Sofia", 2, "Femenino", 1095672625, "No alergias", "Luisa", "315227388");
        Estudiante estudiante3 = new Estudiante("Juan", 3, "Masculino", 109388766, "No alergias", "Carla", "3167789286");


        //AGREGAR ESTUDIANTES A LA GUARDERIA
        guarderia.agregarEstudiante(estudiante1);
        guarderia.agregarEstudiante(estudiante2);
        guarderia.agregarEstudiante(estudiante3);



        //ELIMINAR EMPLEADO
        guarderia.eliminarEstudiante(estudiante1);


        //MOSTRAR MENSAJE
        guarderia.mostrarMensaje(guarderia.toString());

    }
}