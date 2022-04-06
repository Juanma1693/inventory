package com.app.inventory.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InventoryDto {

    private long idInventory;

    private long quantity;

    private long idProduct;

    private long idPacking;
}
