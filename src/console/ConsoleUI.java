package console;

import java.util.Scanner;

// Реализация меню в консольном окне

public class ConsoleUI {
    private final Scanner scanner;
    private final ConsoleService consoleService;

    public ConsoleUI(Scanner scanner, ConsoleService consoleService) {
        this.scanner = scanner;
        this.consoleService = consoleService;
    }

    public void start() {
        System.out.println("Добро пожаловать в приложение \"Список контактов\"!");

        while (true) {
            System.out.println("\n1. Добавить контакт\n2. Просмотреть список контактов\n3. Найти контакт по имени\n4. Удалить контакт\n5. Выход");
            System.out.print("Выберите действие (введите номер): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    consoleService.addContact();
                    break;
                case 2:
                    consoleService.displayContacts();
                    break;
                case 3:
                    consoleService.searchContact();
                    break;
                case 4:
                    consoleService.removeContact();
                    break;
                case 5:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
    }
}
