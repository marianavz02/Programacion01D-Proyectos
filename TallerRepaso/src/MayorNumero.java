
import java.util.Scanner;

public class MayorNumero {
    private int num1;
    private int num2;
    private int num3;

    public MayorNumero(Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        this.num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        this.num2 = scanner.nextInt();
        System.out.print("Ingrese el tercer número: ");
        this.num3 = scanner.nextInt();
    }

    public void determinarMayor() {
        if (num1 == num2 && num2 == num3) {
            System.out.println("Los tres números son iguales: " + num1);
        } else {
            int mayor = Math.max(num1, Math.max(num2, num3));
            System.out.println("El número mayor es: " + mayor);
        }
    }
}



