package prac_13.first;

// Интерфейс State определяет методы, которые должны реализовать все конкретные состояния
public interface OrderState {
    void selectCar();
    void confirmOrder();
    void carArrived();
    void startTrip();
    void completeTrip();
    void cancelOrder();
    void pay();
}