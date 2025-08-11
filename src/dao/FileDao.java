package dao;

import exception.AppException;
import model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static constant.AppConstant.FILE_PATH;

public class FileDao {


    public void saveFile(Contact contact) {
        try {
            Contact contactToSave = new Contact(contact.getName(), contact.getEmail(), contact.getPhone());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(contactToSave.toString());
                writer.newLine();
            }
            System.out.println("Contact ajouté avec succès : " + contactToSave.getName());
        } catch (IOException e) {
            throw new AppException("error creating file");
        }
    }
    public List<Contact> list() {
        List<Contact> contacts = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            throw new AppException("File not found");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] contactsArr = line.split(";");
                if (contactsArr.length == 4) {
                    try {
                        String id = contactsArr[0];
                        String nom = contactsArr[1];
                        String email = contactsArr[2];
                        String telephone = contactsArr[3];
                        contacts.add(new Contact(UUID.fromString(id), nom, email, telephone));
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur de format dans la ligne : " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return contacts;
    }
    public void update(Contact updatedContact) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        List<Contact> contacts = list();

        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(updatedContact.getId())) {
                contacts.set(i, updatedContact);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("contact With Id " + updatedContact.getId() + " Not found.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Contact c : contacts) {
                writer.write(c.toString());
                writer.newLine();
            }

            System.out.println("contact Updated successfully");

        } catch (IOException e) {
            System.err.println("error updating contact : " + e.getMessage());
        }
    }
    public void delete(UUID id) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }
        List<Contact> contacts = list();
        boolean removed = contacts.removeIf(c -> c.getId().equals(id));
        if (!removed) {
            System.out.println("Contact with ID " + id + " Not found.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.newLine();
            for (Contact c : contacts) {
                writer.write(c.toString());
                writer.newLine();
            }
            System.out.println("Contact deleted successfully");
        } catch (IOException e) {
            System.err.println("Error deleting: " + e.getMessage());
        }
    }

}
