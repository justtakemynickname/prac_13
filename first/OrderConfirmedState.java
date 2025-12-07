package prac_13.first;

// 3. Заказ подтвержден (OrderConfirmed)
class OrderConfirmedState implements OrderState {
    private OrderSystem context;

    public OrderConfirmedState(OrderSystem context) {
        this.context = context;
        System.out.println("--- Статус: Заказ подтвержден. Машина в пути. ---");
    }

    @Override
    public void carArrived() {
        System.out.println("Водитель подъехал.");
        context.setState(new CarArrivedState(context));
    }

    @Override
    public void cancelOrder() {
        System.out.println("Заказ отменен пользователем.");
        context.setState(new TripCancelledState(context));
    }

    @Override public void selectCar() { System.out.println("Заказ уже в работе. Нельзя выбрать другое авто."); }
    @Override public void confirmOrder() { System.out.println("Заказ уже подтвержден."); }
    @Override public void startTrip() { System.out.println("Машина еще не приехала."); }
    @Override public void completeTrip() { System.out.println("Поездка не началась."); }
    @Override public void pay() { System.out.println("Рано платить."); }
}

