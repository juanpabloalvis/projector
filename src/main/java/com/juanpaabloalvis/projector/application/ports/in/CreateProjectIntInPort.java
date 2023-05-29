package com.juanpaabloalvis.projector.application.ports.in;

import com.juanpaabloalvis.projector.application.dto.ProjectDto;

public interface CreateProjectIntInPort {
    ProjectDto createProject(ProjectDto projectDto);
}
