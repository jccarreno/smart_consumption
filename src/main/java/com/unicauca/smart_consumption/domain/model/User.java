package com.unicauca.smart_consumption.domain.model;

import com.unicauca.smart_consumption.domain.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String name;
    private List<Review> reviews;
    private List<Offer> watchList;
    private City ubication;

    public User(int id, String username, String name, City ubication) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.ubication = ubication;
        this.reviews = new ArrayList<>();
        this.watchList = new ArrayList<>();
    }

    public void updateUser(String name, City ubication) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        if (ubication != null) {
            this.ubication = ubication;
        }
    }

    public void addReview(Review review) {
        if (Objects.nonNull(review) && !reviews.contains(review)) {
            reviews.add(review);
        }
    }

    public void removeReview(Review review) {
        reviews.remove(review);
    }

    public List<Review> getReviews() {
        return new ArrayList<>(reviews);
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

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public City getUbication() {
        return ubication;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", reviews=" + reviews +
                ", watchList=" + watchList +
                ", ubication=" + ubication +
                '}';
    }
}
