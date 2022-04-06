package com.app.inventory.domain.port.in;

import com.app.inventory.infrastucture.model.jpa.InventoryEntity;

import java.util.List;
import java.util.Optional;

/**
 * interface to integrate database to the domain
 */
public interface DataBasePort {
    
    public List<InventoryEntity> findAllInventory();

    public Optional<InventoryEntity> findInventoryById(long id);

    public List<InventoryEntity> findInventoryByType(long idTypeProduct);

    public InventoryEntity saveInventory(InventoryEntity inventory);

    public Optional<InventoryEntity> findInventoryByProductAndPacking(long idProducto, long idPacking);
}
