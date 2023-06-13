package com.juanpaabloalvis.projector.application.ports.out;

import com.juanpaabloalvis.projector.application.dto.Project;
import com.juanpaabloalvis.projector.application.dto.Unit;

public interface CreateProjectOutPort {
    Project saveProject(Project project);
    Unit saveUnit(Unit unit);
}
