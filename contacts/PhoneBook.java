package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private final List<Contact> contacts;
    private final Scanner scanner;

    public PhoneBook() {
        this.contacts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addRecord() {

        Contact contact = new Contact(null, null, null);

        System.out.println("Enter the name:");
        String name = this.scanner.nextLine();

        System.out.println("Enter the surname:");
        String surname = this.scanner.nextLine();

        System.out.println("Enter the number:");
        String number = this.scanner.nextLine();

        contact.setName(name);
        contact.setSurname(surname);

        try {
            contact.setPhoneNumber(number);
        } catch (IllegalArgumentException iae) {
            System.out.println("Wrong number format!");
        }

        this.contacts.add(contact);

        System.out.println("The record added.");
    }

    public void removeRecord() {

        this.list();
        int record = this.scanner.nextInt();
        this.contacts.remove(record);

        System.out.println("The record removed!");
    }

    public void count() {
        System.out.println("The Phone Book has " + this.contacts.size() + " records.");
    }

    public void edit() {
        if (this.contacts.isEmpty()) {
            System.out.println("No records to edit!");
            return;
        }

        System.out.println("Select a record:");
        this.list();
        int record = this.scanner.nextInt();
        System.out.println("Select a field (name, surname, number):");
        String field = this.scanner.nextLine();
        System.out.println("Enter " + field + ":");
        String newValue = this.scanner.nextLine();

        Contact contact = this.contacts.get(record - 1);

        switch (field) {
            case "name":
                contact.setName(newValue);
                break;
            case "surname":
                contact.setSurname(newValue);
                break;
            case "number":
                try {
                    contact.setPhoneNumber(newValue);
                } catch (IllegalArgumentException iae) {
                    System.out.println("Wrong number format!");
                }
                break;
        }

        System.out.println("The record updated!");

    }

    public void list() {
        for (int i = 0; i < this.contacts.size(); i++) {
            System.out.println((i + 1) + ". " + this.contacts.get(i).toString());
        }
    }
}
