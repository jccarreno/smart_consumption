package com.unicauca.smart_consumption.infrastructure.store.dataproviders;

import com.unicauca.smart_consumption.domain.store.Store;
import com.unicauca.smart_consumption.domain.store.ports.out.IStoreRepository;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.CityJPAMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.OfferJPAMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.StoreJPAMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StoreRepositoryAdapter implements IStoreRepository {

    private final StoreJPARepository storeRepository;
    private final StoreJPAMapper storeJPAMapper;
    private final CityJPAMapper cityJPAMapper;
    private final OfferJPAMapper offerJPAMapper;

    @Override
    public Store createStore(Store store) {
        StoreJPAEntity entity = storeJPAMapper.toTarget(store);
        return storeJPAMapper.toDomain(storeRepository.save(entity));
    }

    @Override
    public Store updateStore(String id, Store store) {
        return storeRepository.findById(id)
                .map(storeEntity -> {
                    storeEntity.setName(store.getName());
                   // storeEntity.setProducts(store.getProducts().stream()
                           // .map(productJPAMapper::toTarget).collect(Collectors.toList()));
                    storeEntity.setOffers(store.getOffers().stream()
                            .map(offerJPAMapper::toTarget).collect(Collectors.toList()));
                    storeEntity.setCity(cityJPAMapper.toTarget(store.getCity()));
                    StoreJPAEntity updatedEntity = storeRepository.save(storeEntity);
                    return storeJPAMapper.toDomain(updatedEntity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id " + id));
    }


    @Override
    public void deleteStore(String id) {
        if (storeRepository.findById(id).isEmpty()) {
            storeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Store not found with id " + id);
        }
    }

    @Override
    public Optional<Store> findStoreById(String id) {
        return storeRepository.findById(id).map(storeJPAMapper::toDomain);
    }

    @Override
    public List<Store> findAllStores() {
        return storeRepository.findAll().stream()
                .map(storeJPAMapper::toDomain).toList();
    }

}
