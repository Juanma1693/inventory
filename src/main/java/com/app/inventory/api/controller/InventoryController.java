package com.app.inventory.api.controller;

import com.app.inventory.api.model.request.InventoryRequest;
import com.app.inventory.domain.model.dto.InventoryDto;
import com.app.inventory.domain.port.out.ServicePort;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * inventory RestController management and consult service, more detail in http://host:port/swagger-ui/index.htm
 */
@RestController
@RequestMapping("/inventory")
@OpenAPIDefinition(
        info = @Info(
                title = "inventory management and consult service",
                version = "1.0"
        )
)
@Slf4j
public class InventoryController {

    private ServicePort servicePort;

    /**
     * constructor InventoryController
     * @param servicePort ServicePort
     */
    InventoryController(ServicePort servicePort){
        this.servicePort = servicePort;
    }

    /**
     * Return all inventory
     * @return list with all inventory, type List<InventoryDto>
     */
    @GetMapping
    @Operation(summary = "Return all inventory")
    ResponseEntity<List<InventoryDto>> getAllInventory() {
        List<InventoryDto> response = servicePort.getAllInventory();
        return ResponseEntity.ok(response);
    }

    /**
     * returns inventory with specified id
     * @param id id Inventory
     * @return inventory type InventoryDto
     */
    @GetMapping("/{id}")
    @Operation(summary = "returns inventory with specified id")
    ResponseEntity<InventoryDto> getlInventoryById(@PathVariable long id) {

        InventoryDto response = servicePort.getlInventoryById(id);

        return ResponseEntity.ok(response);
    }

    /**
     * returns inventory of the specified type
     * @param idTypeProduct
     * @return list with inventory of the specified type, type List<InventoryDto>
     */
    @GetMapping("/type/{type}")
    @Operation(summary = "returns inventory of the specified type")
    ResponseEntity<List<InventoryDto>> getlInventoryByType(@PathVariable("type") long idTypeProduct) {
        List<InventoryDto> response = servicePort.getlInventoryByType(idTypeProduct);
        return ResponseEntity.ok(response);
    }

    /**
     * add products to inventory
     * @param request InventoryRequest contains quantity idPacking idProduct
     * @return inventory type InventoryDto
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "add products to inventory")
    ResponseEntity<InventoryDto> sumProductsToInventory(@RequestBody @Valid InventoryRequest request) {
        InventoryDto response = servicePort.sumProductsToInventory(request.getIdProduct(), request.getIdPacking(), request.getQuantity());
        return ResponseEntity.ok(response);
    }

    /**
     * extract products to inventory
     * @param request InventoryRequest contains quantity idPacking idProduct
     * @return inventory type InventoryDto
     */
    @PostMapping(value = "/extract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "extract products to inventory")
    ResponseEntity<InventoryDto> extractProductsToInventory(@RequestBody @Valid InventoryRequest request) {
        InventoryDto response = servicePort.extractProductsToInventory(request.getIdProduct(), request.getIdPacking(), request.getQuantity());
        return ResponseEntity.ok(response);
    }


}
