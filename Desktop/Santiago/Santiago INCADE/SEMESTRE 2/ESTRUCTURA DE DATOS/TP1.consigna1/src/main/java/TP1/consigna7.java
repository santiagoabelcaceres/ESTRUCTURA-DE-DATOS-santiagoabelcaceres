package TP1;

import java.util.Scanner;

public class consigna7 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int DNI;
        int edad;
        char sexo;

        int totalPersonas = 0;
        int cantidadVarones = 0;
        int cantidadMujeres = 0;
        int varones16a65 = 0;

        int mayorEdad = -1;
        int dniMayorEdad = 0;
        char sexoMayorEdad = ' ';

        System.out.print("Ingrese DNI (0 para finalizar): ");
        DNI = teclado.nextInt();

        while (DNI != 0) {

            System.out.print("Ingrese edad: ");
            edad = teclado.nextInt();

            System.out.print("Ingrese sexo (F/M): ");
            sexo = teclado.next().charAt(0);

            totalPersonas++;

            if (sexo == 'M' || sexo == 'm') {

                cantidadVarones++;

                if (edad >= 16 && edad <= 65) {
                    varones16a65++;
                }

            } else if (sexo == 'F' || sexo == 'f') {

                cantidadMujeres++;
            }

            if (edad > mayorEdad) {

                mayorEdad = edad;
                dniMayorEdad = DNI;
                sexoMayorEdad = sexo;
            }

            System.out.print("\nIngrese DNI (0 para finalizar): ");
            DNI = teclado.nextInt();
        }

        double porcentajeVarones16a65 = 0;

        if (cantidadVarones > 0) {
            porcentajeVarones16a65 =
                    (varones16a65 * 100.0) / cantidadVarones;
        }

        System.out.println("\n========== RESULTADOS ==========");

        System.out.println("Cantidad total de personas censadas: " + totalPersonas);
        System.out.println("Cantidad de varones: " + cantidadVarones);
        System.out.println("Cantidad de mujeres: " + cantidadMujeres);

        System.out.println(
                "Porcentaje de varones de 16 a 65 años: "
                + porcentajeVarones16a65 + "%"
        );

        if (totalPersonas > 0) {
            System.out.println("\nPersona de mayor edad:");
            System.out.println("DNI: " + dniMayorEdad);
            System.out.println("Edad: " + mayorEdad);
            System.out.println("Sexo: " + sexoMayorEdad);
        }

        teclado.close();
    }
}