package prac_13.third;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Товар добавлен в корзину: " + product.getName());
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void clear() {
        products.clear();
    }
}