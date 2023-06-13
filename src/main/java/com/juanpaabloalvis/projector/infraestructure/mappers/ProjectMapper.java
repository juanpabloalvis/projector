package com.juanpaabloalvis.projector.infraestructure.mappers;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.entities.ProjectEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "creationDate", target = "creationDate")
    ProjectEntity toEntity(Project project);

    @InheritInverseConfiguration
    Project toDomain(ProjectEntity projectEntity);
}
