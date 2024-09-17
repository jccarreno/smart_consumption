package com.unicauca.smart_consumption.infrastructure.product.dataproviders.command.sql;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unicauca.smart_consumption.domain.product.Product;
import com.unicauca.smart_consumption.domain.product.ports.out.IProductCommandRepository;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.CategoryEmbeddable;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.DetailEmbeddable;
import com.unicauca.smart_consumption.infrastructure.embeddableEntity.SustainabilityCriteriaEmbeddable;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductJpaMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductJpaCommandRepositoryAdapter implements IProductCommandRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductJpaMapper productPostgresMapper;

    @Override
    public Product createProduct(Product product) {
        ProductJpaEntity entity = productPostgresMapper.toTarget(product);
        return productPostgresMapper.toDomain(productJpaRepository.save(entity));
    }

    @Override
    public Product updateProduct(String id, Product product) {
        ProductJpaEntity productJpaEntity = productJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));

        CategoryEmbeddable category = new CategoryEmbeddable();
        category.setCategoryName(product.getCategory().getName());

        DetailEmbeddable detail = new DetailEmbeddable();
        detail.setDescription(product.getDetail().getDescription());
        detail.setSpecifications(product.getDetail().getSpecifications());

        SustainabilityCriteriaEmbeddable sustainabilityCriteria = new SustainabilityCriteriaEmbeddable();
        sustainabilityCriteria.setCarbonFootprint(product.getSustainabilityCriteria().getCarbonFootprint());
        sustainabilityCriteria.setEnergyEfficiency(product.getSustainabilityCriteria().getEnergyEfficiency());
        sustainabilityCriteria.setResourceUsage(product.getSustainabilityCriteria().getResourceUsage());
        sustainabilityCriteria.setWasteManagement(product.getSustainabilityCriteria().getWasteManagement());
        sustainabilityCriteria.setSustainabilityScore(product.getSustainabilityCriteria().getSustainabilityScore());

        productJpaEntity.setName(product.getName());
        productJpaEntity.setCategory(category);
        productJpaEntity.setDetail(detail);
        productJpaEntity.setSustainabilityCriteria(sustainabilityCriteria);
        productJpaEntity.setStatus(product.getStatus());
        productJpaEntity.setPrice(product.getPrice());

        ProductJpaEntity updatedEntity = productJpaRepository.save(productJpaEntity);

        return productPostgresMapper.toDomain(updatedEntity);
                
    }
                

    @Override
    public void deleteProduct(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public Optional<Product> findProductById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductById'");
    }
    
}
