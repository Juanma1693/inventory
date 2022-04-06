package com.app.inventory.api.controller;

import com.app.inventory.api.model.response.ErrorBody;
import com.app.inventory.common.exception.ResourceNoContentException;
import com.app.inventory.common.exception.ResourceNotFoundException;
import com.app.inventory.domain.model.dto.InventoryDto;
import com.app.inventory.domain.port.out.ServicePort;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InventoryController.class)
@AutoConfigureMockMvc
public class InventoryControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    private ServicePort service;

    private static final String BASE_PATH = "/inventory";

    private static final String GET_BY_ID = BASE_PATH.concat("/?");

    private static final String GET_ALL = BASE_PATH;

    private static final String GET_BY_TYPE = BASE_PATH.concat("/type/?");

    private static final String POST_SUM_PRODUCTS = BASE_PATH;

    private static final String POST_DISCOUNT_PRODUCTS = BASE_PATH.concat("/extract");

    @Test
    public void testGetAll() throws Exception {

        List<InventoryDto> respMock = new ArrayList<>();
        respMock.add(InventoryDto.builder().idPacking(1).idProduct(1).quantity(10).build());

        Mockito.when(service.getAllInventory()).thenReturn(respMock);

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.get(GET_ALL)

        ).andExpect(status().isOk()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        List<InventoryDto>  listInventory = mapper.readValue(resultSS, new TypeReference<List<InventoryDto>>() {});

        Assertions.assertNotNull(listInventory);
        Assertions.assertFalse(listInventory.isEmpty());
        Assertions.assertEquals(respMock.get(0).getIdProduct(), listInventory.get(0).getIdProduct());
    }

    @Test
    public void testGetById() throws Exception {

        InventoryDto respMock = InventoryDto.builder().idPacking(1).idProduct(1).quantity(10).build();

        Mockito.when(service.getlInventoryById(anyLong())).thenReturn(respMock);

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.get(GET_BY_ID.replace("?", "1"))

        ).andExpect(status().isOk()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        InventoryDto  inventory = mapper.readValue(resultSS, InventoryDto.class);

        Assertions.assertNotNull(inventory);
        Assertions.assertEquals(respMock.getIdProduct(), inventory.getIdProduct());
    }

    @Test
    public void testGetByType() throws Exception {

        List<InventoryDto> respMock = new ArrayList<>();
        respMock.add(InventoryDto.builder().idPacking(1).idProduct(1).quantity(10).build());

        Mockito.when(service.getlInventoryByType(anyLong())).thenReturn(respMock);

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.get(GET_BY_TYPE.replace("?", "1"))

        ).andExpect(status().isOk()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        List<InventoryDto>  listInventory = mapper.readValue(resultSS, new TypeReference<List<InventoryDto>>() {});

        Assertions.assertNotNull(listInventory);
        Assertions.assertFalse(listInventory.isEmpty());
        Assertions.assertEquals(respMock.get(0).getIdProduct(), listInventory.get(0).getIdProduct());
    }

    @Test
    public void testPostSumProducts() throws Exception {

        InventoryDto respMock = InventoryDto.builder().idPacking(1).idProduct(1).quantity(10).build();

        Mockito.when(service.sumProductsToInventory(anyLong(), anyLong(), anyInt())).thenReturn(respMock);

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS)
                        .content("{\n" +
                                "  \"idPacking\": 1,\n" +
                                "  \"idProduct\": 1,\n" +
                                "  \"quantity\": 10\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isOk()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        InventoryDto  inventory = mapper.readValue(resultSS, InventoryDto.class);

        Assertions.assertNotNull(inventory);
        Assertions.assertEquals(respMock.getIdProduct(), inventory.getIdProduct());
    }

    @Test
    public void testPostDiscountProducts() throws Exception {

        InventoryDto respMock = InventoryDto.builder().idPacking(1).idProduct(1).quantity(10).build();

        Mockito.when(service.extractProductsToInventory(anyLong(), anyLong(), anyInt())).thenReturn(respMock);

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_DISCOUNT_PRODUCTS)
                        .content("{\n" +
                                "  \"idPacking\": 1,\n" +
                                "  \"idProduct\": 1,\n" +
                                "  \"quantity\": 10\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isOk()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        InventoryDto  inventory = mapper.readValue(resultSS, InventoryDto.class);

        Assertions.assertNotNull(inventory);
        Assertions.assertEquals(respMock.getIdProduct(), inventory.getIdProduct());
    }

    @Test
    public void testIdPackingZero() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS)
                        .content("{\n" +
                                "  \"idPacking\": 0,\n" +
                                "  \"idProduct\": 1,\n" +
                                "  \"quantity\": 10\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertTrue(body.getMessage().contains("idPacking"), "the message is not correct");
    }

    @Test
    public void testIdPackingEmpty() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS)
                        .content("{\n" +
                                "  \"idProduct\": 1,\n" +
                                "  \"quantity\": 10\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertTrue(body.getMessage().contains("idPacking"), "the message is not correct");
    }

    @Test
    public void testIdProductZero() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS)
                        .content("{\n" +
                                "  \"idPacking\": 5,\n" +
                                "  \"idProduct\": 0,\n" +
                                "  \"quantity\": 10\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertTrue(body.getMessage().contains("idProduct"), "the message is not correct");
    }

    @Test
    public void testIdProductEmpty() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS)
                        .content("{\n" +
                                "  \"idPacking\": 5,\n" +
                                "  \"quantity\": 10\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertTrue(body.getMessage().contains("idProduct"), "the message is not correct");
    }

    @Test
    public void testQuantityZero() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS)
                        .content("{\n" +
                                "  \"idPacking\": 5,\n" +
                                "  \"idProduct\": 1,\n" +
                                "  \"quantity\": 0\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertTrue(body.getMessage().contains("quantity"), "the message is not correct");
    }

    @Test
    public void testQuantityEmpty() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS)
                        .content("{\n" +
                                "  \"idPacking\": 5,\n" +
                                "  \"idProduct\": 1\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertTrue(body.getMessage().contains("quantity"), "the message is not correct");
    }

    @Test
    public void testErrorBodyFormat() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS)
                        .content("{\n" +
                                "  \"idPacking\": 5,\n" +
                                "  \"idProduct\": 1,\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertEquals("error in body format or empty body", body.getMessage(), "the message is not correct");
    }

    @Test
    public void testBodyEmpty() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS).contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertEquals("error in body format or empty body", body.getMessage(), "the message is not correct");
    }

    @Test
    public void testInvalidMediaType() throws Exception {

        MvcResult result = mock.perform(
                MockMvcRequestBuilders.post(POST_SUM_PRODUCTS).contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(status().isBadRequest()).andReturn();

        String resultSS = result.getResponse().getContentAsString();
        ErrorBody  body = mapper.readValue(resultSS, ErrorBody.class);

        Assertions.assertEquals("Invalid Media type", body.getMessage(), "the message is not correct");
    }

    @Test
    public void testNoContentException() throws Exception {

        Mockito.when(service.getAllInventory()).thenThrow(ResourceNoContentException.class);

        mock.perform(
                MockMvcRequestBuilders.get(GET_ALL)
        ).andExpect(status().isNoContent());

    }

    @Test
    public void testFoundException() throws Exception {

        Mockito.when(service.getAllInventory()).thenThrow(ResourceNotFoundException.class);

        mock.perform(
                MockMvcRequestBuilders.get(GET_ALL)
        ).andExpect(status().isNotFound());

    }
}
