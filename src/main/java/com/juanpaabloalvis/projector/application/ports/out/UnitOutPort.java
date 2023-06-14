package com.juanpaabloalvis.projector.application.ports.out;

import com.juanpaabloalvis.projector.application.dto.Unit;

public interface UnitOutPort {
    Unit saveUnit(Unit project);

    Unit updateUnit(Unit project);

    void deleteUnitById(String id);

    Unit getUnitById(String id);

}
