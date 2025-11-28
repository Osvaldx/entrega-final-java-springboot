package com.osvaldx.demo.Contact.service;

import com.osvaldx.demo.Contact.enums.ContactCategory;
import com.osvaldx.demo.Contact.model.Contact;
import com.osvaldx.demo.Contact.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> findContactsByCategory(ContactCategory category) {
        return contactRepository.findContactsByCategory(category);
    }

    @Override
    public List<Contact> findContactByPhone(String phone) {
        return contactRepository.findByPhone(phone);
    }

    @Override
    public List<Contact> findContactByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    @Override
    public List<Contact> findContactByFistnameContaining(String text) {
        return contactRepository.findByFirstnameContaining(text);
    }

    @Override
    public Contact updateContact(Long id ,Contact contact) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
