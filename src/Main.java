import console.ConsoleService;
import console.ConsoleUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI(new Scanner(System.in), new ConsoleService());
        consoleUI.start();
    }
}