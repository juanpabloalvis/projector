package com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.respository;

import com.juanpaabloalvis.projector.infraestructure.persistence.jdbc.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {


}
