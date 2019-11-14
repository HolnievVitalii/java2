import java.util.Objects;

public class PhoneBook {
    private String surname;
    private long number;

    public PhoneBook(String surname, long number) {
        this.surname = surname;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return number == phoneBook.number &&
                surname.equals(phoneBook.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, number);
    }
}
