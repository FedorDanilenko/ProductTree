package org.example;

import java.util.HashSet;
import java.util.Set;

public class Product implements ProductInterface {
    private String name;
    private Set<Product> ingredients;

    public Product(String name) {
        this.name = name;
        this.ingredients = new HashSet<>();
    }

    private Set<Product> getIngredients() {
        return ingredients;
    }

    public boolean addProduct(Product product) {
        if (product == this || product.hasIngredient(this)) {
            return false;
        }
        ingredients.add(product);
        ingredients.addAll(product.getIngredients());
        return true;
    }

    private boolean hasIngredient(Product product) {
        if (this == product) {
            return true;
        }
        for (Product ingredient : ingredients) {
            if (ingredient.hasIngredient(product)) {
                return true;
            }
        }
        return false;
    }
}
