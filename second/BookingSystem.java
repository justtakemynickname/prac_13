package prac_13.second;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Event> events = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private int bookingIdCounter = 1;

    public void viewEvents() {
        System.out.println("\n--- Список мероприятий ---");
        if (events.isEmpty()) {
            System.out.println("Мероприятий нет.");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public void addEvent(User actor, Event event) {
        if (actor.getRole() == Role.ADMINISTRATOR) {
            events.add(event);
            System.out.println("Мероприятие добавлено: " + event.getName());
        } else {
            System.out.println("Ошибка: Только администратор может добавлять мероприятия.");
        }
    }

    public void editEvent(User actor, int eventId, String newName, String newDate, String newLocation) {
        if (actor.getRole() == Role.ADMINISTRATOR) {
            for (Event event : events) {
                if (event.getId() == eventId) {
                    event.setName(newName);
                    event.setDate(newDate);
                    event.setLocation(newLocation);
                    System.out.println("Мероприятие обновлено: " + eventId);
                    return;
                }
            }
            System.out.println("Мероприятие с ID " + eventId + " не найдено.");
        } else {
            System.out.println("Ошибка: Только администратор может редактировать мероприятия.");
        }
    }

    public void deleteEvent(User actor, int eventId) {
        if (actor.getRole() == Role.ADMINISTRATOR) {
            events.removeIf(e -> e.getId() == eventId);
            System.out.println("Мероприятие удалено: " + eventId);
        } else {
            System.out.println("Ошибка: Только администратор может удалять мероприятия.");
        }
    }

    public void createBooking(User actor, int eventId) {
        if (actor.getRole() == Role.REGISTERED_USER) {
            Event targetEvent = null;
            for (Event event : events) {
                if (event.getId() == eventId) {
                    targetEvent = event;
                    break;
                }
            }

            if (targetEvent != null) {
                Booking booking = new Booking(bookingIdCounter++, actor, targetEvent, "Confirmed");
                bookings.add(booking);
                System.out.println("Бронирование создано для пользователя " + actor.getName() + " на " + targetEvent.getName());
            } else {
                System.out.println("Мероприятие не найдено.");
            }
        } else {
            System.out.println("Ошибка: Только зарегистрированные пользователи могут бронировать.");
        }
    }

    public void cancelBooking(User actor, int bookingId) {
        if (actor.getRole() == Role.REGISTERED_USER) {
            for (Booking booking : bookings) {
                if (booking.getId() == bookingId) {
                    if (booking.getUser().getId() == actor.getId()) {
                        booking.setStatus("Cancelled");
                        System.out.println("Бронирование " + bookingId + " отменено.");
                        return;
                    } else {
                        System.out.println("Ошибка: Вы не можете отменить чужое бронирование.");
                        return;
                    }
                }
            }
            System.out.println("Бронирование не найдено.");
        } else {
            System.out.println("Ошибка: Гости не могут управлять бронированием.");
        }
    }

    public void viewAllBookings(User actor) {
        if (actor.getRole() == Role.ADMINISTRATOR) {
            System.out.println("\n--- Все бронирования ---");
            if (bookings.isEmpty()) {
                System.out.println("Бронирований нет.");
            } else {
                for (Booking booking : bookings) {
                    System.out.println(booking);
                }
            }
        } else {
            System.out.println("Ошибка: Доступ запрещен. Только для администраторов.");
        }
    }
}