package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Product {
    private String name;
    private Set<Product> ingredients;
    private Map<String, Boolean> ingredientCache;

    public Product(String name) {
        this.name = name;
        this.ingredients = new HashSet<>();
        this.ingredientCache = new HashMap<>(); // Мемоизация
    }

    public Set<Product> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public boolean addProduct(Product product) {
        if (product.hasIngredient(this)) {
            return false;
        }
        ingredients.add(product);
        ingredients.addAll(product.getIngredients());
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
        boolean result = ingredients.contains(product) ||
            ingredients.stream().anyMatch(ingredient -> ingredient.hasIngredient(product));
        ingredientCache.put(product.getName(), result);
        return result;
    }
}
