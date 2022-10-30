package contacts;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Contact implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected String phoneNumber;
    protected LocalDateTime dateCreated;
    protected LocalDateTime lastEdit;
    public Contact(String phoneNumber) {

        this.phoneNumber = phoneNumber;
        this.dateCreated = LocalDateTime.now();
        this.lastEdit = LocalDateTime.now();
    }

    public abstract String listFields();
    public abstract void editField(String fieldName, String newValue);

    public abstract String getWholeName();

    public void setPhoneNumber(String newPhone) {
       //if (!validatePhone(newPhone)) {
       //    this.phoneNumber = "[no number]";
       //    throw new IllegalArgumentException("Invalid phone number");
       //}

       this.phoneNumber = newPhone;
       this.lastEdit = LocalDateTime.now();
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
        Contact contact = (Contact) o;
        return phoneNumber.equals(contact.phoneNumber) && dateCreated.equals(contact.dateCreated) && lastEdit.equals(contact.lastEdit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, dateCreated, lastEdit);
    }

}
