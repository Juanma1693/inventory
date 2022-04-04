package com.app.inventory.infrastucture.provider.jpa;

import com.app.inventory.infrastucture.model.jpa.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {

    public List<InventoryEntity> findByProduct_TypeProduct_IdTypeProduct(int idTypeProduct);


    public InventoryEntity findByProduct_IdProductAndPacking_IdPacking(long idProducto, long idPacking);
}