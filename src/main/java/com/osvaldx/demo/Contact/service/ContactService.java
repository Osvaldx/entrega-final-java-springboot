package com.osvaldx.demo.Contact.service;

import com.osvaldx.demo.Contact.enums.ContactCategory;
import com.osvaldx.demo.Contact.model.Contact;

import java.util.List;

public interface ContactService {

    Contact createContact(Contact contact);
    List<Contact> findAllContacts();
    List<Contact> findContactsByCategory(ContactCategory category);
    List<Contact> findContactByPhone(String phone);
    List<Contact> findContactByEmail(String email);
    List<Contact> findContactByFistnameContaining(String text);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);

}
