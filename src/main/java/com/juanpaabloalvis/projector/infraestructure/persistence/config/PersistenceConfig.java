package com.juanpaabloalvis.projector.infraestructure.persistence.config;

import com.juanpaabloalvis.projector.application.ports.out.CreateProjectOutPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.ConfigurationException;

//@RequiredArgsConstructor
@Slf4j
@Configuration
public class PersistenceConfig {

    @Qualifier("mongodbService")
    private final CreateProjectOutPort mongoDb;
    @Qualifier("jdbcService")
    private final CreateProjectOutPort jdbcDb;

    public PersistenceConfig(@Qualifier("mongodbService") CreateProjectOutPort mongoDb, @Qualifier("jdbcService") CreateProjectOutPort jdbcDb) {
        this.mongoDb = mongoDb;
        this.jdbcDb = jdbcDb;
    }
//    private final ProjectRepository projectRepository;
//    private final ProjectMongoRepository mongoRepository;

//    public PersistenceConfig(ProjectRepository projectRepository, ProjectMongoRepository mongoRepository) {
//        this.projectRepository = projectRepository;
//        this.mongoRepository = mongoRepository;
//    }


    @Bean
    CreateProjectOutPort getDatabase(@Value("${database.mode}") String databaseMode) throws ConfigurationException {
        log.info("Starting [{}] DB configuration", databaseMode);
        if ("h2".equals(databaseMode)) {
            return jdbcDb;
        } else if ("mongo".equals(databaseMode)) {
            log.info("Starting mongodb Configuration");
            return mongoDb;
        }
        throw new ConfigurationException("invalid value for 'database.mode': " + databaseMode);

    }
}
