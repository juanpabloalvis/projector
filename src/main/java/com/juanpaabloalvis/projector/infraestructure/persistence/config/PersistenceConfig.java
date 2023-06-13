package com.juanpaabloalvis.projector.infraestructure.persistence.config;

import com.juanpaabloalvis.projector.application.ports.out.CreateProjectOutPort;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.JdbcRepository;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.respository.ProjectRepository;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.MongoRepository;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository.ProjectMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.ConfigurationException;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class PersistenceConfig {
    private final ProjectRepository projectRepository;
    private final ProjectMongoRepository mongoRepository;


    @Bean
    CreateProjectOutPort getDatabase(@Value("${database.mode:h2}") String databaseMode) throws ConfigurationException {
        if ("h2".equals(databaseMode)) {
            log.info("Starting h2 Configuration");
            return new MongoRepository(mongoRepository);
        } else if ("mongo".equals(databaseMode)) {
            log.info("Starting mongodb Configuration");
            return new JdbcRepository(projectRepository);
        }
        throw new ConfigurationException("invalid value for 'database.mode': " + databaseMode);

    }
}
