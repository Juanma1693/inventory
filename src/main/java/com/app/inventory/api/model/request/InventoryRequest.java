package com.app.inventory.api.model.request;

import lombok.Getter;

import javax.validation.constraints.Min;

@Getter
public class InventoryRequest {

    @Min(value = 1, message = "idProduct can't be less than 1")
    private long idProduct;

    @Min(value = 1, message = "idProduct can't be less than 1")
    private long idPacking;

    @Min(value = 1, message = "quantity can't be less than 1")
    private int quantity;

}
