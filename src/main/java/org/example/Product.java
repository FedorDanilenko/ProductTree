package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Product {
    private String name;
    private Set<Product> ingredients;
    Map<String, Boolean> ingredientCache;

    public Product(String name) {
        this.name = name;
        this.ingredients = new HashSet<>();
        this.ingredientCache = new HashMap<>();
    }

    private Set<Product> getIngredients() {
        return ingredients;
    }

    private String getName() {
        return name;
    }

    public boolean addProduct(Product product) {
        if (product.hasIngredient(this)) {
            return false;
        }
        ingredients.add(product);
        ingredientCache.put(product.getName(), true);
        return true;
    }

    private boolean hasIngredient(Product product) {
        if (this == product) {
            return true;
        }
        if (ingredientCache.containsKey(product.getName())) {
            return ingredientCache.get(product.getName());
        }
        for (Product ingredient : ingredients) {
            if (ingredient.hasIngredient(product)) {
                return true;
            }
        }
        return false;
    }
}
