package org.example.spi.impl;

import org.example.spi.SpiService;

public class SpiServiceImpl implements SpiService {

    @Override
    public void doSomething() {
        System.out.println("spi impl doSomething");
    }
}
