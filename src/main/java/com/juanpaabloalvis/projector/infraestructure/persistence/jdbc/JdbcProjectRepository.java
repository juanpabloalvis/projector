package com.juanpaabloalvis.projector.infraestructure.persistence.jdbc;

import com.juanpaabloalvis.projector.application.dto.ProjectDto;
import com.juanpaabloalvis.projector.application.ports.out.CreateProjectOutPort;
import com.juanpaabloalvis.projector.infraestructure.mappers.ProjectMapper;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.entities.Project;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.respository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcProjectRepository implements CreateProjectOutPort {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectDto saveProject(ProjectDto projectDto) {

        log.debug("Info {}", projectDto);
        Project project = ProjectMapper.INSTANCE.toEntity(projectDto);

        project = projectRepository.save(project);
        ProjectDto dto = ProjectMapper.INSTANCE.toDto(project);
        log.debug("Saved with id: {}", project.getId());
        return dto;
    }
}
