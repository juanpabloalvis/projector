package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.ports.out.ProjectOutPort;
import com.juanpaabloalvis.projector.infraestructure.mappers.ProjectMapper;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.ProjectDocument;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository.ProjectMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component("mongodbProjectService")
public class MongoProjectRepository implements ProjectOutPort {

    private final ProjectMongoRepository projectRepository;
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
    public Project updateProject(Project project) {

        log.debug("Info {}", project);
        ProjectDocument projectDocument = ProjectMapper.INSTANCE.toDocument(project);
        projectDocument = projectRepository.save(projectDocument);
        Project dto = ProjectMapper.INSTANCE.toDomain(projectDocument);
        log.debug("Updated with id: {}", projectDocument.getId());
        return dto;
    }

    @Override
    public void deleteProjectById(String id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project getProjectById(String id) {
        return projectRepository.findById(id)
                .map(ProjectMapper.INSTANCE::toDomain)
                .orElseThrow();

    }

//    @Override
//    public Unit saveUnit(Unit unit) {
//
//        log.debug("Info {}", unit);
//        UnitDocument unitDocument = UnitMapper.INSTANCE.toDocument(unit);
//
//        unitDocument = unitRepository.save(unitDocument);
//        Unit dto = UnitMapper.INSTANCE.toDomain(unitDocument);
//        log.debug("Saved with id: {}", unitDocument.getId());
//        return dto;
//    }
}
