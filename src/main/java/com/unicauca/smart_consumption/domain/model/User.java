package com.unicauca.smart_consumption.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String user;
    private String name;
    private List<Review> reviews;
    private List<Offer> watchList;
    private City ubication;

    public void addReview(Review review) {
        if (Objects.nonNull(review) && !reviews.contains(review)) {
            reviews.add(review);
        }
    }

    public List<Review> getReviews() {
        return new ArrayList<>(reviews);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
    }

    public boolean hasReviewedProduct(Product product) {
        return reviews.stream().anyMatch(review -> review.isForProduct(product));
    }

    public boolean hasPositiveReviews() {
        return reviews.stream().anyMatch(Review::isPositive);
    }

    public boolean isReviewAuthentic(Review review) {
        return reviews.contains(review) && review.isAuthentic();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", name='" + name + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
