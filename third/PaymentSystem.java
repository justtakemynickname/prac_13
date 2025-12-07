package prac_13.third;

import java.util.Random;

public class PaymentSystem {
    
    // Метод оплаты. Возвращает true, если оплата прошла.
    public boolean pay(double amount) {
        System.out.println("Инициализация оплаты на сумму: $" + amount + "...");
        
        // Симуляция задержки сети
        try { Thread.sleep(500); } catch (InterruptedException e) { }

        // Простая логика: если сумма больше 2000, имитируем "нехватку средств" для теста,
        // иначе успех. (Или можно использовать Random)
        if (amount > 2000) {
            System.out.println("Ошибка оплаты: Недостаточно средств или отказ банка.");
            return false;
        } else {
            System.out.println("Оплата прошла успешно.");
            return true;
        }
    }
}