package com.app.inventory.infrastucture.provider.jpa;

import com.app.inventory.infrastucture.model.jpa.PackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingRepository extends JpaRepository<PackingEntity, Long> {
}