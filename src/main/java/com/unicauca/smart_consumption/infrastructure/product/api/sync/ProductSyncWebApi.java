package com.unicauca.smart_consumption.infrastructure.product.api.sync;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sync")
@RequiredArgsConstructor
public class ProductSyncWebApi {

    private final ProductSyncService productSyncService;

    @PostMapping
    public ResponseEntity<String> syncProducts() {
        productSyncService.syncProducts();
        return ResponseEntity.ok("Sincronización de productos completada");
    }
}
