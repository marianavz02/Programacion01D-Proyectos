import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        // ingresar nombres y mostrar numbres invertidos - punto 1
        InvertirNombres invertirNombres = new InvertirNombres();
        invertirNombres.ingresarNombres();
        invertirNombres.mostrarNombresInverso();


        //Mayor numero - Punto 2
        Scanner scanner = new Scanner(System.in);
        MayorNumero mayorNumero = new MayorNumero(scanner);
        mayorNumero.determinarMayor();
        scanner.close();


        //Tabla de multiplicar - punto 3
        TablaMultiplicar tabla = new TablaMultiplicar();
        tabla.mostrarTabla();


        //Numero que mas se repite - punto 4
        int[] numeros = {3, 1, 4, 2, 3, 5, 3, 2, 1, 4, 3}; // Lista de números
        int masRepetido = NumeroMasRepetido.encontrarMasRepetido(numeros);
        System.out.println("El número que más se repite es: " + masRepetido);

        //Ordenar numeros - punto 5
        int[] numeros1 = {8, 3, 1, 6, 4}; // Ya definidos

        OrdenarNumeros.ordenarAscendente(numeros1);

        for (int num : numeros1) {
            System.out.print(num + " ");
        }

    }

}



