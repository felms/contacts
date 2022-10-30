package contacts;

public enum Gender {
    MALE ("M"),
    FEMALE ("F"),
    NO_DATA("[no data]");

    private final String label;
    Gender(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
