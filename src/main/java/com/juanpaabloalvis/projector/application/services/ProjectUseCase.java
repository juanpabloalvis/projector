package com.juanpaabloalvis.projector.application.services;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.ports.in.ProjectInPort;
import com.juanpaabloalvis.projector.application.ports.out.ProjectOutPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProjectUseCase implements ProjectInPort {


    private final ProjectOutPort projectOutPort;

    public ProjectUseCase(@Qualifier(value = "projectDatabase") ProjectOutPort projectOutPort) {
        this.projectOutPort = projectOutPort;
    }

    @Override
    public Project createProject(Project project) {
        // do the business logic
        return projectOutPort.saveProject(project);
    }

    @Override
    public Project updateProject(Project project) {
        // do the business logic
        return projectOutPort.updateProject(project);
    }

    @Override
    public void deleteProject(String id) {
        // do the business logic
        projectOutPort.deleteProjectById(id);
    }

    @Override
    public Project getProjectById(String id) {
        return projectOutPort.getProjectById(id);
    }
}
