package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompanyContact extends Contact{

    private String organizationName;
    private String address;

    public CompanyContact(String organizationName, String address, String phoneNumber) {
        super(phoneNumber, false);
        this.organizationName = organizationName;
        this.address = address;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        this.lastEdit = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.lastEdit = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Organization name: " + this.organizationName
                + "\nAddress: " + this.address
                + "\nNumber: " + this.phoneNumber
                + "\nTime created: " + this.dateCreated.format(DateTimeFormatter.ISO_DATE_TIME).toString()
                + "\nTime last edit: " + this.lastEdit.format(DateTimeFormatter.ISO_DATE_TIME).toString();
    }
}
