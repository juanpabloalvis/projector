package com.juanpaabloalvis.projector.application.ports.in;

import com.juanpaabloalvis.projector.application.dto.Project;

public interface ProjectInPort {
    Project createProject(Project project);
    Project updateProject(Project project);
    void deleteProject(String projectId);
    Project getProjectById(String projectId);
}
