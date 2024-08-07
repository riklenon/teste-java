package com.infuse.rikteste;

import com.infuse.rikteste.model.Cliente;
import com.infuse.rikteste.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Bean
    public CommandLineRunner initializeData(ClienteRepository clienteRepository) {
        return args -> {
            if (clienteRepository.count() == 0) {
                Cliente cliente1 = new Cliente();
                cliente1.setNome("Cliente 1");
                clienteRepository.save(cliente1);
                logger.info("Cliente 1 salvo");

                Cliente cliente2 = new Cliente();
                cliente2.setNome("Cliente 2");
                clienteRepository.save(cliente2);
                logger.info("Cliente 2 salvo");

                Cliente cliente3 = new Cliente();
                cliente3.setNome("Cliente 3");
                clienteRepository.save(cliente3);
                logger.info("Cliente 3 salvo");
            } else {
                logger.info("Clientes já existem");
            }
        };
    }
}
