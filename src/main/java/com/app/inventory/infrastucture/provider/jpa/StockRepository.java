package com.app.inventory.infrastucture.provider.jpa;

import com.app.inventory.infrastucture.model.jpa.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {
}