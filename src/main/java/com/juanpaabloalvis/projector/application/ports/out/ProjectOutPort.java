package com.juanpaabloalvis.projector.application.ports.out;

import com.juanpaabloalvis.projector.application.dto.Project;

public interface ProjectOutPort {
    Project saveProject(Project project);

    Project updateProject(Project project);

    void deleteProjectById(String id);

    Project getProjectById(String id);

}
