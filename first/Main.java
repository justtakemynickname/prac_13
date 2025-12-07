package prac_13.first;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== СЦЕНАРИЙ 1: Успешная поездка ===");
        OrderSystem taxiOrder = new OrderSystem();
        
        taxiOrder.selectCar();      // Idle -> CarSelected
        taxiOrder.confirmOrder();   // CarSelected -> OrderConfirmed
        taxiOrder.carArrived();     // OrderConfirmed -> CarArrived
        taxiOrder.startTrip();      // CarArrived -> InTrip
        
        // Попытка отмены во время поездки (должна быть ошибка)
        taxiOrder.cancelOrder();
        
        taxiOrder.completeTrip();   // InTrip -> TripCompleted
        taxiOrder.pay();            // TripCompleted -> Idle

        System.out.println("\n=== СЦЕНАРИЙ 2: Отмена заказа после подтверждения ===");
        OrderSystem cancelledOrder = new OrderSystem();
        
        cancelledOrder.selectCar();    // Idle -> CarSelected
        cancelledOrder.confirmOrder(); // CarSelected -> OrderConfirmed
        
        // Вдруг передумали
        cancelledOrder.cancelOrder();  // OrderConfirmed -> TripCancelled -> Idle
        
        // Проверка, что мы снова в Idle
        cancelledOrder.selectCar();
    }
}