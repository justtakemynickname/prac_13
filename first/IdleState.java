package prac_13.first;

// 1. Состояние ожидания (Idle)
class IdleState implements OrderState {
    private OrderSystem context;

    public IdleState(OrderSystem context) {
        this.context = context;
        System.out.println("--- Статус: Ожидание (Idle). Выберите авто. ---");
    }

    @Override
    public void selectCar() {
        System.out.println("Автомобиль выбран.");
        context.setState(new CarSelectedState(context));
    }

    // Остальные действия недоступны
    @Override public void confirmOrder() { System.out.println("Сначала выберите машину."); }
    @Override public void carArrived() { System.out.println("Заказ еще не создан."); }
    @Override public void startTrip() { System.out.println("Заказ еще не создан."); }
    @Override public void completeTrip() { System.out.println("Заказ еще не создан."); }
    @Override public void cancelOrder() { System.out.println("Нечего отменять."); }
    @Override public void pay() { System.out.println("Нечего оплачивать."); }
}