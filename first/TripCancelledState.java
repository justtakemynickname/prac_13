package prac_13.first;

// 7. Заказ отменен (TripCancelled)
class TripCancelledState implements OrderState {
    private OrderSystem context;

    public TripCancelledState(OrderSystem context) {
        this.context = context;
        System.out.println("--- Статус: Заказ отменен. ---");
        // Логика автоматического сброса в Idle или ожидание действия "ОК"
        System.out.println("Возврат в главное меню...");
        context.setState(new IdleState(context)); 
    }

    // Т.к. мы сразу в конструкторе перебрасываем в Idle, методы ниже могут не вызываться,
    // но они нужны для компиляции интерфейса.
    @Override public void selectCar() { }
    @Override public void confirmOrder() { }
    @Override public void carArrived() { }
    @Override public void startTrip() { }
    @Override public void completeTrip() { }
    @Override public void cancelOrder() { }
    @Override public void pay() { }
}