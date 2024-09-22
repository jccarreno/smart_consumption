package com.unicauca.smart_consumption.infrastructure.product.api.sync;

import com.mongodb.client.MongoClient;
import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.infrastructure.pattern.dto.ProductMongoDto;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductJpaEntityMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductJsonEntityMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductMongoMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductPostgresMapper;
import com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql.ProductJpaEntity;
import com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql.ProductJpaRepository;
import com.unicauca.smart_consumption.infrastructure.product.dataproviders.query.nosql.ProductMongoEntity;
import com.unicauca.smart_consumption.infrastructure.product.dataproviders.query.nosql.ProductMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductSyncService {
    private final ProductJpaRepository productJpaRepository;
    private final ProductMongoRepository productMongoRepository;
    private final ProductJsonEntityMapper productJsonEntityMapper;
    private final ProductJpaEntityMapper productJpaEntityMapper;

    public void syncProducts(){
        List<ProductJpaEntity> productsJpa = productJpaRepository.findAll();
        List<Product> productsDomain=productsJpa.stream().map(productJpaEntityMapper::toDomain).toList();
        List<ProductMongoEntity> productMongos = productsDomain.stream().map(productJsonEntityMapper::toTarget).toList();
        productMongoRepository.saveAll(productMongos);
    }
}
