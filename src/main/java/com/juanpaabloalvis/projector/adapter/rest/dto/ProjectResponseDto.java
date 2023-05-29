package com.juanpaabloalvis.projector.adapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseDto {
    private UUID id;
    private String name;
    private String description;
    private Instant creationDate;
}
