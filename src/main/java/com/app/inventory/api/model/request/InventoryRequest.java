package com.app.inventory.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Model class to update inventory
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryRequest {

    @Positive(message = "idProduct must be greater than 0.")
    private long idProduct;

    @Positive(message = "idPacking must be greater than 0.")
    private long idPacking;

    @Positive(message = "quantity must be greater than 0.")
    private int quantity;

}
