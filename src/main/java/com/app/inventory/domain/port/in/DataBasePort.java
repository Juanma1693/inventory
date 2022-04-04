package com.app.inventory.domain.port.in;

import com.app.inventory.infrastucture.model.jpa.InventoryEntity;

import java.util.List;

public interface DataBasePort {

    public List<InventoryEntity> findAllInventory();

    public InventoryEntity findInventoryById(long id);

    public List<InventoryEntity> findInventoryByType(int idTypeProduct);

    public InventoryEntity sumProductsToInventory(long idProducto, long idPacking, long quantity);

    public InventoryEntity extractProductsToInventory(long idProducto, long idPacking, long quantity);
}
