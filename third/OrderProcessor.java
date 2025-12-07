package prac_13.third;

public class OrderProcessor {

    public void processOrder(Order order) {
        System.out.println("Склад: Проверка наличия товаров...");
        try { Thread.sleep(500); } catch (InterruptedException e) { }
        
        order.setStatus("Processing (In Warehouse)");
        System.out.println("Склад: Заказ #" + order.getId() + " упакован.");
    }

    public void shipOrder(Order order) {
        System.out.println("Логистика: Передача курьерской службе...");
        
        order.setStatus("Shipped");
        System.out.println("Доставка: Заказ отправлен по адресу: " + order.toString());
    }
}