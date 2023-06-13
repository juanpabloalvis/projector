package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.dto.Unit;
import com.juanpaabloalvis.projector.application.ports.out.CreateProjectOutPort;
import com.juanpaabloalvis.projector.infraestructure.mappers.ProjectMapper;
import com.juanpaabloalvis.projector.infraestructure.mappers.UnitMapper;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.ProjectDocument;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.UnitDocument;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository.ProjectMongoRepository;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository.UnitMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component("mongodbService")
public class MongoRepository implements CreateProjectOutPort {

    private final ProjectMongoRepository projectRepository;
    private final UnitMongoRepository unitRepository;

    @Override
    public Project saveProject(Project project) {

        log.debug("Info {}", project);
        ProjectDocument projectDocument = ProjectMapper.INSTANCE.toDocument(project);

        projectDocument = projectRepository.save(projectDocument);
        Project dto = ProjectMapper.INSTANCE.toDomain(projectDocument);
        log.debug("Saved with id: {}", projectDocument.getId());
        return dto;
    }

    @Override
    public Unit saveUnit(Unit unit) {

        log.debug("Info {}", unit);
        UnitDocument unitDocument = UnitMapper.INSTANCE.toDocument(unit);

        unitDocument = unitRepository.save(unitDocument);
        Unit dto = UnitMapper.INSTANCE.toDomain(unitDocument);
        log.debug("Saved with id: {}", unitDocument.getId());
        return dto;
    }
}
