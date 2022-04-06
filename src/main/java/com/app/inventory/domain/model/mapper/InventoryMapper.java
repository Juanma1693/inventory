package com.app.inventory.domain.model.mapper;

import com.app.inventory.domain.model.dto.InventoryDto;
import com.app.inventory.infrastucture.model.jpa.InventoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * mapper class to convert Entity to Dto and vice versa
 */
@Mapper(componentModel = "spring")
public interface InventoryMapper {

        /**
         * Cast List<InventoryEntity> to List<InventoryDto>
         * @param inventoryEntities List InventoryEntity
         * @return List InventoryDto
         */
        public List<InventoryDto> toDto(List<InventoryEntity> inventoryEntities);

        /**
         * Cast InventoryEntity to InventoryDto
         * @param inventoryEntity InventoryEntity
         * @return InventoryDto
         */
        @Mapping(source = "product.idProduct", target = "idProduct")
        @Mapping(source = "packing.idPacking", target = "idPacking")
        public InventoryDto toDto(InventoryEntity inventoryEntity);


}
