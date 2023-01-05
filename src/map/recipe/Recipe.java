package map.recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Recipe {
    private final String name;
    private final Map<Product, Integer> products = new HashMap<>();

    public Recipe(String name) throws IllegalAccessException {
        if (name == null || name.isBlank()) {
            throw new IllegalAccessException("Не заполнены все поля");
        }
        this.name = name;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            quantity = 1;
        }
        if (this.products.containsKey(product)) {
            this.products.put((product), this.products.get(product) + quantity);
        } else {
            this.products.put(product, quantity);
        }
    }
    public String getName() {
        return name;
    }

    public float getRecipePrice() {
        float sum = 0;
        for (Map.Entry<Product, Integer> product : this.products.entrySet()) {
            sum += product.getKey().getPrice() * product.getValue();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
