package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contact {

    private String name;
    private String surname;
    private String phoneNumber;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    public void setPhoneNumber(String newPhone) {
       if (!validatePhone(newPhone)) {
           this.phoneNumber = "[no number]";
           throw new IllegalArgumentException("Invalid phone number");
       }

       this.phoneNumber = newPhone;
    }

    public boolean hasNumber() {
        return !this.phoneNumber.equals("[no number]");
    }

    private boolean validatePhone(String phone) {
        List<String> regexes = new ArrayList<>();
        regexes.add("\\d+");
        regexes.add("\\+?\\([a-zA-Z0-9]{2,}\\)");
        regexes.add("\\+\\d{1,2}(\\s|-)([a-zA-Z0-9]{2,4}(\\s|-)?){1,4}");
        regexes.add("([a-zA-Z0-9]{2,4}(\\s|-)?){2,4}");
        regexes.add("((\\([a-zA-Z0-9]{2,4}\\)(\\s|-)?)){1}(([a-zA-Z0-9]){2,4}(\\s|-)?){1,3}");
        regexes.add("(([a-zA-Z0-9]){2,4}(\\s|-)?){1}((\\([a-zA-Z0-9]{2,4}\\)(\\s|-)?)){1}(([a-zA-Z0-9]){2,4}(\\s|-)?){0,2}");

        return regexes.stream().anyMatch(phone::matches);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact record = (Contact) o;
        return Objects.equals(name, record.name) && Objects.equals(surname, record.surname) && Objects.equals(phoneNumber, record.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phoneNumber);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", this.name, this.surname, this.phoneNumber);
    }
}
