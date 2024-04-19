import org.example.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {

    @Test
    public void productCakeTest() {
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
    public void productDoughTest() {
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

    @Test
    public void houseTest() {
        Product house = new Product("house");
        Product door = new Product("door");
        Product window = new Product("window");
        Product walls = new Product("walls");
        Product woods = new Product("woods");
        Product knob = new Product("knob");
        Product glass = new Product("glass");
        Product brick = new Product("brick");
        Product cement = new Product("cement");

        assertTrue(door.addProduct(woods));
        assertTrue(door.addProduct(knob));

        assertTrue(window.addProduct(woods));
        assertTrue(window.addProduct(glass));
        assertTrue(window.addProduct(knob));

        assertTrue(walls.addProduct(brick));
        assertTrue(walls.addProduct(cement));

        assertTrue(house.addProduct(walls));
        assertTrue(house.addProduct(door));
        assertTrue(house.addProduct(window));

        assertFalse(walls.addProduct(house));
        assertFalse(woods.addProduct(house));
        assertFalse(walls.addProduct(house));
        assertFalse(knob.addProduct(door));
        assertFalse(knob.addProduct(window));
    }

    @Test
    public void partTest() {
        Product dough = new Product("dough");
        Product flour = new Product("flour");
        Product eggs = new Product("eggs");
        Product water = new Product("water");
        Product wheat = new Product("wheat");

        assertTrue(flour.addProduct(wheat));
        assertTrue(wheat.addProduct(dough));

        assertTrue(dough.addProduct(eggs));
        assertTrue(dough.addProduct(water));

        assertFalse(dough.addProduct(flour));
    }
}
