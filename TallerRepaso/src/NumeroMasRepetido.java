public class NumeroMasRepetido {
    public static int encontrarMasRepetido(int[] numeros) {
        int maxRepeticiones = 0;
        int numeroMasRepetido = numeros[0];

        for (int i = 0; i < numeros.length; i++) {
            int contador = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    contador++;
                }
            }
            if (contador > maxRepeticiones) {
                maxRepeticiones = contador;
                numeroMasRepetido = numeros[i];
            }
        }

        return numeroMasRepetido;
    }
}
