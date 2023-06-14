package com.juanpaabloalvis.projector.infraestructure.persistence.jdbc;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.ports.out.ProjectOutPort;
import com.juanpaabloalvis.projector.infraestructure.mappers.ProjectMapper;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.entities.ProjectEntity;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.respository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component("jdbcProjectService")
public class JdbcRepository implements ProjectOutPort {


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

    @Override
    public Project updateProject(Project project) {
        ProjectEntity projectEntity = ProjectMapper.INSTANCE.toEntity(project);
        ProjectEntity updated = projectRepository.save(projectEntity);
        return ProjectMapper.INSTANCE.toDomain(updated);

    }

    @Override
    public void deleteProjectById(String id) {
        projectRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public Project getProjectById(String id) {
        return projectRepository.findById(UUID.fromString(id))
                .map(ProjectMapper.INSTANCE::toDomain)
                .orElseThrow();
    }

}
