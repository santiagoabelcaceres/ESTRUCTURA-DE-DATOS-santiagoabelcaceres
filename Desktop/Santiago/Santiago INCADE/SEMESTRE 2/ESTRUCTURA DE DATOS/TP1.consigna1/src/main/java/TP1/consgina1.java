package TP1;

import java.util.Scanner;

public class consgina1 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int cant;
        double suma = 0;
        double promedio;
        double notaMayor;

        System.out.print("Ingrese la cantidad de notas: ");
        cant = teclado.nextInt();

        double[] notas = new double[cant];

        for (int i = 0; i < cant; i++) {
            System.out.print("Ingrese una nota " + (i + 1) + ": ");
            notas[i] = teclado.nextDouble();

            suma = suma + notas[i];
        }

        notaMayor = notas[0];

        for (int i = 1; i < cant; i++) {
            notaMayor = Math.max(notaMayor, notas[i]);
        }

        promedio = suma / cant;

        System.out.printf("La nota más alta ingresada es: %.2f%n", notaMayor);
        System.out.printf("El promedio es: %.2f%n", promedio);
    }
}