package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document("apu")
public class ApuDocument {
    @Id
    UUID id;
    ApuType apuType;
    List<ItemDocument> items;

}
