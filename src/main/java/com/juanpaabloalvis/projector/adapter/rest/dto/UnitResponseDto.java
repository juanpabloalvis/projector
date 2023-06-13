package com.juanpaabloalvis.projector.adapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class UnitResponseDto {
    private String id;
    private String name;
    private String shortDescription;
    private String longDescription;
}
