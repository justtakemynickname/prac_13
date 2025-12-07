package prac_13.second;

public class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        User admin = new User(1, "Alice Admin", Role.ADMINISTRATOR);
        User user1 = new User(2, "Bob User", Role.REGISTERED_USER);
        User guest = new User(3, "Charlie Guest", Role.GUEST);

        System.out.println("=== 1. Администратор добавляет мероприятия ===");
        system.addEvent(admin, new Event(101, "Tech Conference", "2023-12-01", "Hall A"));
        system.addEvent(admin, new Event(102, "Rock Concert", "2023-12-05", "Stadium"));
        
        System.out.println("\n=== 2. Гость пытается добавить мероприятие (Ошибка) ===");
        system.addEvent(guest, new Event(103, "Private Party", "2023-12-10", "Home"));

        System.out.println("\n=== 3. Все пользователи просматривают список ===");
        system.viewEvents();

        System.out.println("\n=== 4. Регистрация бронирования ===");
        system.createBooking(user1, 101);
        system.createBooking(user1, 102);
        
        System.out.println("\n=== 5. Гость пытается забронировать (Ошибка) ===");
        system.createBooking(guest, 101);

        System.out.println("\n=== 6. Администратор просматривает все бронирования ===");
        system.viewAllBookings(admin);
        
        System.out.println("\n=== 7. Пользователь просматривает бронирования (Ошибка) ===");
        system.viewAllBookings(user1);

        System.out.println("\n=== 8. Отмена бронирования пользователем ===");
        system.cancelBooking(user1, 1); 
        
        System.out.println("\n=== 9. Проверка статуса после отмены (Админ) ===");
        system.viewAllBookings(admin);

        System.out.println("\n=== 10. Управление мероприятиями (Админ) ===");
        system.editEvent(admin, 101, "Tech Conference V2", "2023-12-02", "Hall B");
        system.deleteEvent(admin, 102);
        
        system.viewEvents();
    }
}