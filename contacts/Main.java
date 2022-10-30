package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
        String input = scanner.nextLine();

        while (!input.equals("exit")) {

            switch (input) {
                case "add" -> phoneBook.addRecord();
                case "remove" -> phoneBook.removeRecord();
                case "edit" -> phoneBook.edit();
                case "count" -> phoneBook.count();
                case "info" -> phoneBook.info();
            }

            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            input = scanner.nextLine();
        }

    }
}
