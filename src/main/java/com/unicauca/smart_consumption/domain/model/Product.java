package com.unicauca.smart_consumption.domain.model;

import com.unicauca.smart_consumption.domain.model.valueObject.Category;
import com.unicauca.smart_consumption.domain.model.valueObject.Detail;
import com.unicauca.smart_consumption.domain.model.valueObject.ProductStatus;
import com.unicauca.smart_consumption.domain.model.valueObject.SustainabilityCriteria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Product {
        private int id;
        private String name;
        private Category category;
        private Detail detail;
        private SustainabilityCriteria sustainabilityCriteria;
        private ProductStatus status;
        private double price;
        private List<Review> reviews;
        private List<Store> stores;
        public Product(int id, String name, Category category, Detail detail,
                       SustainabilityCriteria sustainabilityCriteria, double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.detail = detail;
            this.status = ProductStatus.AVAILABLE;
            this.sustainabilityCriteria = sustainabilityCriteria;
            this.price = price;
            this.reviews = new ArrayList<>();
            this.stores = new ArrayList<>();
        }

        public void updateCategory(Category newCategory) {
            this.category = newCategory;
        }

        public void updateDetail(Detail newDetail) {
            this.detail = newDetail;
        }

        public void updateSustainabilityCriteria(SustainabilityCriteria newCriteria) {
            this.sustainabilityCriteria = newCriteria;
        }

        public boolean isSustainable() {
            return this.sustainabilityCriteria.getSustainabilityScore() > 75;
        }

        public boolean isInCategory(Category category) {
            return this.category.equals(category);
        }

        public boolean matchesDetail(Detail detail) {
            return this.detail.equals(detail);
        }

        public void updateStatus(ProductStatus newStatus) {
            this.status = newStatus;
        }

        public void addStore(Store store) {
            if (Objects.nonNull(store) && !stores.contains(store)) {
                stores.add(store);
            }
        }

        public void removeStore(Store store) {
            stores.remove(store);
        }

        public boolean isAvailableInStore(Store store) {
            return stores.contains(store);
        }

        public List<Store> getStoresByCity(City city) {
            List<Store> storesByCity = new ArrayList<>();
            for (Store store : stores) {
                if (store.getCity().equals(city)) {
                    storesByCity.add(store);
                }
            }
            return storesByCity;
        }
        public void applyDiscount(double percentage) {
            if (percentage > 0 && percentage <= 100) {
                this.price -= this.price * (percentage / 100);
            }
        }

        public double calculateAverageRating() {
            List<Review> reviews = this.getReviews();
            if (reviews.isEmpty()) {
                return 0.0;
            }
            double sum = 0.0;
            for (Review review : reviews) {
                sum += review.getRating().getValue();
            }
            return sum / reviews.size();
        }

        public List<Review> getReviewsSortedByDate() {
            List<Review> sortedReviews = new ArrayList<>(reviews);
            sortedReviews.sort(Comparator.comparing(Review::getDate));
            return sortedReviews;
        }

        private List<Review> getReviews() {
            return this.reviews;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public Category getCategory() {
            return category;
        }

        public Detail getDetail() {
            return detail;
        }

        public SustainabilityCriteria getSustainabilityCriteria() {
            return sustainabilityCriteria;
        }

        public ProductStatus getStatus() {
            return status;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", category=" + category +
                    ", detail=" + detail +
                    ", sustainabilityCriteria=" + sustainabilityCriteria +
                    ", status=" + status +
                    ", price=" + price +
                    '}';
        }
    }
