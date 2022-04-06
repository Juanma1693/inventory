package com.app.inventory.infrastucture.adapter;


import com.app.inventory.domain.port.in.DataBasePort;
import com.app.inventory.infrastucture.model.jpa.InventoryEntity;
import com.app.inventory.infrastucture.provider.jpa.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DataBaseAdapter implements DataBasePort {

    private InventoryRepository inventoryRepository;

    DataBaseAdapter(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<InventoryEntity> findAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<InventoryEntity> findInventoryById(long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public List<InventoryEntity> findInventoryByType(long idTypeProduct) {
        return inventoryRepository.findByProduct_TypeProduct_IdTypeProduct(idTypeProduct);

    }

    @Override
    public InventoryEntity saveInventory(InventoryEntity inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Optional<InventoryEntity> findInventoryByProductAndPacking(long idProducto, long idPacking) {
        return inventoryRepository.findByProduct_IdProductAndPacking_IdPacking(idProducto, idPacking);
    }
}
