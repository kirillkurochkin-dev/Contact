package contact;

import person.Person;

public class Contact extends Person {
    private String phone;
    private String email;

    public Contact(String name, String surname, String phone, String email) {
        super(name, surname);
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " " + surname + " - " + phone + " - " + email;
    }
}