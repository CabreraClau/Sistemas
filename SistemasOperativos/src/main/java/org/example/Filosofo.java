package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;
public class Filosofo implements Runnable {
    private int id;
    private Semaphore izquierdo, derecho;
    private volatile boolean detener = false;

    public Filosofo(int id, Semaphore izquierdo, Semaphore derecho) {
        this.id = id;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    @Override
    public void run() {
        try {
            while (!detener) {
                pensar();
                tomarPalillos();
                comer();
                dejarPalillos();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep(1000);
    }

    private void tomarPalillos() throws InterruptedException {
        System.out.println("Filósofo " + id + " está intentando tomar los palillos.");
        izquierdo.acquire();
        derecho.acquire();
        System.out.println("Filósofo " + id + " tiene ambos palillos.");
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comiendo.");
        Thread.sleep(1000);
    }

    private void dejarPalillos() {
        izquierdo.release();
        derecho.release();
        System.out.println("Filósofo " + id + " ha dejado los palillos.");
    }

    public void detener() {
        detener = true;
    }
}
