package com.juanpaabloalvis.projector.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Activity {


    private UUID id;

    int level;
    String name;
    String description;
    String versionName;
    Unit activityUnit;

    Instant startDateEstimated;
    Instant endDateEstimated;
    double qtyEstimated;
    Apu apuEstimated;

    Instant startDateReal;
    Instant endDateReal;
    Apu apuReal;
    double qtyReal;

}
