package com.app.inventory.domain.service;

import com.app.inventory.domain.model.dto.InventoryDto;
import com.app.inventory.domain.model.mapper.InventoryMapper;
import com.app.inventory.domain.port.in.DataBasePort;
import com.app.inventory.domain.port.out.ServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInventory implements ServicePort {

    DataBasePort dataSource;
    InventoryMapper mapper;

    ServiceInventory(DataBasePort dataSource, InventoryMapper mapper){
        this.dataSource = dataSource;
        this.mapper = mapper;
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        List<InventoryDto> response = mapper.toDto(dataSource.findAllInventory());
        return response;
    }

    @Override
    public InventoryDto getlInventoryById(long id) {
        InventoryDto response = mapper.toDto(dataSource.findInventoryById(id));
        return response;
    }

    @Override
    public List<InventoryDto> getlInventoryByType(int idTypeProducy) {
        List<InventoryDto> response = mapper.toDto(dataSource.findInventoryByType(idTypeProducy));
        return response;
    }

    @Override
    public InventoryDto sumProductsToInventory(long idProducto, long idPacking, int quantity) {
        InventoryDto response = mapper.toDto(dataSource.sumProductsToInventory(idProducto, idPacking, quantity));
        return response;
    }

    @Override
    public InventoryDto extractProductsToInventory(long idProducto, long idPacking, int quantity) {
        InventoryDto response = mapper.toDto(dataSource.extractProductsToInventory(idProducto, idPacking, quantity));
        return response;
    }
}
