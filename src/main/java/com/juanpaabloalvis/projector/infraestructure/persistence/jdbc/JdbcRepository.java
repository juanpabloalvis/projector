package com.juanpaabloalvis.projector.infraestructure.persistence.jdbc;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.ports.out.CreateProjectOutPort;
import com.juanpaabloalvis.projector.infraestructure.mappers.ProjectMapper;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.entities.ProjectEntity;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.respository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component("jdbcService")
public class JdbcRepository implements CreateProjectOutPort {


    private final ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {

        log.debug("Info {}", project);
        ProjectEntity projectEntity = ProjectMapper.INSTANCE.toEntity(project);

        projectEntity = projectRepository.save(projectEntity);
        Project dto = ProjectMapper.INSTANCE.toDomain(projectEntity);
        log.debug("Saved with id: {}", projectEntity.getId());
        return dto;
    }
}
