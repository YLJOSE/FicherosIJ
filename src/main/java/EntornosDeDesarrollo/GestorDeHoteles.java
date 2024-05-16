package EntornosDeDesarrollo;

import java.util.*;


public class GestorDeHoteles {
    static Scanner sc = new Scanner(System.in);
    static boolean exceptionControl = false;
    static boolean exitProgram = false;

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Administrador> administradores = new ArrayList<>();
        createObject(clientes, administradores);
        loginUser(clientes, administradores);
    }

    static void loginUser(ArrayList<Cliente> clientes, ArrayList<Administrador> administradores) {
        boolean logeoCorrecto = false;
        String user;
        int password;
        do {
            System.out.println("Ingresa el usuario:");
            user = sc.nextLine();
            System.out.println("Ingresa la contraseña:");
            password = sc.nextInt();

            for (Cliente cliente : clientes) {
                if (cliente.getNumCliente() == password && cliente.getNombre().equalsIgnoreCase(user)) {
                    System.out.println("Hola: " + cliente.getNombre() + "\n");
                    menuCliente();
                    logeoCorrecto = true;
                }
            }
            for (Administrador administradore : administradores) {
                if (administradore.getUser().equalsIgnoreCase(user) && administradore.getPassword() == password) {
                    System.out.println("Hola: " + administradore.getUser() + "\n");
                    menuAdmi();
                    logeoCorrecto = true;
                }
            }
            sc.nextLine();
        } while (!logeoCorrecto);
    }

    static void menuAdmi() {
        // menu controlado por un bucle do while y capturando excepciones para que el
        // usuario ingrese un numero
        do {
            int opcion;
            System.out.println("********MENU*********");
            System.out.println("1. Visualizar reserva sin factura.");
            System.out.println("2. Visualizar reserva sin factura que facturen hoy.");
            System.out.println("0. Ingresa 0 si deseas salir.");
            try {
                opcion = sc.nextInt();
                exceptionControl = true;
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        // llamar metodo
                        break;
                    case 2:
                        // llamar metodo
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

    static void menuCliente() {
        // menu controlado por un bucle do while y capturando excepciones para que el
        // usuario ingrese un numero
        do {
            int opcion;
            System.out.println("********MENU*********");
            System.out.println("1. Visualizar todas las reservas que realizó.");
            System.out.println("2. Solicitar reserva con fechas determinadas.");
            System.out.println("0. Ingresa 0 si deseas salir.");
            try {
                opcion = sc.nextInt();
                exceptionControl = true;
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        //llamar metodo
                        break;
                    case 2:
                        // llamar metodo
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

    static void createObject(ArrayList<Cliente> clientes, ArrayList<Administrador> administradores) {
        Cliente c1 = new Cliente(123456789, "pedro", 999996845);
        Cliente c2 = new Cliente(998877755, "carlos", 897512474);
        Administrador a1 = new Administrador("12313254dsr", 54554544);
        Administrador a2 = new Administrador("54asd4", 545564654);
        clientes.add(c1);
        clientes.add(c2);
        administradores.add(a1);
        administradores.add(a2);
    }
}
