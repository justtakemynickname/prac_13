package prac_13.first;

// 2. Автомобиль выбран (CarSelected)
class CarSelectedState implements OrderState {
    private OrderSystem context;

    public CarSelectedState(OrderSystem context) {
        this.context = context;
        System.out.println("--- Статус: Авто выбрано. Подтвердите заказ или отмените. ---");
    }

    @Override
    public void confirmOrder() {
        System.out.println("Заказ подтвержден. Поиск водителя...");
        context.setState(new OrderConfirmedState(context));
    }

    @Override
    public void cancelOrder() {
        System.out.println("Выбор отменен.");
        context.setState(new TripCancelledState(context));
    }

    @Override public void selectCar() { System.out.println("Авто уже выбрано. Вы можете сменить его (логика замены)."); }
    @Override public void carArrived() { System.out.println("Сначала подтвердите заказ."); }
    @Override public void startTrip() { System.out.println("Сначала подтвердите заказ."); }
    @Override public void completeTrip() { System.out.println("Поездка еще не началась."); }
    @Override public void pay() { System.out.println("Рано платить."); }
}

