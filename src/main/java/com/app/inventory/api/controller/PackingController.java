package com.app.inventory.api.controller;

import com.app.inventory.domain.port.out.ServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/packing")
/*@OpenAPIDefinition(
        info = @Info(
                title = "",
                version = ""
        )
)*/
public class PackingController {

    private ServicePort servicePort;

    PackingController(@Autowired ServicePort servicePort){
        this.servicePort = servicePort;
    }

    @GetMapping
    //@Operation(summary = "")
    String getAllPacking() {
        return "Hello from get";
    }

    @GetMapping("/{id}")
    //@Operation(summary = "")
    String getlPackingById() {
        return "Hello from get";
    }

    @PostMapping
    //@Operation(summary = "")
    String createPacking() {
        return "Hello from get";
    }

    @PutMapping
    //@Operation(summary = "")
    String upadtePacking() {
        return "Hello from get";
    }

    @DeleteMapping
    //@Operation(summary = "")
    String deletePacking() {
        return "Hello from get";
    }
}
