package com.juanpaabloalvis.projector.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    UUID id;
    private Supplier supplier;
    private double vlrUnit;
}
