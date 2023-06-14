package com.juanpaabloalvis.projector.infraestructure.persistence.config;

import com.juanpaabloalvis.projector.application.ports.out.ProjectOutPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.ConfigurationException;

@Slf4j
@Configuration
public class PersistenceConfig {

    private final ProjectOutPort mongoProjectDb;
    private final ProjectOutPort jdbcProjectDb;

    public PersistenceConfig(@Qualifier("mongodbProjectService") ProjectOutPort mongoProjectDb, @Qualifier("jdbcProjectService") ProjectOutPort jdbcProjectDb) {
        this.mongoProjectDb = mongoProjectDb;
        this.jdbcProjectDb = jdbcProjectDb;
    }


    @Bean("projectDatabase")
    ProjectOutPort getProjectDatabase(@Value("${database.mode}") String databaseMode) throws ConfigurationException {
        log.info("Starting [{}] DB configuration", databaseMode);
        if ("h2".equals(databaseMode)) {
            return jdbcProjectDb;
        } else if ("mongo".equals(databaseMode)) {
            log.info("Starting mongodb Configuration");
            return mongoProjectDb;
        }
        throw new ConfigurationException("invalid value for 'database.mode': " + databaseMode);

    }
}
