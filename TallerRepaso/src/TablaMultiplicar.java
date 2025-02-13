import java.util.Scanner;

public class TablaMultiplicar {

    public void mostrarTabla() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número para generar su tabla de multiplicar: ");

        if (scanner.hasNextInt()) {
            int numero = scanner.nextInt();
            System.out.println("Tabla de multiplicar del " + numero + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }
        } else {
            System.out.println("Error: Debe ingresar un número entero.");
        }
        scanner.close();
    }
}
