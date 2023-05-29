package com.juanpaabloalvis.projector.application.ports.out;

import com.juanpaabloalvis.projector.application.dto.ProjectDto;

public interface CreateProjectOutPort {
    ProjectDto saveProject(ProjectDto projectDto);
}
