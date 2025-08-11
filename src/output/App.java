package output;

import dao.FileDao;
import model.Contact;
import service.ContactService;
import serviceimpl.ContactServiceImpl;

import java.util.List;

public class App {

    ContactService contactService= new ContactServiceImpl(new FileDao());

    private void showMenu() {
        System.out.println("Welcome to Contact Management");
        System.out.println("1. Add Contact");
        System.out.println("2. Update Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. List Contacts");
        System.out.println("5. Exit");
        showMenuOption(1);


    }

     private void showListContact(){
         List<Contact> contacts = contactService.listContacts();
           for (Contact contact : contacts) {
               System.out.println("Id       : "+contact.getId());
               System.out.println("Name     : "+contact.getName());
               System.out.println("Email    : "+contact.getEmail());

           }
     }


     void showMenuOption(int option) {
         switch (option) {
             case 1:
                 System.out.println("Enter Name");
                 String name = System.console().readLine();
                 System.out.println("Enter Email");
                 String email = System.console().readLine();
                 System.out.println("Enter Phone");
                 String phone = System.console().readLine();
                 contactService.saveContact(new Contact(name, email, phone));
         }
     }


     public void start(){
        showMenu();;
     }

}
