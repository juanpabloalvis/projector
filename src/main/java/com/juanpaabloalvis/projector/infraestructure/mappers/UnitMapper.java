package com.juanpaabloalvis.projector.infraestructure.mappers;

import com.juanpaabloalvis.projector.application.dto.Unit;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.UnitDocument;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitMapper {

    UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "description", target = "description")
//    @Mapping(source = "creationDate", target = "creationDate")
//    UnitEntity toEntity(Unit unit);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "shortDescription", target = "shortDescription")
    @Mapping(source = "longDescription", target = "longDescription")
    UnitDocument toDocument(Unit unit);

//    @InheritInverseConfiguration
//    Unit toDomain(UnitEntity unitEntity);

    @InheritInverseConfiguration
    Unit toDomain(UnitDocument unitDocument);
}
