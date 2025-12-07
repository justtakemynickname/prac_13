package prac_13.first;

// 6. Поездка завершена (TripCompleted)
class TripCompletedState implements OrderState {
    private OrderSystem context;

    public TripCompletedState(OrderSystem context) {
        this.context = context;
        System.out.println("--- Статус: Поездка завершена. Ожидание оплаты. ---");
    }

    @Override
    public void pay() {
        System.out.println("Оплата прошла успешно. Спасибо за поездку!");
        context.setState(new IdleState(context)); // Возврат в начало
    }

    @Override public void selectCar() { System.out.println("Сначала оплатите текущую поездку."); }
    @Override public void confirmOrder() { System.out.println("Сначала оплатите."); }
    @Override public void carArrived() { System.out.println("Поездка уже закончена."); }
    @Override public void startTrip() { System.out.println("Поездка уже закончена."); }
    @Override public void completeTrip() { System.out.println("Уже завершена."); }
    @Override public void cancelOrder() { System.out.println("Поездка уже состоялась, отмена невозможна."); }
}

