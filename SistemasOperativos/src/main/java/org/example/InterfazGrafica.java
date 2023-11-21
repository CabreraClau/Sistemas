/*package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;

class InterfazGrafica extends JFrame {
    private JLabel[] filosofosLabels = new JLabel[5];

    public InterfazGrafica() {
        setTitle("Problema de los Filósofos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 5));

        for (int i = 0; i < 5; i++) {
            filosofosLabels[i] = new JLabel("", SwingConstants.CENTER);
            add(filosofosLabels[i]);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actualizarEstado(int filosofoId, boolean izquierdo, boolean derecho) {
        filosofosLabels[filosofoId].setText("F" + filosofoId +
                (izquierdo ? " P" : "") +
                (derecho ? " P" : ""));
    }
}

 */
