package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.repository;

import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.ProjectDocument;
import com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents.UnitDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitMongoRepository extends MongoRepository<UnitDocument, String> {


}
