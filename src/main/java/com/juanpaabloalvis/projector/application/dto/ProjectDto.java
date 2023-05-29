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
public class ProjectDto {
    private UUID id;
    private String name;
    private String description;
    private Instant creationDate;
}
