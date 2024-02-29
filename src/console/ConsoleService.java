package console;

// Бизнес логика работы консоли

import contact.Contact;
import contact.ContactService;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private final ContactService contactService;
    private final Scanner scanner;

    public ConsoleService(ContactService contactService, Scanner scanner) {
        this.contactService = contactService;
        this.scanner = scanner;
    }

    public void addContact() {
        System.out.print("Введите имя контакта: ");
        String name = scanner.nextLine();
        System.out.print("Введите фамилию контакта: ");
        String surname = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phone = scanner.nextLine();
        System.out.print("Введите адрес электронной почты: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, surname, phone, email);
        contactService.addContact(contact);
        System.out.println("Контакт успешно добавлен.");
    }

    public void displayContacts() {
        List<Contact> contacts = (List<Contact>) contactService.getContacts();
        if (contacts.isEmpty()) {
            System.out.println("Список контактов: (пусто)");
        } else {
            System.out.println("Список контактов:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    public void searchContact() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();

        List<Contact> result = (List<Contact>) contactService.searchContacts(name);
        if (result.isEmpty()) {
            System.out.println("Результаты поиска: (нет совпадений)");
        } else {
            System.out.println("Результаты поиска:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((i + 1) + ". " + result.get(i));
            }
        }
    }

    public void removeContact() {
        System.out.print("Введите номер контакта для удаления: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline

        contactService.removeContact(index - 1);
        System.out.println("Контакт успешно удален.");
    }
}
