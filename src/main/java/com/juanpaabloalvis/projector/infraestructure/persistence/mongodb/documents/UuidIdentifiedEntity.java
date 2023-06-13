package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.UUID;

 @Data
 @Getter
 @AllArgsConstructor
 public abstract class UuidIdentifiedEntity {

    @Id
    protected UUID id;

    public void setId(UUID id) {

        if (this.id != null) {
            throw new UnsupportedOperationException("ID is already defined");
        }

        this.id = id;
    }

}