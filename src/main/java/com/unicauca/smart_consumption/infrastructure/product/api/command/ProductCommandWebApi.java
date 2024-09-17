package com.unicauca.smart_consumption.infrastructure.product.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.smart_consumption.domain.common.ResponseDto;
import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.product.ports.in.IProductCommandService;
import com.unicauca.smart_consumption.infrastructure.pattern.dto.ProductPostgresDto;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductPostgresMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/product-command")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductCommandWebApi {

    private final IProductCommandService productCommandService;
    private final ProductPostgresMapper productPostgresMapper;

    @PostMapping
    public ResponseEntity<ResponseDto<ProductPostgresDto>> createProduct(@RequestBody ProductPostgresDto productDto) {
        Product product =  productPostgresMapper.toDomain(productDto);
        ResponseDto<Product> productResponse = productCommandService.createProduct(product);
        ProductPostgresDto createdProductDto = productPostgresMapper.toTarget(productResponse.getData());
        return new ResponseDto<>(productResponse.getStatus(),
                productResponse.getMessage(), createdProductDto).of();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<ProductPostgresDto>> updateProduct(@PathVariable String id, @RequestBody ProductPostgresDto productDto) {
        Product product = productPostgresMapper.toDomain(productDto);
        ResponseDto<Product> productResponse = productCommandService.updateProduct(id, product);
        ProductPostgresDto updatedProductDto = productPostgresMapper.toTarget(productResponse.getData());
        return new ResponseDto<>(productResponse.getStatus(),
                productResponse.getMessage(), updatedProductDto).of();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteProduct(@PathVariable String id) {
        ResponseDto<Void> productResponse =  productCommandService.deleteProduct(id);
        return new ResponseDto<Void>(productResponse.getStatus(), productResponse.getMessage()).of();
    }
    
}
