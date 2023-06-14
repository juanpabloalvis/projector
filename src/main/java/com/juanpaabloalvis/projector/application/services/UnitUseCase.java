package com.juanpaabloalvis.projector.application.services;

import com.juanpaabloalvis.projector.application.dto.Unit;
import com.juanpaabloalvis.projector.application.ports.in.UnitInPort;
import com.juanpaabloalvis.projector.application.ports.out.UnitOutPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UnitUseCase implements UnitInPort {

    private final UnitOutPort unitOutPort;

    public UnitUseCase(@Qualifier("unitDatabaseConfig") UnitOutPort unitOutPort) {
        this.unitOutPort = unitOutPort;
    }

    @Override
    public Unit createUnit(Unit project) {
        // do the business logic
        return unitOutPort.saveUnit(project);
    }

    @Override
    public Unit updateUnit(Unit project) {
        // do the business logic
        return unitOutPort.updateUnit(project);
    }

    @Override
    public void deleteUnit(String id) {
        // do the business logic
        unitOutPort.deleteUnitById(id);
    }

    @Override
    public Unit getUnitById(String id) {
        return unitOutPort.getUnitById(id);
    }
}
