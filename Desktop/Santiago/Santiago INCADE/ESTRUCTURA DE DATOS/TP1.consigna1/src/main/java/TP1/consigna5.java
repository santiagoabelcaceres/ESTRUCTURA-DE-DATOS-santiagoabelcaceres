package TP1;

import java.util.Scanner;

public class consigna5 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int dni;
        char servicio;
        double monto;
        double totalPagar = 0;

        int[] dnis = new int[5];
        char[] servicios = new char[5];
        double[] montos = new double[5];

        for (int i = 0; i < 5; i++) {

            System.out.println();
            System.out.println("===== CLIENTE " + (i + 1) + " =====");

            System.out.println("Ingrese el DNI del cliente: ");
            String datoDni = teclado.nextLine();

            while (!datoDni.matches("-?[0-9]+")) {
                System.out.println("DNI no valido, intente de nuevo.");
                datoDni = teclado.nextLine();
            }

            dni = Integer.parseInt(datoDni);

            while (dni < 0) {
                System.out.println("DNI no valido.");
                System.out.println("Ingrese nuevamente el DNI del cliente: ");
                datoDni = teclado.nextLine();

                while (!datoDni.matches("-?[0-9]+")) {
                    System.out.println("DNI no valido, intente de nuevo.");
                    datoDni = teclado.nextLine();
                }

                dni = Integer.parseInt(datoDni);
            }

            System.out.println("Seleccione el tipo de servicio:");
            System.out.println("A. Internet 30 megas - $750");
            System.out.println("B. Internet 50 megas - $1100");
            System.out.println("C. Internet 100 megas - $1500");

            System.out.print("Ingrese la letra del servicio: ");
            servicio = teclado.nextLine().charAt(0);

            while (servicio != 'A' && servicio != 'a' &&
                   servicio != 'B' && servicio != 'b' &&
                   servicio != 'C' && servicio != 'c') {

                System.out.println("Opcion no aceptada, intente de nuevo.");
                System.out.print("Ingrese la letra del servicio: ");
                servicio = teclado.nextLine().charAt(0);
            }

            if (servicio == 'A' || servicio == 'a') {
                monto = 750;

            } else if (servicio == 'B' || servicio == 'b') {
                monto = 1100;

            } else {
                System.out.println("Actualmente cuenta con un 5% de descuento por promocion.");
                monto = 1500 - (1500 * 0.05);
            }

            dnis[i] = dni;
            servicios[i] = servicio;
            montos[i] = monto;

            totalPagar = totalPagar + monto;
        }

        System.out.println("Enter para ver el total a pagar: ");
        teclado.nextLine();

        System.out.println();
        System.out.println("===== RESUMEN DE CLIENTES =====");

        for (int i = 0; i < 5; i++) {

            System.out.println();
            System.out.println("DNI: " + dnis[i]);
            System.out.println("Servicio: " + servicios[i]);
            System.out.printf("Debe abonar: $%.2f%n", montos[i]);
        }

        System.out.println();
        System.out.printf("TOTAL A PAGAR: $%.2f%n", totalPagar);

        teclado.close();
    }
}