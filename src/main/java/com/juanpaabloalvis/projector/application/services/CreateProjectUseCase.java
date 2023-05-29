package com.juanpaabloalvis.projector.application.services;

import com.juanpaabloalvis.projector.application.dto.ProjectDto;
import com.juanpaabloalvis.projector.application.ports.in.CreateProjectIntInPort;
import com.juanpaabloalvis.projector.application.ports.out.CreateProjectOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProjectUseCase implements CreateProjectIntInPort {
    private final CreateProjectOutPort createProjectOutPort;

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        return createProjectOutPort.saveProject(projectDto);
    }
}
