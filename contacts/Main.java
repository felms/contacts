package contacts;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        PhoneBook phoneBook;
        if (args.length > 0) {
            String fileName = args[1];
            phoneBook = new PhoneBook(fileName);
        } else {
            phoneBook = new PhoneBook(null);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("[menu] Enter action (add, list, search, count, exit): ");
        String input = scanner.nextLine().trim();

        while (!input.equals("exit")) {

            switch (input) {
                case "add" -> phoneBook.addRecord();
                case "list" -> phoneBook.listRecords();
                case "search" -> phoneBook.search();
                case "count" -> phoneBook.count();
            }

            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
            input = scanner.nextLine().trim();
        }

    }
}
