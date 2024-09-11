package com.unicauca.smart_consumption.domain.model;

import com.unicauca.smart_consumption.domain.model.valueObject.Rating;
import java.time.LocalDateTime;
import java.util.Objects;


public class Review {
    private Long id;
    private User user;
    private Product product;
    private Rating rating;
    private String comment;
    private LocalDateTime date;

    public Review(Long id, User user, Product product, Rating rating, String comment) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.date = LocalDateTime.now();
    }

    public boolean isAuthentic() {
        return user.getReviews().contains(this);
    }

    public boolean isPositive() {
        return this.rating == Rating.GOOD || this.rating == Rating.EXCELLENT;
    }

    public boolean isForProduct(Product product) {
        return this.product.equals(product);
    }

    public boolean isByUser(User user) {
        return this.user.equals(user);
    }

    public void updateRating(Rating newRating) {
        if (newRating != null) {
            this.rating = newRating;
        }
    }

    public void updateComment(String newComment) {
        if (Objects.nonNull(newComment) && !newComment.trim().isEmpty()) {
            this.comment = newComment;
        }
    }


    public boolean isCommentLengthValid() {
        return this.comment.length() >= 10 && this.comment.length() <= 500;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Rating getRating() {
        return rating;
    }


    public String getComment() {
        return comment;
    }


    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
