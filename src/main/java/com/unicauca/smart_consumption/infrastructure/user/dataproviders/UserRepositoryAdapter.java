package com.unicauca.smart_consumption.infrastructure.user.dataproviders;

import com.unicauca.smart_consumption.domain.user.User;
import com.unicauca.smart_consumption.domain.user.ports.out.IUserRepository;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.CityJPAMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.OfferJPAMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ReviewJPAMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.UserJPAMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserRepositoryAdapter implements IUserRepository {

    private final UserJPARepository userJPARepository;
    private final UserJPAMapper userJPAMapper;
    private final ReviewJPAMapper reviewJPAMapper;
    private final CityJPAMapper cityJPAMapper;
    private final OfferJPAMapper offerJPAMapper;

    @Override
    public User createUser(User user) {
        UserJPAEntity entity = userJPAMapper.toTarget(user);
        return userJPAMapper.toDomain(userJPARepository.save(entity));
    }

    @Override
    public User updateUser(String id, User user) {
        return userJPARepository.findById(id)
                .map(userEntity -> {
                    userEntity.setUsername(user.getUsername());
                    userEntity.setName(user.getName());
                    userEntity.setReviewList(user.getReviews().stream()
                            .map(reviewJPAMapper::toTarget).collect(Collectors.toList()));
                    userEntity.setWatchList(user.getWatchList().stream()
                            .map(offerJPAMapper::toTarget).collect(Collectors.toList()));
                    userEntity.setCity(cityJPAMapper.toTarget(user.getCity()));
                    UserJPAEntity updatedEntity = userJPARepository.save(userEntity);
                    return userJPAMapper.toDomain(updatedEntity);
                })
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void deleteUser(String id) {
        if (userJPARepository.findById(id).isEmpty()) {
            userJPARepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found with id " + id);
        }
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userJPARepository.findById(id).map(userJPAMapper::toDomain);
    }

    @Override
    public List<User> findAllUsers() {
        return userJPARepository.findAll().stream()
                .map(userJPAMapper::toDomain).toList();
    }


}
