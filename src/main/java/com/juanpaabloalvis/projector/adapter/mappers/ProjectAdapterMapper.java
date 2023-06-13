package com.juanpaabloalvis.projector.adapter.mappers;

import com.juanpaabloalvis.projector.adapter.rest.dto.ProjectRequestDto;
import com.juanpaabloalvis.projector.adapter.rest.dto.ProjectResponseDto;
import com.juanpaabloalvis.projector.application.dto.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectAdapterMapper {

    ProjectAdapterMapper INSTANCE = Mappers.getMapper(ProjectAdapterMapper.class);


    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "creationDate", target = "creationDate")
    Project toDomain(ProjectRequestDto projectRequestDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "creationDate", target = "creationDate")
    ProjectResponseDto toResponseDto(Project project);
}
