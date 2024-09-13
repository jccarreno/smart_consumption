package com.unicauca.smart_consumption.domain.model;

import com.unicauca.smart_consumption.domain.model.valueobject.Period;

import com.unicauca.smart_consumption.domain.product.Product;
import java.time.LocalDate;
import java.util.Objects;


public class Offer {
    private int id;
    private String description;
    private Period validityPeriod;
    private Product product;
    private double discountPercentage;
    private double discountedPrice;

    public Offer(int id, String description, Period validityPeriod, Product product, double discountPercentage) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        if (validityPeriod == null) {
            throw new IllegalArgumentException("Validity period cannot be null.");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        this.id = id;
        this.description = description;
        this.validityPeriod = validityPeriod;
        this.product = product;
        this.discountPercentage = discountPercentage;
        this.discountedPrice = calculateDiscountedPrice();
    }

    private double calculateDiscountedPrice() {
        return product.getPrice() * (1 - discountPercentage / 100);
    }

    public Offer update(String description, double discountPercentage) {
        if (description != null && !description.trim().isEmpty()) {
            this.description = description;
        }
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            this.discountPercentage = discountPercentage;
            this.discountedPrice = calculateDiscountedPrice();
        }
        return this;
    }

    public boolean isValid() {
        LocalDate today = LocalDate.now();
        return validityPeriod.isWithinPeriod(today);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Period getValidityPeriod() {
        return validityPeriod;
    }

    public Product getProduct() {
        return product;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id == offer.id &&
                Double.compare(offer.discountPercentage, discountPercentage) == 0 &&
                Double.compare(offer.discountedPrice, discountedPrice) == 0 &&
                description.equals(offer.description) &&
                validityPeriod.equals(offer.validityPeriod) &&
                product.equals(offer.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, validityPeriod, product, discountPercentage, discountedPrice);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", validityPeriod=" + validityPeriod +
                ", product=" + product +
                ", discountPercentage=" + discountPercentage +
                ", discountedPrice=" + discountedPrice +
                '}';
    }
}


