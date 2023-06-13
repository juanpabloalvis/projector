package com.juanpaabloalvis.projector.application.services;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.ports.in.CreateProjectIntInPort;
import com.juanpaabloalvis.projector.application.ports.out.CreateProjectOutPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectUseCase implements CreateProjectIntInPort {


    @Qualifier(value = "getDatabase")
    private final CreateProjectOutPort createProjectOutPort;

    public CreateProjectUseCase(@Qualifier(value = "getDatabase") CreateProjectOutPort createProjectOutPort) {
        this.createProjectOutPort = createProjectOutPort;
    }

    @Override
    public Project createProject(Project project) {
        return createProjectOutPort.saveProject(project);
    }
}
