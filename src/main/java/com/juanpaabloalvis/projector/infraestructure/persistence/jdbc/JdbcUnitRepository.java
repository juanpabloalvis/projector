package com.juanpaabloalvis.projector.infraestructure.persistence.jdbc;

import com.juanpaabloalvis.projector.application.dto.Unit;
import com.juanpaabloalvis.projector.application.ports.out.UnitOutPort;
import com.juanpaabloalvis.projector.infraestructure.mappers.UnitMapper;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.entities.UnitEntity;
import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.respository.UnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
public class JdbcUnitRepository implements UnitOutPort {


    private final UnitRepository unitRepository;

    @Override
    public Unit saveUnit(Unit project) {

        log.debug("Info {}", project);
        UnitEntity unitEntity = UnitMapper.INSTANCE.toEntity(project);

        unitEntity = unitRepository.save(unitEntity);
        Unit dto = UnitMapper.INSTANCE.toDomain(unitEntity);
        log.debug("Saved with id: {}", unitEntity.getId());
        return dto;
    }

    @Override
    public Unit updateUnit(Unit project) {
        UnitEntity unitEntity = UnitMapper.INSTANCE.toEntity(project);
        UnitEntity updated = unitRepository.save(unitEntity);
        return UnitMapper.INSTANCE.toDomain(updated);

    }

    @Override
    public void deleteUnitById(String id) {
        unitRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public Unit getUnitById(String id) {
        return unitRepository.findById(UUID.fromString(id))
                .map(UnitMapper.INSTANCE::toDomain)
                .orElseThrow();
    }

}
