package TP1;

import java.util.Scanner;

public class TP1Consigna2 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int cant;
        int aprobados = 0;
        int desaprobados = 0;

        System.out.print("¿Cuántos alumnos hay? ");
        cant = teclado.nextInt();

        double[] notas = new double[cant];

        for (int i = 0; i < cant; i++) {
            System.out.print("Ingrese la nota del alumno " + (i + 1) + ": ");
            notas[i] = teclado.nextDouble();

            if (notas[i] >= 6) {
                aprobados++;
            } else {
                desaprobados++;
            }
        }

        System.out.println("Cantidad de aprobados: " + aprobados);
        System.out.println("Cantidad de desaprobados: " + desaprobados);
    }
}