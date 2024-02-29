package console;

// Бизнес логика работы консоли

import contact.Contact;
import contact.ContactService;
import exception.ValidationException;
import validation.Validator;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private final ContactService contactService;
    private final Scanner scanner;
    private final Validator validator;

    public ConsoleService(ContactService contactService, Scanner scanner, Validator validator) {
        this.contactService = contactService;
        this.scanner = scanner;
        this.validator = validator;
    }

    public void addContact() {

        try {
            System.out.print("Введите имя контакта: ");
            String name = validator.readNonEmptyString();
            System.out.print("Введите фамилию контакта: ");
            String surname = validator.readNonEmptyString();
            System.out.print("Введите номер телефона: ");
            String phone = validator.readPhoneNumber();
            System.out.print("Введите адрес электронной почты: ");
            String email = validator.readEmail();

            Contact contact = new Contact(name, surname, phone, email);
            contactService.addContact(contact);
            System.out.println("Контакт успешно добавлен.");
        } catch (ValidationException e) {
            System.out.println("Произошла ошибка при добавлении контакта. Проверьте введенные данные.");
        }

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
