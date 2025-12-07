package prac_13.third;

public class Main {
    public static void main(String[] args) {
        // Инициализация систем
        PaymentSystem paymentSystem = new PaymentSystem();
        OrderProcessor processor = new OrderProcessor();
        
        // ==========================================
        // СЦЕНАРИЙ 1: Успешное оформление заказа
        // ==========================================
        System.out.println("\n=== СЦЕНАРИЙ 1: Успешная покупка ===");
        
        // 1. Выбор товаров
        Cart cart1 = new Cart();
        cart1.addProduct(new Product(1, "Laptop", 1200.00));
        cart1.addProduct(new Product(2, "Mouse", 25.50));
        
        // 2. Оформление заказа
        System.out.println("Переход к оформлению...");
        Order order1 = new Order(101, "Ivan Petrov", "Lenina St, 10", cart1);
        
        // 3. Оплата (Decision Node)
        if (paymentSystem.pay(order1.getTotalAmount())) {
            // 4. Подтверждение оплаты
            order1.setStatus("Paid");
            
            // 5. Обработка заказа
            processor.processOrder(order1);
            
            // 6. Отправка заказа
            processor.shipOrder(order1);
            
            System.out.println("Заказ успешно завершен!");
        } else {
            order1.setStatus("Cancelled (Payment Failed)");
            System.out.println("Заказ отменен из-за ошибки оплаты.");
        }

        // ==========================================
        // СЦЕНАРИЙ 2: Ошибка оплаты (Альтернативный путь)
        // ==========================================
        System.out.println("\n=== СЦЕНАРИЙ 2: Покупка с ошибкой оплаты ===");
        
        Cart cart2 = new Cart();
        cart2.addProduct(new Product(3, "Super Gaming PC", 3000.00)); // Цена > 2000 вызовет ошибку
        
        System.out.println("Переход к оформлению...");
        Order order2 = new Order(102, "Maria Sidorova", "Gogolya St, 5", cart2);
        
        // Попытка оплаты
        if (paymentSystem.pay(order2.getTotalAmount())) {
            order2.setStatus("Paid");
            processor.processOrder(order2);
            processor.shipOrder(order2);
        } else {
            // Ветвление "Нет"
            order2.setStatus("Payment Failed");
            System.out.println("Пожалуйста, попробуйте другую карту или обратитесь в банк.");
        }
    }
}