package com.app.inventory.api.controller;

import com.app.inventory.domain.port.out.ServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
/*@OpenAPIDefinition(
        info = @Info(
                title = "",
                version = ""
        )
)*/
public class ProductController {

    private ServicePort servicePort;

    ProductController(@Autowired ServicePort servicePort){
        this.servicePort = servicePort;
    }
    
    @GetMapping
    //@Operation(summary = "")
    String getAllProduct() {
        return "Hello from get";
    }

    @GetMapping("/{id}")
    //@Operation(summary = "")
    String getProductById() {
        return "Hello from get";
    }

    @PostMapping
    //@Operation(summary = "")
    String createProduct() {
        return "Hello from get";
    }

    @PutMapping
    //@Operation(summary = "")
    String upadteProduct() {
        return "Hello from get";
    }

    @DeleteMapping
    //@Operation(summary = "")
    String deleteProduct() {
        return "Hello from get";
    }
}
