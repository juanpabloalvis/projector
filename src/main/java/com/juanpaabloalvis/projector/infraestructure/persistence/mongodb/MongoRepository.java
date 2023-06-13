package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.ports.out.CreateProjectOutPort;
import com.juanpaabloalvis.projector.infraestructure.mappers.ProjectMapper;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.ProjectDocument;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository.ProjectMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Component("mongodbService")
public class MongoRepository implements CreateProjectOutPort {

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
}
