package contacts;

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
        String phoneRegex = "((\\+[\\d]{0,2})\\s)?"
                            + "((\\()?\\d{3}(\\))\\s)?"
                            + "[a-zA-Z0-9]{3}(\\s|-)"
                            + "[a-zA-Z0-9]{3}(\\s|-)"
                            + "[a-zA-Z0-9]{2,4}";
        return phone.matches(phoneRegex);
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
