package com.app.inventory.domain.port.out;

import com.app.inventory.api.model.request.InventoryRequest;
import com.app.inventory.domain.model.dto.InventoryDto;

import java.util.List;

public interface ServicePort {


    public List<InventoryDto> getAllInventory();

    public InventoryDto getlInventoryById(long id);

    public List<InventoryDto> getlInventoryByType(long idTypeProduct);

    public InventoryDto sumProductsToInventory(long idProducto, long idPacking, int quantity);

    public InventoryDto extractProductsToInventory(long idProducto, long idPacking, int quantity);
}
