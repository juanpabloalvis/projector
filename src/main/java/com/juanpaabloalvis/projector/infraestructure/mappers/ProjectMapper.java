package com.juanpaabloalvis.projector.infraestructure.mappers;

import com.juanpaabloalvis.projector.application.dto.ProjectDto;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.entities.Project;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "creationDate", target = "creationDate")
    Project toEntity(ProjectDto projectDto);

    @InheritInverseConfiguration
    ProjectDto toDto(Project project);
}
