package com.unicauca.smart_consumption.infrastructure.product.dataproviders.query.nosql;

import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.product.ports.out.IProductQueryRepository;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductMongoMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductMongoQueryRepositoryAdapter implements IProductQueryRepository {

  private final ProductMongoRepository productMongoRepository;
  private final ProductMongoMapper productMongoMapper;

  @Override
  public Optional<Product> findProductById(String id) {
    return productMongoRepository.findById(id)
        .map(productMongoMapper::toDomain);
  }

  @Override
  public List<Product> findAllProducts() {
    return productMongoRepository.findAll().stream()
        .map(productMongoMapper::toDomain)
        .toList();
  }
}