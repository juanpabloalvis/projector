package com.juanpaabloalvis.projector.adapter.mappers;

import com.juanpaabloalvis.projector.adapter.rest.dto.ProjectRequestDto;
import com.juanpaabloalvis.projector.adapter.rest.dto.ProjectResponseDto;
import com.juanpaabloalvis.projector.application.dto.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectAdapterMapper {

    ProjectAdapterMapper INSTANCE = Mappers.getMapper(ProjectAdapterMapper.class);


    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "creationDate", target = "creationDate")
    ProjectDto toProjectDto(ProjectRequestDto project);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "creationDate", target = "creationDate")
    ProjectResponseDto toResponseDto(ProjectDto projectDto);
}
