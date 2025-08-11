package serviceimpl;

import dao.MysqlDao;
import model.Contact;
import service.ContactService;

import java.util.List;
import java.util.UUID;

public class ContactMysqlServiceImpl  implements ContactService {

    private MysqlDao mysqlDao;

    @Override
    public void saveContact(Contact contact) {

    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void deleteContact(UUID id) {

    }

    @Override
    public List<Contact> listContacts() {
        return List.of();
    }
}
