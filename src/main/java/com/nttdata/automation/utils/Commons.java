package com.nttdata.automation.utils;

public class Commons {

    public static void wait5seconds() throws InterruptedException {
        Thread.sleep(5000);
    }

    /**
     * Pausa la ejecución del hilo actual durante el número de segundos indicado.
     *
     * @param seconds número de segundos que se desea esperar.
     * @throws RuntimeException si el hilo es interrumpido mientras está en espera.
     */
    public static void waitNseconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
