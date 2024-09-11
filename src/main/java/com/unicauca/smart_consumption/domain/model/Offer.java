package com.unicauca.smart_consumption.domain.model;

import com.unicauca.smart_consumption.domain.model.valueObject.Period;

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
        if (!Objects.nonNull(description) || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        if (!Objects.nonNull(validityPeriod)) {
            throw new IllegalArgumentException("Validity period cannot be null.");
        }
        if (!Objects.nonNull(product)) {
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

    public void setDiscountPercentage(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        this.discountPercentage = discountPercentage;
        this.discountedPrice = calculateDiscountedPrice();
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

