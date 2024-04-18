import org.example.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    @Test
    public void ProductCakeTest() {
        Product cake = new Product("cake");
        Product vanilla = new Product("vanilla");
        Product cacao = new Product("cacao");
        Product dough = new Product("dough");
        Product coffee = new Product("coffee");
        Product water = new Product("water");
        Product eggs = new Product("eggs");
        Product flour = new Product("flour");

        assertTrue(cake.addProduct(vanilla));
        assertTrue(cake.addProduct(cacao));
        assertTrue(cake.addProduct(dough));

        assertTrue(cacao.addProduct(coffee));
        assertTrue(cacao.addProduct(water));

        assertTrue(dough.addProduct(eggs));
        assertTrue(dough.addProduct(flour));
        assertTrue(dough.addProduct(water));
    }

    @Test
    public void ProductDoughTest() {
        Product dough = new Product("dough");
        Product flour = new Product("flour");
        Product eggs = new Product("eggs");
        Product water = new Product("water");
        Product wheat = new Product("wheat");

        assertTrue(dough.addProduct(flour));
        assertTrue(dough.addProduct(water));
        assertTrue(dough.addProduct(eggs));
        assertFalse(flour.addProduct(dough));
        assertTrue(dough.addProduct(wheat));
        assertFalse(wheat.addProduct(dough));
    }
}
