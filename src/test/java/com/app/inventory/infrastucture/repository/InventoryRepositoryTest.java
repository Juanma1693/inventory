package com.app.inventory.infrastucture.repository;

import com.app.inventory.infrastucture.model.jpa.InventoryEntity;
import com.app.inventory.infrastucture.model.jpa.PackingEntity;
import com.app.inventory.infrastucture.model.jpa.ProductEntity;
import com.app.inventory.infrastucture.model.jpa.TypeProductEntity;
import com.app.inventory.infrastucture.provider.jpa.InventoryRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@Sql("classpath:inserts.sql")
public class InventoryRepositoryTest {

    @Autowired
    InventoryRepository repo;

    @Test
    public void testSave(){

        TypeProductEntity type = TypeProductEntity.builder().idTypeProduct(1).name("cell phone").build();

        PackingEntity packing = PackingEntity.builder().idPacking(2).height(5.0).high(6.5).quantity(10).width(8.6).build();

        ProductEntity product = ProductEntity.builder().idProduct(1).name("rice").price(new BigDecimal(3500)).typeProduct(type).packing(packing).build();

        InventoryEntity inventory = repo.save(InventoryEntity.builder().packing(packing).product(product).quantity(5).build());

        Assertions.assertNotNull(inventory);

        Assertions.assertTrue( inventory.getIdInventory() > 0);
    }

    @Test
    public void testFindById(){

        Optional<InventoryEntity> inventory = repo.findById(1);

        Assertions.assertTrue(inventory.isPresent());

        Assertions.assertTrue(inventory.get().getQuantity() > 0);

    }

    @Test
    public void testFindByProduct_IdProductAndPacking_IdPacking(){

        Optional<InventoryEntity> resp = repo.findByProduct_IdProductAndPacking_IdPacking(4,4);

        Assertions.assertTrue(resp.isPresent());

        Assertions.assertTrue(resp.get().getQuantity() > 0);

    }

    @Test
    public void testFindByProduct_TypeProduct_IdTypeProduct(){

        List<InventoryEntity> resp = repo.findByProduct_TypeProduct_IdTypeProduct(1);

        Assertions.assertTrue(resp.size() > 0);

    }

}
