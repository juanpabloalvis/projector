package com.juanpaabloalvis.projector.infraestructure.persistence.mongodb.documents;

import com.juanpaabloalvis.projector.application.dto.Apu;
import com.juanpaabloalvis.projector.application.dto.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document("activity")
public class ActivityDocument {

    @Id
    private String id;
    private String parentProjectId;
    private int level;
    private String name;
    private String description;
    private String versionName;
    @DocumentReference
    private Unit activityUnit;

    private Instant startDateEstimated;
    private Instant endDateEstimated;
    private double qtyEstimated;
    @DocumentReference(lazy = true)
    private Apu apuEstimated;

    private Instant startDateReal;
    private Instant endDateReal;
    @DocumentReference(lazy = true)
    private Apu apuReal;
    private double qtyReal;


}
