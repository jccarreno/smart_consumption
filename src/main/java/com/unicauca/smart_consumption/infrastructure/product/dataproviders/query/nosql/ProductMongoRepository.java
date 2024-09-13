package com.unicauca.smart_consumption.infrastructure.product.dataproviders.query.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository <ProductMongoEntity,String> {
}
