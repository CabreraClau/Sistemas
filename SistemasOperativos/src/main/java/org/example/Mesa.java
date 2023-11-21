package org.example;

import java.util.concurrent.Semaphore;

public class Mesa {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Semaphore[] palillos = new Semaphore[numFilosofos];
        Filosofo[] filosofos = new Filosofo[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            palillos[i] = new Semaphore(1);
        }

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(i, palillos[i], palillos[(i + 1) % numFilosofos]);
            new Thread(filosofos[i]).start();
        }

        // Esperar un tiempo para que los filósofos tengan la oportunidad de comer y mostrar el estado
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Detener a los filósofos
        for (Filosofo filosofo : filosofos) {
            filosofo.detener();
        }
    }
}