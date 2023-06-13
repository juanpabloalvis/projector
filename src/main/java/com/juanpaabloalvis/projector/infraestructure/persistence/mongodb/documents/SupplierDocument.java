package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document("unit")
public class SupplierDocument {
    @Id
    private UUID id;
    private String name;
    private String description;
    @DocumentReference
    private UnitDocument supplierUnit;
}
