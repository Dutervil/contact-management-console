import dao.FileDao;
import service.ContactService;
import serviceimpl.ContactServiceImpl;

import java.io.IOException;


import static utils.AppUtils.initializeFile;
public class Main {
    public static void main(String[] args) throws IOException {

        initializeFile();
        ContactService contactService= new ContactServiceImpl(new FileDao());
//        Contact contact = new Contact("Dutervil Wadspn", "dwadson3@gmail.com", "0612345678");
//        contactService.saveContact(contact);

//        contactService.listContacts().forEach(System.out::println);
//        contactService.deleteContact(UUID.fromString("6eaccc03-38ca-474f-92c0-9933c0f5528f"));

    }
}