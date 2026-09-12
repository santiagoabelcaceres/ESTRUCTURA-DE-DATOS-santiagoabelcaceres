package TP1;

import java.util.Scanner;

public class consigna3 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int cant;

        System.out.print("Cantidad de productos a comprar: ");
        cant = teclado.nextInt();

        double[] precios = new double[cant];
        int[] cantidades = new int[cant];

        double costoTotal = 0;
        boolean supera1000 = false;

        for (int i = 0; i < cant; i++) {
            System.out.print("Ingrese el precio del producto " + (i + 1) + ": ");
            precios[i] = teclado.nextDouble();

            System.out.print("Ingrese la cantidad del producto " + (i + 1) + ": ");
            cantidades[i] = teclado.nextInt();
        }

        for (int i = 0; i < cant; i++) {

            double totalProducto = precios[i] * cantidades[i];

            costoTotal = costoTotal + totalProducto;

            if (totalProducto > 1000) {
                supera1000 = true;

                System.out.println("Producto " + (i + 1) + " supera los $1000.");
                System.out.println("Costo total del producto: $" + totalProducto);
            }
        }

        if (supera1000 == false) {
            System.out.println("No hubbo productos que superen los $1000.");
        }

        System.out.printf("Costo total de todos los productos: $%.2f%n", costoTotal);
    }
}