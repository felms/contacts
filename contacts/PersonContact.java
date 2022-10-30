package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonContact extends Contact{

    private String name;
    private String surname;

    private LocalDateTime birthDate;

    private Gender gender;

    public PersonContact(String name, String surname, String birthDate, String gender, String phoneNumber) {
        super(phoneNumber, true);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate == null || birthDate.isEmpty() ? LocalDateTime.MIN : LocalDateTime.parse(birthDate);
        this.gender = gender == null || gender.isEmpty() ? Gender.NO_DATA
                : gender.equals("M") ? Gender.MALE
                : Gender.FEMALE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.lastEdit = LocalDateTime.now();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        this.lastEdit = LocalDateTime.now();
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate == null || birthDate.isEmpty() ? LocalDateTime.MIN : LocalDateTime.parse(birthDate);
        this.lastEdit = LocalDateTime.now();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? Gender.NO_DATA
                : gender.equals("M") ? Gender.MALE
                : Gender.FEMALE;

        this.lastEdit = LocalDateTime.now();
    }

    public String getWholeName() {
        return this.name + " " + this.surname;
    }

    @Override
    public String toString() {
       return "Name: " + this.name
              + "\nSurname: " + this.surname
              + "\nBirth date: " + (this.birthDate == LocalDateTime.MIN ? "[no data]" : this.birthDate.toString())
              + "\nGender: " + this.gender
              + "\nNumber: " + this.phoneNumber
              + "\nTime created: " + this.dateCreated.format(DateTimeFormatter.ISO_DATE_TIME).toString()
              + "\nTime last edit: " + this.lastEdit.format(DateTimeFormatter.ISO_DATE_TIME).toString();
    }
}
