package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document("activity")
public class ActivityDocument {


    @Id
    private UUID id;

    int level;
    String name;
    String description;
    String versionName;
    @DocumentReference
    UnitDocument activityUnit;

    Instant startDateEstimated;
    Instant endDateEstimated;
    double qtyEstimated;
    @DocumentReference(lazy = true)
    ApuDocument apuEstimated;

    Instant startDateReal;
    Instant endDateReal;
    double qtyReal;
    @DocumentReference(lazy = true)
    ApuDocument apuReal;

}
