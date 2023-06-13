package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository;

import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.ProjectDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectMongoRepository extends MongoRepository<ProjectDocument, UUID> {


}
