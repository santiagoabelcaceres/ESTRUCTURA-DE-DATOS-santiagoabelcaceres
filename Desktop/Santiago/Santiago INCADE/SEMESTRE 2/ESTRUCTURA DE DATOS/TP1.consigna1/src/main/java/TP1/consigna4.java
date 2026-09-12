package TP1;

import java.util.Scanner;

public class consigna4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String[] patentes = new String[10];
        String[] nombres = new String[10];
        String[] cargas = new String[10];

        String patente;
        String nombre;
        String carga;

        int cantRegistros = 0;
        int cantTe = 0;

        char opcion;

        do {

            System.out.println();
            System.out.println("===== CONTROL DE CAMIONES =====");
            System.out.println("1. Ingresar registro (R):");
            System.out.println("2. Cerrar programa (C):");
            opcion = teclado.next().charAt(0);
            teclado.nextLine();

            if (opcion == 'r' || opcion == 'R') {

                if (cantRegistros < 10) {

                    System.out.println();
                    System.out.println("PATENTE DEL CAMION:");
                    patente = teclado.nextLine().toUpperCase();

                    while (!patente.matches("[0-9]{3}[A-Z]{3}") &&
                           !patente.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {

                        System.out.println("Formato de patente incorrecto.");
                        System.out.println("Ejemplos aceptado: 555NNN o NN555NN");
                        System.out.print("Ingrese nuevamente la patente: ");
                        patente = teclado.nextLine().toUpperCase();
                    }

                    System.out.print("Nombre y apellido del chofer: ");
                    nombre = teclado.nextLine();

                    System.out.println("Seleccione el tipo de carga:");
                    System.out.println("a. Madera");
                    System.out.println("b. Yerba");
                    System.out.println("c. Té");
                    char opcionCarga = teclado.next().charAt(0);
                    teclado.nextLine();

                    while (opcionCarga != 'a' && opcionCarga != 'A' &&
                           opcionCarga != 'b' && opcionCarga != 'B' &&
                           opcionCarga != 'c' && opcionCarga != 'C') {

                        System.out.print("Valor incorrecto. Seleccione a, b o c: ");
                        opcionCarga = teclado.next().charAt(0);
                        teclado.nextLine();
                    }

                    if (opcionCarga == 'a' || opcionCarga == 'A') {
                        carga = "madera";
                    } else if (opcionCarga == 'b' || opcionCarga == 'B') {
                        carga = "yerba";
                    } else {
                        carga = "té";
                    }

                    patentes[cantRegistros] = patente;
                    nombres[cantRegistros] = nombre;
                    cargas[cantRegistros] = carga;

                    if (carga.equals("té")) {
                        cantTe++;
                    }

                    cantRegistros++;

                    System.out.println();
                    System.out.println("Registro realizado correctamente.");

                    if (cantRegistros == 10) {
                        System.out.println();
                        System.out.println("LIMITE DE REGISTROS ALCANZADO.");
                        System.out.println("ENTER para ver los movimientos realizados: ");
                        teclado.nextLine();
                        opcion = 'C';
                    }

                }

            }

            if (opcion == 'c' || opcion == 'C') {

                if (cantRegistros < 10) {
                    System.out.println();
                    System.out.println("ENTER para ver los movimientos realizados: ");
                    teclado.nextLine();
                }

                System.out.println();
                System.out.println("===== MOVIMIENTOS REALIZADOS =====");
                System.out.println("===== EGRESO DE CAMIONES =====");
                for (int i = 0; i < cantRegistros; i++) {

                    System.out.println();
                    System.out.println("Camion " + (i + 1));
                    System.out.println("Patente: " + patentes[i]);
                    System.out.println("Chofer: " + nombres[i]);
                    System.out.println("Carga: " + cargas[i]);
                }

                boolean salioMadera = false;
                boolean salioYerba = false;

                for (int i = 0; i < cantRegistros; i++) {

                    if (cargas[i].equals("madera")) {
                        salioMadera = true;
                    }

                    if (cargas[i].equals("yerba")) {
                        salioYerba = true;
                    }
                }

                System.out.println();
                System.out.println("===== RESUMEN DE MOVIMIENTOS  =====");
                System.out.println("Camiones de madera: " + (salioMadera ? "SI" : "NO"));
                System.out.println("Camiones de yerba: " + (salioYerba ? "SI" : "NO"));

                if (cantTe == 0) {
                    System.out.println("No egresaron camiones de té.");
                } else {
                    System.out.println("Cantidad de camiones de té: " + cantTe);
                }

            } else if (opcion != 'r' && opcion != 'R') {

                System.out.println("Signo incorrecto.");

            }

        } while (opcion != 'c' && opcion != 'C');

        teclado.close();
    }
}