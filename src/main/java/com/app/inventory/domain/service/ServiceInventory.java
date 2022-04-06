package com.app.inventory.domain.service;

import com.app.inventory.common.exception.ResourceNoContentException;
import com.app.inventory.common.exception.ResourceNotFoundException;
import com.app.inventory.domain.model.dto.InventoryDto;
import com.app.inventory.domain.model.mapper.InventoryMapper;
import com.app.inventory.domain.port.in.DataBasePort;
import com.app.inventory.domain.port.out.ServicePort;
import com.app.inventory.infrastucture.model.jpa.InventoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceInventory implements ServicePort {

    DataBasePort dataBase;
    InventoryMapper mapper;

    ServiceInventory(DataBasePort dataBase, InventoryMapper mapper){
        this.dataBase = dataBase;
        this.mapper = mapper;
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        List<InventoryEntity> listInventory = dataBase.findAllInventory();
        if (listInventory.isEmpty()){
            throw new ResourceNoContentException("Inventory not found");
        }
        return mapper.toDto(dataBase.findAllInventory());
    }

    @Override
    public InventoryDto getlInventoryById(long id) {

        Optional<InventoryEntity> inventory = dataBase.findInventoryById(id);
        if (inventory.isEmpty()){
            throw new ResourceNotFoundException("Inventory not found");
        }
        return mapper.toDto(inventory.get());

    }

    @Override
    public List<InventoryDto> getlInventoryByType(long idTypeProduct) {
        List<InventoryDto> response = mapper.toDto(dataBase.findInventoryByType(idTypeProduct));
        if (response.isEmpty()){
            throw new ResourceNotFoundException("Inventory not found");
        }
        return response;
    }

    @Override
    public InventoryDto sumProductsToInventory(long idProducto, long idPacking, int quantity) {

        Optional<InventoryEntity> inventoryEntity = dataBase.findInventoryByProductAndPacking(idProducto, idPacking);

        if (inventoryEntity.isEmpty()){
            throw new ResourceNoContentException("Inventory not found");
        }

        long newQuantity = inventoryEntity.map(inventory -> inventory.getQuantity()+quantity).get();
        InventoryEntity response = dataBase.saveInventory(inventoryEntity.get().toBuilder().quantity(newQuantity).build());

        return mapper.toDto(response);
    }

    @Override
    public InventoryDto extractProductsToInventory(long idProducto, long idPacking, int quantity) {
        Optional<InventoryEntity> inventoryEntity = dataBase.findInventoryByProductAndPacking(idProducto, idPacking);

        if (inventoryEntity.isEmpty()){
            throw new ResourceNoContentException("Inventory not found");
        }

        long newQuantity = inventoryEntity.map(inventory -> inventory.getQuantity()-quantity).get();
        InventoryEntity response = dataBase.saveInventory(inventoryEntity.get().toBuilder().quantity(newQuantity).build());

        return mapper.toDto(response);
    }
}
