package com.osvaldx.demo.Contact.service;

import com.osvaldx.demo.Contact.enums.ContactCategory;
import com.osvaldx.demo.Contact.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    Contact createContact(Contact contact);
    List<Contact> findAllContacts();
    Optional<Contact> findContactById(Long id);
    List<Contact> findContactsByCategory(ContactCategory category);
    Optional<Contact> findContactByPhone(String phone);
    Optional<Contact> findContactByEmail(String email);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);

}
