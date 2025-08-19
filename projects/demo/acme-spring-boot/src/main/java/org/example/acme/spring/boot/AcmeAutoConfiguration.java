package org.example.acme.spring.boot;

import org.example.acme.AcmeService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({AcmeService.class})
public class AcmeAutoConfiguration {
}
