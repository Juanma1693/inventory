package com.app.inventory.domain.service;

import com.app.inventory.common.exception.ResourceNoContentException;
import com.app.inventory.common.exception.ResourceNotFoundException;
import com.app.inventory.domain.model.dto.InventoryDto;
import com.app.inventory.domain.model.mapper.InventoryMapper;
import com.app.inventory.domain.port.in.DataBasePort;
import com.app.inventory.domain.port.out.ServicePort;
import com.app.inventory.infrastucture.model.jpa.InventoryEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
public class ServiceInventoryTest {

    @MockBean
    private DataBasePort dataBase;

    @Autowired
    private InventoryMapper mapper;

    private ServicePort service;

    @BeforeEach
    public void setUp(){
        service = new ServiceInventory(dataBase, mapper);
    }

    @Test
    public void testGetAllInventoryOk(){

        List<InventoryEntity> respMock = IntStream.range(1,4).mapToObj(i -> InventoryEntity.builder().idInventory(i).quantity(i*10).packing(null).product(null).build()).collect(Collectors.toList());
        Mockito.when(dataBase.findAllInventory()).thenReturn(respMock);

        List<InventoryDto> serviceResp = service.getAllInventory();

        Assertions.assertNotNull(serviceResp, "answer cannot be null");

        Assertions.assertEquals(respMock.size(),serviceResp.size(), "List is not the expected size, expected: ".concat(String.valueOf(respMock.size())).concat(" actual: ").concat(String.valueOf(serviceResp.size())));

        Assertions.assertInstanceOf(InventoryDto.class, serviceResp.stream().findFirst().get(), "response objects must be of type InventoryDto" );

        Assertions.assertEquals(respMock.get(0).getIdInventory(), serviceResp.get(0).getIdInventory(), "the id is not as expected: ".concat(String.valueOf(respMock.get(0).getIdInventory())));

        Assertions.assertEquals(respMock.get(0).getQuantity(), serviceResp.get(0).getQuantity(), "the quantity is not as expected: ".concat(String.valueOf(respMock.get(0).getQuantity())));
    }

    @Test
    public void testGetAllInventoryNoContentException(){

        Mockito.when(dataBase.findAllInventory()).thenReturn(new ArrayList<>());

        Assertions.assertThrowsExactly(ResourceNoContentException.class, () -> service.getAllInventory(),"If no records are found it should return ResourceNoContentException");

    }

    @Test
    public void testGetlInventoryByIdOk(){

        InventoryEntity respMock = InventoryEntity.builder().idInventory(1).quantity(10).packing(null).product(null).build();

        Mockito.when(dataBase.findInventoryById(anyLong())).thenReturn(Optional.of(respMock));

        InventoryDto serviceResp = service.getlInventoryById(1);

        Assertions.assertNotNull(serviceResp, "answer cannot be null");

        Assertions.assertInstanceOf(InventoryDto.class, serviceResp, "response objects must be of type InventoryDto" );

        Assertions.assertEquals(respMock.getIdInventory(), serviceResp.getIdInventory(), "the id is not as expected: ".concat(String.valueOf(respMock.getIdInventory())));

        Assertions.assertEquals(respMock.getQuantity(), serviceResp.getQuantity(), "the quantity is not as expected: ".concat(String.valueOf(respMock.getQuantity())));
    }

    @Test
    public void testGetlInventoryByIdNotFoundException(){

        Mockito.when(dataBase.findInventoryById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrowsExactly(ResourceNotFoundException.class, () -> service.getlInventoryById(1),"If no records are found it should return ResourceNotFoundException");

    }

    @Test
    public void testGetlInventoryByTypeOk(){

        List<InventoryEntity> respMock = IntStream.range(1,4).mapToObj(i -> InventoryEntity.builder().idInventory(i).quantity(i*10).packing(null).product(null).build()).collect(Collectors.toList());
        Mockito.when(dataBase.findInventoryByType(anyLong())).thenReturn(respMock);

        List<InventoryDto> serviceResp = service.getlInventoryByType(1);

        Assertions.assertNotNull(serviceResp, "answer cannot be null");

        Assertions.assertEquals(respMock.size(),serviceResp.size(), "List is not the expected size, expected: ".concat(String.valueOf(respMock.size())).concat(" actual: ").concat(String.valueOf(serviceResp.size())));

        Assertions.assertInstanceOf(InventoryDto.class, serviceResp.stream().findFirst().get(), "response objects must be of type InventoryDto" );

        Assertions.assertEquals(respMock.get(0).getIdInventory(), serviceResp.get(0).getIdInventory(), "the id is not as expected: ".concat(String.valueOf(respMock.get(0).getIdInventory())));

        Assertions.assertEquals(respMock.get(0).getQuantity(), serviceResp.get(0).getQuantity(), "the quantity is not as expected: ".concat(String.valueOf(respMock.get(0).getQuantity())));
    }

    @Test
    public void testGetlInventoryByTypeNoContentException(){

        Mockito.when(dataBase.findInventoryByType(anyLong())).thenReturn(new ArrayList<>());

        Assertions.assertThrowsExactly(ResourceNotFoundException.class, () -> service.getlInventoryByType(1),"If no records are found it should return ResourceNotFoundException");

    }

    @Test
    public void testSumProductsToInventoryOk(){

        InventoryEntity respMock = InventoryEntity.builder().idInventory(1).quantity(10).packing(null).product(null).build();

        Mockito.when(dataBase.findInventoryByProductAndPacking(anyLong(),anyLong())).thenReturn(Optional.ofNullable(respMock));

        InventoryEntity respMockSum = respMock.toBuilder().quantity(11).build();

        Mockito.when(dataBase.saveInventory(any())).thenReturn(respMockSum);

        InventoryDto serviceResp = service.sumProductsToInventory(1, 1,1);

        Assertions.assertNotNull(serviceResp, "answer cannot be null");

        Assertions.assertInstanceOf(InventoryDto.class, serviceResp, "response objects must be of type InventoryDto" );

        Assertions.assertEquals(respMock.getIdInventory(), serviceResp.getIdInventory(), "the id is not as expected: ".concat(String.valueOf(respMock.getIdInventory())));

        Assertions.assertTrue(respMock.getQuantity() <= serviceResp.getQuantity(), "quantity not increased");
    }

    @Test
    public void testSumProductsToInventoryNoContentException(){

        Mockito.when(dataBase.findInventoryByProductAndPacking(anyLong(),anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrowsExactly(ResourceNoContentException.class, () -> service.sumProductsToInventory(1, 1,1),"If no records are found it should return ResourceNoContentException");

    }

    @Test
    public void testExtractProductsToInventoryOk(){

        InventoryEntity respMock = InventoryEntity.builder().idInventory(1).quantity(10).packing(null).product(null).build();

        Mockito.when(dataBase.findInventoryByProductAndPacking(anyLong(),anyLong())).thenReturn(Optional.ofNullable(respMock));

        InventoryEntity respMockSum = respMock.toBuilder().quantity(11).build();

        Mockito.when(dataBase.saveInventory(any())).thenReturn(respMockSum);

        InventoryDto serviceResp = service.extractProductsToInventory(1, 1,1);

        Assertions.assertNotNull(serviceResp, "answer cannot be null");

        Assertions.assertInstanceOf(InventoryDto.class, serviceResp, "response objects must be of type InventoryDto" );

        Assertions.assertEquals(respMock.getIdInventory(), serviceResp.getIdInventory(), "the id is not as expected: ".concat(String.valueOf(respMock.getIdInventory())));

        Assertions.assertTrue(respMock.getQuantity() <= serviceResp.getQuantity(), "quantity not increased");
    }

    @Test
    public void testExtractProductsToInventoryNoContentException(){

        Mockito.when(dataBase.findInventoryByProductAndPacking(anyLong(),anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrowsExactly(ResourceNoContentException.class, () -> service.extractProductsToInventory(1, 1,1),"If no records are found it should return ResourceNoContentException");

    }

}
