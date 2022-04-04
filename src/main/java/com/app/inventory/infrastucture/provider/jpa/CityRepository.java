package com.app.inventory.infrastucture.provider.jpa;

import com.app.inventory.infrastucture.model.jpa.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
