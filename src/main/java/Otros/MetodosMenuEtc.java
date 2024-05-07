package Otros;

import java.util.*;

public class MetodosMenuEtc {
    static Scanner sc = new Scanner(System.in);

    static void menu() {
        boolean exceptionControl = false;
        boolean exitProgram = false;
        // menu controlado por un bucle do while y capturando excepciones para que el
        // usuario ingrese un numero
        do {
            int opcion;
            System.out.println("********MENU*********");
            System.out.println("1. Crear un aula con algunos alumnos.");
            System.out.println("2. LLamar al metodo escribirAlumnos.");
            System.out.println("3. Llamar al metodo leerAlumnos sobre el fichero escrito.");
            System.out.println("0. Ingresa 0 si deseas salir.");
            try {
                opcion = sc.nextInt();
                exceptionControl = true;
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        System.out.println("Saliendo del programa");
                        System.out.println("Muchas Gracias!");
                        exitProgram = true;
                        break;
                    default:
                        exitProgram = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un numero por favor!\n");
                sc.nextLine();
            }
        } while (!exceptionControl || !exitProgram);


    }
}
