package com.juanpaabloalvis.projector.infraestructure.persistence.config;

import com.juanpaabloalvis.projector.application.ports.out.ProjectOutPort;
import com.juanpaabloalvis.projector.application.ports.out.UnitOutPort;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.JdbcProjectRepository;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.JdbcUnitRepository;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.MongoProjectRepository;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.MongoUnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.ConfigurationException;

@Slf4j
@Configuration
@RequiredArgsConstructor

public class PersistenceConfig {

    private final JdbcUnitRepository unitJdbcRepository;
    private final MongoUnitRepository unitMongoRepository;

    private final JdbcProjectRepository jdbcProjectDb;
    private final MongoProjectRepository mongoProjectDb;

    @Bean("projectDatabaseConfig")
    public ProjectOutPort getProjectDatabase(@Value("${database.mode}") String databaseMode) throws ConfigurationException {
        log.info("Starting [{}] DB configuration", databaseMode);
        if ("h2".equals(databaseMode)) {
            return jdbcProjectDb;
        } else if ("mongo".equals(databaseMode)) {
            return mongoProjectDb;
        }
        throw new ConfigurationException("invalid value for 'database.mode': " + databaseMode);
    }

    @Bean("unitDatabaseConfig")
    public UnitOutPort getUnitDatabase(@Value("${database.mode}") String databaseMode) throws ConfigurationException {
        log.info("Starting [{}] DB configuration", databaseMode);
        if ("h2".equals(databaseMode)) {
            return unitJdbcRepository;
        } else if ("mongo".equals(databaseMode)) {
            return unitMongoRepository;
        }
        throw new ConfigurationException("invalid value for 'database.mode': " + databaseMode);
    }
}
