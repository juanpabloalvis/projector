package com.juanpaabloalvis.projector.adapter.rest;

import com.juanpaabloalvis.projector.adapter.mappers.UnitAdapterMapper;
import com.juanpaabloalvis.projector.adapter.rest.dto.UnitRequestDto;
import com.juanpaabloalvis.projector.adapter.rest.dto.UnitResponseDto;
import com.juanpaabloalvis.projector.application.dto.Unit;
import com.juanpaabloalvis.projector.application.ports.in.UnitInPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("units")
@RequiredArgsConstructor
@Slf4j
public class UnitsController {

    private final UnitInPort unitInPort;

    @PostMapping(produces = "application/json")
    public @ResponseBody UnitResponseDto getUnit(@RequestBody UnitRequestDto unitRequestDto) {

        log.debug("Data: {}", unitRequestDto);
        Unit unit = UnitAdapterMapper.INSTANCE.toDomain(unitRequestDto);
        unit = unitInPort.createUnit(unit);
        UnitResponseDto unitResponseDto = UnitAdapterMapper.INSTANCE.toResponseDto(unit);
        log.debug("The response was {}", unitResponseDto);
        return unitResponseDto;
    }

}
