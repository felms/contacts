package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {

    private final List<Record> records;
    private final Scanner scanner;

    public Contacts() {
        this.records = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addRecord() {

        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine();

        System.out.println("Enter the surname of the person:");
        String surname = scanner.nextLine();

        System.out.println("Enter the number:");
        String number = scanner.nextLine();

        records.add(new Record(name, surname, number));

        System.out.println("A record created!\nA Phone Book with a single record created!");
    }
}
