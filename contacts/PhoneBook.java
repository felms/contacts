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

        Contact contact;

        System.out.print("Enter the type (person, organization): ");
        String type = this.scanner.nextLine();

        if ("person".equalsIgnoreCase(type.trim())) {
            System.out.print("Enter the name: ");
            String name = this.scanner.nextLine();

            System.out.print("Enter the surname: ");
            String surname = this.scanner.nextLine();

            System.out.print("Enter the birth date: ");
            String birthDate = this.scanner.nextLine();
            if (birthDate.isEmpty()) {
                System.out.println("Bad birth date!");
            }

            System.out.print("Enter the gender (M, F): ");
            String gender = this.scanner.nextLine();
            if (gender.isEmpty()) {
                System.out.println("Bad gender!");
            }

            System.out.print("Enter the number: ");
            String number = this.scanner.nextLine();

            contact = new PersonContact(name, surname, birthDate, gender, number);

        } else {
            System.out.print("Enter the organization name: ");
            String name = this.scanner.nextLine();

            System.out.print("Enter the address: ");
            String address = this.scanner.nextLine();

            System.out.print("Enter the number: ");
            String number = this.scanner.nextLine();

            contact = new CompanyContact(name, address, number);
        }

        this.contacts.add(contact);

        System.out.println("The record added.\n");
    }

    public void removeRecord() {

        if (this.contacts.isEmpty()) {
            System.out.println("No records to remove!\n");
            return;
        }

        System.out.println(this.list());
        int record = this.scanner.nextInt();
        this.contacts.remove(record - 1);

        System.out.println("The record removed!\n");
    }

    public void count() {
        System.out.println("The Phone Book has " + this.contacts.size() + " records.\n");
    }

    public void edit() {

        if (this.contacts.isEmpty()) {
            System.out.println("No records to edit!\n");
            return;
        }

        System.out.println(this.list());
        System.out.print("Select a record: ");
        int record = Integer.parseInt(this.scanner.nextLine());
        Contact contact = this.contacts.get(record - 1);

        if (contact.isPerson()) {
            System.out.print("Select a field (name, surname, , birth, gender, number): ");
            String field = this.scanner.nextLine();
            System.out.print("Enter " + field + ": ");
            String newValue = "";


            switch (field) {
                case "name":
                    newValue = scanner.nextLine();
                    ((PersonContact)contact).setName(newValue);
                    break;
                case "surname":
                    newValue = scanner.nextLine();
                    ((PersonContact)contact).setSurname(newValue);
                    break;
                case "birth":
                    newValue = scanner.nextLine();
                    ((PersonContact)contact).setBirthDate(newValue);
                    break;
                case "gender":
                    newValue = scanner.nextLine();
                    ((PersonContact)contact).setGender(newValue);
                    break;
                case "number":
                    try {
                        newValue = scanner.nextLine();
                        contact.setPhoneNumber(newValue);
                    } catch (IllegalArgumentException iae) {
                        System.out.print("Wrong number format!");
                    }
                    break;
            }

        } else {

            System.out.print("Select a field (address, number): ");
            String field = this.scanner.nextLine();
            System.out.print("Enter " + field + ": ");
            String newValue = "";


            switch (field) {
                case "address":
                    newValue = scanner.nextLine();
                    ((CompanyContact)contact).setAddress(newValue);
                    break;
                case "number":
                    try {
                        newValue = scanner.nextLine();
                        contact.setPhoneNumber(newValue);
                    } catch (IllegalArgumentException iae) {
                        System.out.print("Wrong number format!");
                    }
                    break;
            }
        }

        System.out.println("The record updated!\n");

    }

    public void info() {

        System.out.println(this.list());

        System.out.print("Enter index to show info: ");
        int record = this.scanner.nextInt();
        Contact contact = this.contacts.get(record - 1);
        System.out.println(contact.toString() + "\n");

    }

    private String list() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact c = this.contacts.get(i);
            String r = "";
            if (c.isPerson()) {
                r = (i + 1) + ". " + ((PersonContact)c).getWholeName();
            } else {
                r = (i + 1) + ". " + ((CompanyContact)c).getOrganizationName();
            }
            sb.append(r).append("\n");
        }
        return sb.toString().trim();
    }


}
