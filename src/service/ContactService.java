package service;

import model.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactService {

     void saveContact(Contact contact);
     void updateContact(Contact contact);
     void deleteContact(UUID id);
     List<Contact> listContacts();
}
