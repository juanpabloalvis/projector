package com.juanpaabloalvis.projector.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Activity {


    private String id;
    private String parentProjectId;
    private int level;
    private String name;
    private String description;
    private String versionName;
    private Unit activityUnit;

    private Instant startDateEstimated;
    private Instant endDateEstimated;
    private double qtyEstimated;
    private Apu apuEstimated;

    private Instant startDateReal;
    private Instant endDateReal;
    private Apu apuReal;
    private double qtyReal;

}
