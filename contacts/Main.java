package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        System.out.print("[menu] Enter action (add, list, search, count, exit): ");
        String input = scanner.nextLine();

        while (!input.equals("exit")) {

            switch (input) {
                case "add" -> phoneBook.addRecord();
                case "list" -> phoneBook.listRecords();
                case "search" -> phoneBook.search();
                case "count" -> phoneBook.count();
            }

            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            input = scanner.nextLine();
        }

    }
}
