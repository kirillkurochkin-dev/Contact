package contact.impl;

import contact.Contact;

import java.util.ArrayList;
import java.util.List;

class ContactServiceInMemory {
    private final List<Contact> contacts;

    public ContactServiceInMemory(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Iterable<Contact> getContacts() {
        return contacts;
    }

    public Iterable<Contact> searchContacts(String name) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name) || contact.getSurname().equalsIgnoreCase(name)) {
                result.add(contact);
            }
        }
        return result;
    }

    public void removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }
}
