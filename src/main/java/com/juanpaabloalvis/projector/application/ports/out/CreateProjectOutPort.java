package com.juanpaabloalvis.projector.application.ports.out;

import com.juanpaabloalvis.projector.application.dto.Project;

public interface CreateProjectOutPort {
    Project saveProject(Project project);
}
