package com.unicauca.smart_consumption.domain.model;

import com.unicauca.smart_consumption.domain.model.valueobject.Category;
import com.unicauca.smart_consumption.domain.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store {
    private int id;
    private String name;
    private List<Product> products;
    private List<Offer> offers;
    private City city;

    public Store(int id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.products = new ArrayList<>();
        this.offers = new ArrayList<>();
    }

    public void updateStore(String name, City city) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        if (city != null) {
            this.city = city;
        }
    }

    public void addProduct(Product product) {
        if (Objects.nonNull(product) && !products.contains(product)) {
            products.add(product);
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public boolean hasProduct(Product product) {
        return products.contains(product);
    }

    public List<Product> getSustainableProducts() {
        List<Product> sustainableProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.isSustainable()) {
                sustainableProducts.add(product);
            }
        }
        return sustainableProducts;
    }

    public List<Product> getProductsByCategory(Category category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.isInCategory(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", products=" + products +
                '}';
    }
}
