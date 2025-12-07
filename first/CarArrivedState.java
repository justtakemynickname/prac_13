package prac_13.first;

// 4. Машина прибыла (CarArrived)
class CarArrivedState implements OrderState {
    private OrderSystem context;

    public CarArrivedState(OrderSystem context) {
        this.context = context;
        System.out.println("--- Статус: Машина ожидает вас. ---");
    }

    @Override
    public void startTrip() {
        System.out.println("Поездка началась!");
        context.setState(new InTripState(context));
    }

    @Override
    public void cancelOrder() {
        System.out.println("Заказ отменен на этапе ожидания.");
        context.setState(new TripCancelledState(context));
    }

    @Override public void selectCar() { System.out.println("Нельзя сменить авто сейчас."); }
    @Override public void confirmOrder() { System.out.println("Уже прибыл."); }
    @Override public void carArrived() { System.out.println("Уже на месте."); }
    @Override public void completeTrip() { System.out.println("Сначала начните поездку."); }
    @Override public void pay() { System.out.println("Рано платить."); }
}

