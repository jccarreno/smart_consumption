package com.unicauca.smart_consumption.infrastructure.review.dataproviders;

import com.unicauca.smart_consumption.domain.review.Review;
import com.unicauca.smart_consumption.domain.review.ports.out.IReviewRepository;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.ReviewJPAMapper;
import com.unicauca.smart_consumption.infrastructure.pattern.mapper.UserJPAMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ReviewRepositoryAdapter implements IReviewRepository {

    private final ReviewJPARepository reviewJPARepository;
    private final ReviewJPAMapper reviewJPAMapper;
    private final UserJPAMapper userJPAMapper;

    @Override
    public Review createReview(Review review) {
        ReviewJPAEntity entity = reviewJPAMapper.toTarget(review);
        return reviewJPAMapper.toDomain(reviewJPARepository.save(entity));
    }

    @Override
    public Review updateReview(String id, Review review) {
        return reviewJPARepository.findById(id)
                .map(reviewEntity -> {
                    reviewEntity.setUser(userJPAMapper.toTarget(review.getUser()));
                   // reviewEntity.setProduct(review.getProduct());
                    reviewEntity.setRating(review.getRating());
                    reviewEntity.setComment(review.getComment());
                    reviewEntity.setDatePublication(review.getDate());
                    ReviewJPAEntity updatedEntity = reviewJPARepository.save(reviewEntity);
                    return reviewJPAMapper.toDomain(updatedEntity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id " + id));
    }

    @Override
    public void deleteReview(String id) {
        if (reviewJPARepository.existsById(id)) {
            reviewJPARepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Review not found with id " + id);
        }
    }

    @Override
    public Optional<Review> findReviewById(String id) {
        return reviewJPARepository.findById(id).map(reviewJPAMapper::toDomain);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewJPARepository.findAll().stream()
                .map(reviewJPAMapper::toDomain).toList();
    }
}
