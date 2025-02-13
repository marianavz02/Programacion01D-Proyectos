
import java.util.Scanner;
import java.util.LinkedList;

public class InvertirNombres{

    // 1. InvertirNombres
    private LinkedList<String> nombres;

    public InvertirNombres() {
        nombres = new LinkedList<>();
    }

    public void ingresarNombres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese 5 nombres:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            nombres.addFirst(scanner.nextLine()); // Agregar al inicio para invertir el orden
        }
        scanner.close();
    }

    public void mostrarNombresInverso() {
        System.out.println("\nNombres en orden inverso:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public LinkedList<String> getNombres() {
        return nombres;
    }
}

