package prac_13.first;

public class OrderSystem {
    private OrderState state;

    public OrderSystem() {
        // Начальное состояние
        this.state = new IdleState(this);
    }

    // Метод для смены состояния
    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getState() {
        return state;
    }

    // Делегирование методов текущему состоянию
    public void selectCar() {
        state.selectCar();
    }

    public void confirmOrder() {
        state.confirmOrder();
    }

    public void carArrived() {
        state.carArrived();
    }

    public void startTrip() {
        state.startTrip();
    }

    public void completeTrip() {
        state.completeTrip();
    }

    public void cancelOrder() {
        state.cancelOrder();
    }
    
    public void pay() {
        state.pay();
    }
}