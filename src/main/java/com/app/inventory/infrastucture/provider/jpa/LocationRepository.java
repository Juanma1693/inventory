package com.app.inventory.infrastucture.provider.jpa;

import com.app.inventory.infrastucture.model.jpa.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
}