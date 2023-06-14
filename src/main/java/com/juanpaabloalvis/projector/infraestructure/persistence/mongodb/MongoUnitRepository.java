package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.dto.Unit;
import com.juanpaabloalvis.projector.application.ports.out.ProjectOutPort;
import com.juanpaabloalvis.projector.application.ports.out.UnitOutPort;
import com.juanpaabloalvis.projector.infraestructure.mappers.ProjectMapper;
import com.juanpaabloalvis.projector.infraestructure.mappers.UnitMapper;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.ProjectDocument;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.UnitDocument;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository.ProjectMongoRepository;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository.UnitMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component("mongodbUnitService")
public class MongoUnitRepository implements UnitOutPort {

    private final UnitMongoRepository unitRepository;

    @Override
    public Unit saveUnit(Unit project) {

        log.debug("Info {}", project);
        UnitDocument unitDocument = UnitMapper.INSTANCE.toDocument(project);

        unitDocument = unitRepository.save(unitDocument);
        Unit dto = UnitMapper.INSTANCE.toDomain(unitDocument);
        log.debug("Saved with id: {}", unitDocument.getId());
        return dto;
    }

    @Override
    public Unit updateUnit(Unit project) {

        log.debug("Info {}", project);
        UnitDocument projectDocument = UnitMapper.INSTANCE.toDocument(project);
        projectDocument = unitRepository.save(projectDocument);
        Unit dto = UnitMapper.INSTANCE.toDomain(projectDocument);
        log.debug("Updated with id: {}", projectDocument.getId());
        return dto;
    }

    @Override
    public void deleteUnitById(String id) {
        unitRepository.deleteById(id);
    }

    @Override
    public Unit getUnitById(String id) {
        return unitRepository.findById(id)
                .map(UnitMapper.INSTANCE::toDomain)
                .orElseThrow();

    }

//    @Override
//    public Unit saveUnit(Unit unit) {
//
//        log.debug("Info {}", unit);
//        UnitDocument unitDocument = UnitMapper.INSTANCE.toDocument(unit);
//
//        unitDocument = unitRepository.save(unitDocument);
//        Unit dto = UnitMapper.INSTANCE.toDomain(unitDocument);
//        log.debug("Saved with id: {}", unitDocument.getId());
//        return dto;
//    }
}
