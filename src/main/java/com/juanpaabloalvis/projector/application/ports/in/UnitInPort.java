package com.juanpaabloalvis.projector.application.ports.in;

import com.juanpaabloalvis.projector.application.dto.Unit;

public interface UnitInPort {
    Unit createUnit(Unit project);

    Unit updateUnit(Unit project);

    void deleteUnit(String projectId);

    Unit getUnitById(String projectId);
}
