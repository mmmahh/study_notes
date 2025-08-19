package org.example.spi.client;

import org.example.spi.SpiService;
import org.example.spi.SpiServiceFactory;

public class SpiClient {

    public static void main(String[] args) {
        SpiService spiService = SpiServiceFactory.getSpiService();
        spiService.doSomething();

        Class<? super SpiService> superclass = SpiService.class.getSuperclass();
        System.out.println();
    }
}
