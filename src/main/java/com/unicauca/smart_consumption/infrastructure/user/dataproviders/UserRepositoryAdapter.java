package com.unicauca.smart_consumption.infrastructure.user.dataproviders;

import com.unicauca.smart_consumption.domain.user.User;
import com.unicauca.smart_consumption.domain.user.ports.out.IUserRepository;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.UserJPAMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserRepositoryAdapter implements IUserRepository {

    private final UserJPARepository userJPARepository;
    private final UserJPAMapper userJPAMapper;

    @Override
    public User createUser(User user) {
        UserJPAEntity entity = userJPAMapper.toTarget(user);
        return userJPAMapper.toDomain(userJPARepository.save(entity));
    }

    public User updateUser(String id, User user) {
        return userJPARepository.findById(id)
                .map(userEntity -> {
                    User domainUser = userJPAMapper.toDomain(userEntity);
                    domainUser.updateUser(user.getUsername(), user.getName(), user.getCity());
                    domainUser.setReviews(user.getReviews());
                     domainUser.setWatchList(user.getWatchList());
                    UserJPAEntity updatedEntity = userJPAMapper.toTarget(domainUser);
                    userJPARepository.save(updatedEntity);
                    return domainUser;
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
        Optional<UserJPAEntity> userJPA=userJPARepository.findById(id);
        User mapped=userJPAMapper.toDomain(userJPA.get());
        return Optional.of(mapped);
    }

    @Override
    public List<User> findAllUsers() {
        return userJPARepository.findAll().stream()
                .map(userJPAMapper::toDomain).toList();
    }


}
