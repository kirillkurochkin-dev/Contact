package validation;

import exception.ValidationException;

import java.util.Scanner;

// Для валидации можно было бы использовать jakarta.validation
public class Validator {

    private final Scanner scanner;

    public Validator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readNonEmptyString() throws ValidationException {
        String input;
        input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            throw new ValidationException("Name");
        }
        return input;
    }

    public String readPhoneNumber() throws ValidationException {
        String input;
        input = scanner.nextLine().trim();
        if (!input.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new ValidationException("Phone");
        }
        return input;
    }

    public String readEmail() throws ValidationException {
        String input;
        input = scanner.nextLine().trim();
        if (!input.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new ValidationException("Mail");
        }
        return input;
    }
}
