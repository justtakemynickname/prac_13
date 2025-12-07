package prac_13.third;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private String address;
    private List<Product> products;
    private double totalAmount;
    private String status;

    public Order(int orderId, String customerName, String address, Cart cart) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.address = address;
        // Копируем товары из корзины в заказ
        this.products = new ArrayList<>(cart.getProducts());
        this.totalAmount = cart.getTotalPrice();
        this.status = "Created";
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println("--- Статус заказа #" + orderId + " изменен: " + status + " ---");
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order #" + orderId + " for " + customerName + " (Total: $" + totalAmount + ")";
    }
}