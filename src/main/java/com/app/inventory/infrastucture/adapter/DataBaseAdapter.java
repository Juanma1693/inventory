package com.app.inventory.infrastucture.adapter;

import com.app.inventory.domain.port.in.DataBasePort;
import com.app.inventory.infrastucture.model.jpa.InventoryEntity;
import com.app.inventory.infrastucture.provider.jpa.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataBaseAdapter implements DataBasePort {

    private InventoryRepository inventoryRepository;

    DataBaseAdapter(@Autowired InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<InventoryEntity> findAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public InventoryEntity findInventoryById(long id) {
        return inventoryRepository.getById(id);
    }

    @Override
    public List<InventoryEntity> findInventoryByType(int idTypeProduct) {

        return inventoryRepository.findByProduct_TypeProduct_IdTypeProduct(idTypeProduct);
    }

    @Override
    public InventoryEntity sumProductsToInventory(long idProducto, long idPacking, long quantity) {

        InventoryEntity inventoryEntity = inventoryRepository.findByProduct_IdProductAndPacking_IdPacking(idProducto, idPacking);
        long newQuantity = inventoryEntity.getQuantity()+quantity;
        InventoryEntity resp = inventoryRepository.save(inventoryEntity.toBuilder().quantity(newQuantity).build());

        return resp;
    }

    @Override
    public InventoryEntity extractProductsToInventory(long idProducto, long idPacking, long quantity) {

        InventoryEntity inventoryEntity = inventoryRepository.findByProduct_IdProductAndPacking_IdPacking(idProducto, idPacking);
        long newQuantity = inventoryEntity.getQuantity()-quantity;
        InventoryEntity resp = inventoryRepository.save(inventoryEntity.toBuilder().quantity(newQuantity).build());

        return resp;
    }
}
