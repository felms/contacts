package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
        String input = scanner.nextLine();

        while (!input.equals("exit")) {

            switch (input) {
                case "add" -> phoneBook.addRecord();
                case "remove" -> phoneBook.removeRecord();
                case "edit" -> phoneBook.edit();
                case "count" -> phoneBook.count();
                case "list" -> phoneBook.list();
            }

            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            input = scanner.nextLine();
        }

    }
}
