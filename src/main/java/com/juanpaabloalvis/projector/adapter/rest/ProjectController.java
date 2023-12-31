package com.juanpaabloalvis.projector.adapter.rest;

import com.juanpaabloalvis.projector.adapter.mappers.ProjectAdapterMapper;
import com.juanpaabloalvis.projector.adapter.rest.dto.ProjectRequestDto;
import com.juanpaabloalvis.projector.adapter.rest.dto.ProjectResponseDto;
import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.ports.in.ProjectInPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {

    private final ProjectInPort projectInPort;

    @PostMapping(produces = "application/json")
    public @ResponseBody ProjectResponseDto getProject(@RequestBody ProjectRequestDto projectRequestDto) {

        log.debug("Data: {}", projectRequestDto);
        Project project = ProjectAdapterMapper.INSTANCE.toDomain(projectRequestDto);
        project = projectInPort.createProject(project);
        ProjectResponseDto projectResponseDto = ProjectAdapterMapper.INSTANCE.toResponseDto(project);
        log.debug("The response was {}", projectResponseDto);
        return projectResponseDto;
    }

}
