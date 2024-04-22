package Otros;

public class Figuras {
    public static void main(String[] args) {

        int i, j, k;// i número de capa j espacio k asterisco

        for (i = 0; i < 2; i++) {
            // Controla la impresión de asteriscos a la izquierda
            for (j = 0; j <= 2 - i; j++) {
                System.out.print(" ");
            }
            for (k = 0; k < 2 * i + 4; k++) {
                System.out.print("*");
            }

            // Controla la impresión de asteriscos a la derecha
            for (j = 4; j > 2 * i; j--) {
                System.out.print(" ");
            }
            for (k = 0; k < 2 * i + 4; k++) {
                System.out.print("*");
            }
            // Realizar salto de línea
            System.out.println();
        }
        // La parte inferior es un triángulo invertido
        for (i = 0; i < 8; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (k = 0; k < 16 - i * 2; k++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}