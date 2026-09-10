package TP1;

import java.util.Scanner;

public class consigna6 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int[] numerosVehiculo = new int[12];
        double[] tiempos = new double[12];


        for (int i = 0; i < 12; i++) {
            System.out.println("=== PARTICIPANTE " + (i + 1) + " ===");
            System.out.print("Ingrese el numero de vehiculo: ");
            numerosVehiculo[i] = teclado.nextInt();

            System.out.print("Ingrese el tiempo en segundos: ");
            tiempos[i] = teclado.nextDouble();
            System.out.println();
        }

        double time = tiempos[0];
        int vehiculoGanador = numerosVehiculo[0];

        for (int i = 1; i < 12; i++) {
            if (tiempos[i] < time) {
                time = tiempos[i];
                vehiculoGanador = numerosVehiculo[i];
            }
        }

        System.out.println("===== MEJOR TIEMPO REGISTRADO =====");
        System.out.println("Numero de vehiculo: " + vehiculoGanador);
        System.out.println("Tiempo obtenido: " + time + " segundos");
        
       System.out.println("\nPresione ENTER para cerrar el programa...");
        teclado.nextLine();

        teclado.close();
    }
}