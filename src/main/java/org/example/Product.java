package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Product {
    private String name;
    private Set<Product> allIngredients;
    private Map<String, Boolean> ingredientCache;

    public Product(String name) {
        this.name = name;
        this.allIngredients = new HashSet<>();
        this.ingredientCache = new HashMap<>(); // Мемоизация
    }

    public Set<Product> getAllIngredients() {
        return allIngredients;
    }

    public String getName() {
        return name;
    }

    public boolean addProduct(Product product) {
        if (product.hasIngredient(this)) {
            return false;
        }
        allIngredients.add(product);
        allIngredients.addAll(product.getAllIngredients());
        invalidateCache();
        return true;
    }

    private void invalidateCache() {
        ingredientCache.clear();
    }

    private boolean hasIngredient(Product product) {
        if (this == product) {
            return true;
        }
        // Мемоизация
        if (ingredientCache.containsKey(product.getName())) {
            return ingredientCache.get(product.getName());
        }

        boolean result = allIngredients.contains(product) ||
            allIngredients.stream().anyMatch(ingredient -> ingredient.hasIngredient(product));
        ingredientCache.put(product.getName(), result);

        return result;
    }
}
