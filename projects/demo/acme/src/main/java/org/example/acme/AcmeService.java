package org.example.acme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AcmeService {

    public void logging() {
        log.info("acme service");
    }
}
