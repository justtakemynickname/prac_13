package prac_13.first;

// 5. В поездке (InTrip)
class InTripState implements OrderState {
    private OrderSystem context;

    public InTripState(OrderSystem context) {
        this.context = context;
        System.out.println("--- Статус: В пути... ---");
    }

    @Override
    public void completeTrip() {
        System.out.println("Приехали в пункт назначения.");
        context.setState(new TripCompletedState(context));
    }

    // В задании сказано: "отмена заказа на каждом этапе ДО начала поездки".
    // Значит, во время поездки отменить заказ нельзя (можно только завершить).
    @Override
    public void cancelOrder() {
        System.out.println("Нельзя отменить заказ во время движения. Попросите водителя завершить поездку.");
    }

    @Override public void selectCar() { System.out.println("Вы уже едете."); }
    @Override public void confirmOrder() { System.out.println("Вы уже едете."); }
    @Override public void carArrived() { System.out.println("Вы уже едете."); }
    @Override public void startTrip() { System.out.println("Вы уже едете."); }
    @Override public void pay() { System.out.println("Оплата после завершения."); }
}

