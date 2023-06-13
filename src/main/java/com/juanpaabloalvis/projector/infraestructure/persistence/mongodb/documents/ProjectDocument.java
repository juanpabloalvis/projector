package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("project")
public class ProjectDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private Instant creationDate;
}
