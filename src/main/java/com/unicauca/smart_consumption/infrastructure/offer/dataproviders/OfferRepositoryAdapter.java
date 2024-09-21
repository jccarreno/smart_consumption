package com.unicauca.smart_consumption.infrastructure.offer.dataproviders;

import com.unicauca.smart_consumption.domain.offer.Offer;
import com.unicauca.smart_consumption.domain.offer.ports.out.IOfferRepository;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.OfferJPAMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OfferRepositoryAdapter implements IOfferRepository {

    private final OfferJPARepository offerJPARepository;
    private final OfferJPAMapper offerJPAMapper;

    @Override
    public Offer createOffer(Offer offer) {
        OfferJPAEntity entity = offerJPAMapper.toTarget(offer);
        return offerJPAMapper.toDomain(offerJPARepository.save(entity));
    }

    @Override
    public Offer updateOffer(String id, Offer offer) {
        return offerJPARepository.findById(id)
                .map(offerEntity -> {
                    Offer domainOffer = offerJPAMapper.toDomain(offerEntity);
                    domainOffer.update(offer.getDescription(), offer.getDiscountPercentage());
                    domainOffer.setValidityPeriod(offer.getValidityPeriod());
                    domainOffer.setStore(offer.getStore());
                    domainOffer.setProduct(offer.getProduct());
                    OfferJPAEntity updatedEntity = offerJPAMapper.toTarget(domainOffer);
                    offerJPARepository.save(updatedEntity);
                    return domainOffer;
                })
                .orElseThrow(() -> new EntityNotFoundException("Offer not found with id " + id));
    }


    @Override
    public void deleteOffer(String id) {
        if (offerJPARepository.findById(id).isEmpty()) {
            offerJPARepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Offer not found with id " + id);
        }
    }

    @Override
    public Optional<Offer> findOfferById(String id) {
        return offerJPARepository.findById(id).map(offerJPAMapper::toDomain);
    }

    @Override
    public List<Offer> findAllOffers() {
        return offerJPARepository.findAll().stream()
                .map(offerJPAMapper::toDomain).toList();
    }

}
