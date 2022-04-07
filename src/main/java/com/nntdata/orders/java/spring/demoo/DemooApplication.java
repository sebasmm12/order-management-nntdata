package com.nntdata.orders.java.spring.demoo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemooApplication {
    
/* Se injecto el uso del ModelMapper para la conversión de un objeto a otro objecto */    
@Bean
public ModelMapper modellMapper() {
    return new ModelMapper();
}
    
public static void main(String[] args) {
        SpringApplication.run(DemooApplication.class, args);
}

}
