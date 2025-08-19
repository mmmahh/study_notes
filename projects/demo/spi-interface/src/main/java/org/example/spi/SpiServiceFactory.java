package org.example.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiServiceFactory {

    public static SpiService getSpiService() {
        ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            return iterator.next();
        }
        throw new RuntimeException("No SpiService found");
    }
}
