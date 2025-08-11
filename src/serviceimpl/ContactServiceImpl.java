package serviceimpl;

import dao.FileDao;
import model.Contact;
import service.ContactService;

import java.util.List;
import java.util.UUID;

public class ContactServiceImpl implements ContactService {


    private FileDao fileDao;

    public ContactServiceImpl( FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public void saveContact(Contact contact) {
        fileDao.saveFile(contact);
    }

    @Override
    public void updateContact(Contact contact) {
          fileDao.update(contact);
    }

    @Override
    public void deleteContact(UUID id) {
           fileDao.delete(id);
    }

    @Override
    public List<Contact> listContacts() {
        return fileDao.list();
    }
}
