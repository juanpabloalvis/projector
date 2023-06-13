package com.juanpaabloalvis.projector.adapter.mappers;

import com.juanpaabloalvis.projector.adapter.rest.dto.UnitRequestDto;
import com.juanpaabloalvis.projector.adapter.rest.dto.UnitResponseDto;
import com.juanpaabloalvis.projector.application.dto.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitAdapterMapper {

    UnitAdapterMapper INSTANCE = Mappers.getMapper(UnitAdapterMapper.class);


    @Mapping(source = "name", target = "name")
    @Mapping(source = "shortDescription", target = "shortDescription")
    @Mapping(source = "longDescription", target = "longDescription")
    Unit toDomain(UnitRequestDto projectRequestDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "shortDescription", target = "shortDescription")
    @Mapping(source = "longDescription", target = "longDescription")
    UnitResponseDto toResponseDto(Unit project);
}
