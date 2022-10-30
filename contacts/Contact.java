package contacts;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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

       this.phoneNumber = newPhone;
       this.lastEdit = LocalDateTime.now();
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
