package TP1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tp2cine2 extends JFrame {

    private String[][] nombres = new String[10][10];
    private String[][] telefonos = new String[10][10];
    private JButton[][] botones = new JButton[10][10];
    private int reservasRealizadas = 0;

    public tp2cine2() {
        setTitle("Sistema de Reservas de Cine - Sala 10x10");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                nombres[i][j] = "";
                telefonos[i][j] = "";
            }
        }

        JPanel panelAsientos = new JPanel();
        panelAsientos.setLayout(new GridLayout(10, 10, 5, 5));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                final int fila = i;
                final int asiento = j;

                JButton boton = new JButton("F" + (i + 1) + " A" + (j + 1));
                boton.setBackground(Color.GREEN);
                boton.setFocusable(false);

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gestionarAsiento(fila, asiento);
                    }
                });

                botones[i][j] = boton;
                panelAsientos.add(boton);
            }
        }

        add(panelAsientos, BorderLayout.CENTER);
    }

    private void gestionarAsiento(int fila, int asiento) {
        boolean estaLibre = nombres[fila][asiento].isEmpty();

        if (estaLibre) {
            String[] opciones = {"Reservar", "Cerrar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "Asiento [Fila " + (fila + 1) + ", Asiento " + (asiento + 1) + "] se encuentra DISPONIBLE.",
                    "Gestionar Asiento",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[1]
            );

            if (seleccion == 0) {
                if (reservasRealizadas >= 100) {
                    JOptionPane.showMessageDialog(this, "Capacidad máxima alcanzada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:");
                if (nombre == null || nombre.trim().isEmpty()) return;

                String telefono = JOptionPane.showInputDialog(this, "Ingrese el teléfono del cliente:");
                if (telefono == null || telefono.trim().isEmpty()) return;

                String[] opcionesConfirmacion = {"Sí", "No"};
                int confirmacion = JOptionPane.showOptionDialog(
                        this,
                        "¿Desea confirmar la reserva a nombre de " + nombre + " (Tel: " + telefono + ")?",
                        "Confirmar Reserva",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesConfirmacion,
                        opcionesConfirmacion[0]
                );

                if (confirmacion == 0) {
                    nombres[fila][asiento] = nombre;
                    telefonos[fila][asiento] = telefono;
                    botones[fila][asiento].setBackground(Color.RED);
                    reservasRealizadas++;

                    JOptionPane.showMessageDialog(this, "Reserva efectuada con éxito.");

                    if (reservasRealizadas == 100) {
                        JOptionPane.showMessageDialog(this, "Capacidad máxima alcanzada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        } else {
            String[] opciones = {"Eliminar reserva", "Cerrar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "Asiento [Fila " + (fila + 1) + ", Asiento " + (asiento + 1) + "] RESERVADO por: " 
                            + nombres[fila][asiento] + " (Tel: " + telefonos[fila][asiento] + ")",
                    "Gestionar Asiento",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    opciones,
                    opciones[1]
            );

            if (seleccion == 0) {
                String[] opcionesConfirmacion = {"Sí", "No"};
                int confirmacion = JOptionPane.showOptionDialog(
                        this,
                        "¿Está seguro de que desea cancelar la reserva de " + nombres[fila][asiento] + "?",
                        "Confirmar Cancelación",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesConfirmacion,
                        opcionesConfirmacion[1]
                );

                if (confirmacion == 0) {
                    nombres[fila][asiento] = "";
                    telefonos[fila][asiento] = "";
                    botones[fila][asiento].setBackground(Color.GREEN);
                    reservasRealizadas--;

                    JOptionPane.showMessageDialog(this, "La reserva ha sido cancelada.");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new tp2cine2().setVisible(true);
            }
        });
    }
}
