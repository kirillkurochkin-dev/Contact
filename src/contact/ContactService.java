package contact;
public interface ContactService {
    void addContact(Contact contact);
    Iterable<Contact> getContacts();
    Iterable<Contact> searchContacts(String name);
    void removeContact(int index);
}
