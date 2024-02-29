import console.ConsoleService;
import console.ConsoleUI;
import contact.impl.ContactServiceInMemory;
import validation.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactServiceInMemory contactServiceInMemory = new ContactServiceInMemory(new ArrayList<>());
        ConsoleService consoleService = new ConsoleService(contactServiceInMemory, scanner, new Validator(scanner));
        ConsoleUI consoleUI = new ConsoleUI(scanner, consoleService);
        consoleUI.start();
    }
}