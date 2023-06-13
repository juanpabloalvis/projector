package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    UnitDocument activityUnit;

    Instant startDateEstimated;
    Instant endDateEstimated;
    double qtyEstimated;
    ApuDocument apuEstimated;

    Instant startDateReal;
    Instant endDateReal;
    ApuDocument apuReal;
    double qtyReal;

}
