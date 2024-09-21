package com.unicauca.smart_consumption.application.service.offer;

import com.unicauca.smart_consumption.domain.common.ResponseDto;
import com.unicauca.smart_consumption.domain.constant.MessagesConstant;
import com.unicauca.smart_consumption.domain.offer.Offer;
import com.unicauca.smart_consumption.domain.offer.ports.in.IOfferService;
import com.unicauca.smart_consumption.domain.offer.ports.out.IOfferRepository;
import com.unicauca.smart_consumption.infrastructure.exception.BusinessRuleException;
import com.unicauca.smart_consumption.infrastructure.messages.MessageLoader;
import com.unicauca.smart_consumption.infrastructure.pattern.dto.ProductPostgresDto;
import com.unicauca.smart_consumption.infrastructure.pattern.dto.StoreDto;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ProductPostgresMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OfferServiceImpl implements IOfferService {

    private final IOfferRepository offerRepository;
    private final StoreMapper storeMapper;
    private final ProductPostgresMapper productPostgresMapper;
    private final NotifyUsers notify;

    @Override
    public ResponseDto<Offer> createOffer(Offer offer, StoreDto storeDto, ProductPostgresDto productPostgresDto) {
        offer.setProduct(productPostgresMapper.toDomain(productPostgresDto));
        offer.setStore(storeMapper.toDomain(storeDto));
        Offer createdOffer = offerRepository.createOffer(offer);
        notify.notifyUsers(createdOffer.getProduct());
        return new ResponseDto<>(HttpStatus.CREATED.value(),
                MessageLoader.getInstance().getMessage(MessagesConstant.IM002), createdOffer);
    }

    @Override
    public ResponseDto<Offer> updateOffer(String id, Offer offer) {
        Offer updatedOffer = offerRepository.updateOffer(id, offer);
        return new ResponseDto<>(HttpStatus.OK.value(),
                MessageLoader.getInstance().getMessage(MessagesConstant.IM003), updatedOffer);
    }

    @Override
    public ResponseDto<Void> deleteOffer(String id) {
        if (offerRepository.findOfferById(id).isEmpty()) {
            offerRepository.deleteOffer(id);
            return new ResponseDto<>(HttpStatus.NO_CONTENT.value(),
                    MessageLoader.getInstance().getMessage(MessagesConstant.IM004));
        } else {
            throw new BusinessRuleException(HttpStatus.BAD_REQUEST.value(), MessagesConstant.EM002,
                    MessageLoader.getInstance().getMessage(MessagesConstant.EM002, id));
        }
    }

    @Override
    public ResponseDto<Offer> findOfferById(String id) {
        Offer offer = offerRepository.findOfferById(id)
                .orElseThrow(() -> new BusinessRuleException(HttpStatus.BAD_REQUEST.value(), MessagesConstant.EM002,
                        MessageLoader.getInstance().getMessage(MessagesConstant.EM002, id)));
        return new ResponseDto<>(HttpStatus.OK.value(),
                MessageLoader.getInstance().getMessage(MessagesConstant.IM001), offer);
    }

    @Override
    public ResponseDto<List<Offer>> findAllOffers() {
        List<Offer> offers = offerRepository.findAllOffers();
        return new ResponseDto<>(HttpStatus.OK.value(),
                MessageLoader.getInstance().getMessage(MessagesConstant.IM001), offers);
    }

}
