package org.example;

import java.util.HashSet;
import java.util.Set;

public class Product {
    private String name;
    private Set<String> ingredients;

    public Product(String name) {
        this.name = name;
        this.ingredients = new HashSet<>();
    }

    private Set<String> getIngredients() {
        return ingredients;
    }

    private String getName() {
        return name;
    }

    public boolean addProduct(Product product) {
        if (product.hasIngredient(this)) {
            return false;
        }
        ingredients.add(product.getName());
        ingredients.addAll(product.getIngredients());
        return true;
    }

    private boolean hasIngredient(Product product) {
        if (this.getName().equals(product.getName())) {
            return true;
        }
        return this.getIngredients().contains(product.getName());
    }
}
