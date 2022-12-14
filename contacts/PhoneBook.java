package contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private final List<Contact> contacts;
    private final Scanner scanner;
    private final boolean saveToFile;
    private final String fileName;

    public PhoneBook(String fileName) throws IOException, ClassNotFoundException {
        this.scanner = new Scanner(System.in);

        if (!(fileName == null || fileName.isEmpty())) {
            this.contacts = (List<Contact>) SerializationUtils.deserialize(fileName);
            this.saveToFile = true;
            this.fileName = fileName;
        } else {
            this.contacts = new ArrayList<>();
            this.saveToFile = false;
            this.fileName = "";
        }
    }

    public void addRecord() throws IOException {

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

        System.out.println("The record added.");
        if (this.saveToFile) {
            SerializationUtils.serialize(this.contacts, fileName);
        }
    }

    public void listRecords() throws IOException {

        System.out.println(this.list());
        System.out.print("\n[list] Enter action ([number], back): ");
        String option = this.scanner.nextLine();

        if (!"back".equals(option)) {
            int record = Integer.parseInt(option);
            this.info(record);
        }
    }

    public void search() throws IOException {

        String option = "again";

        while (!"back".equals(option)) {

            if ("again".equals(option)) {
                System.out.print("Enter search query: ");
                String searchQuery = scanner.nextLine();

                List<Contact> queryResults = this.contacts.stream()
                        .filter(contact -> contact.toString().toLowerCase().contains(searchQuery))
                        .toList();

                System.out.println("Found " + queryResults.size() + " results:");
                for (int i = 0; i < queryResults.size(); i++) {
                    System.out.println((i + 1) + ". " + queryResults.get(i).getWholeName());
                }

            } else if (option.matches("\\d+")) {
                int record = Integer.parseInt(option);
                this.info(record);
                return;
            }

            System.out.print("[search] Enter action ([number], back, again): ");
            option = scanner.nextLine();
        }

    }

    public void count() {
        System.out.println("The Phone Book has " + this.contacts.size() + " records.\n");
    }

    private void removeRecord(int record) throws IOException {

        if (this.contacts.isEmpty()) {
            System.out.println("No records to remove!\n");
            return;
        }

        this.contacts.remove(record);

        System.out.println("The record removed!\n");

        if (this.saveToFile) {
            SerializationUtils.serialize(this.contacts, this.fileName);
        }
    }

    private void edit(int record) throws IOException {

        if (this.contacts.isEmpty()) {
            System.out.println("No records to edit!\n");
            return;
        }

        Contact contact = this.contacts.get(record);

        System.out.printf("Select a field (%s): ", contact.listFields());
        String field = this.scanner.nextLine();
        System.out.print("Enter " + field + ": ");
        String newValue = scanner.nextLine();

        contact.editField(field, newValue);

        System.out.println("Saved");
        System.out.println(contact);

        if (this.saveToFile) {
            SerializationUtils.serialize(this.contacts, fileName);
        }

    }

    private void info(int record) throws IOException {

        Contact contact = this.contacts.get(record - 1);
        System.out.println(contact.toString() + "\n");

        System.out.print("[record] Enter action (edit, delete, menu): ");
        String option = scanner.nextLine();

        switch (option) {
            case "menu":
                return;
            case "edit":
                this.edit(record - 1);
                break;
            case "delete":
                this.removeRecord(record - 1);
                break;
            default:
        }
    }

    private String list() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact c = this.contacts.get(i);
            sb.append(i + 1).append(". ").append(c.getWholeName()).append("\n");
        }
        return sb.toString().trim();
    }
}
