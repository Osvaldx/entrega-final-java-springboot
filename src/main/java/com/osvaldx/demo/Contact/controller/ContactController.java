package com.osvaldx.demo.Contact.controller;

import com.osvaldx.demo.Contact.model.Contact;
import com.osvaldx.demo.Contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*") // permitir solicitudes desde cualquier origin (CORS)
@RestController // Aclaramos que esta clase es un controlador
@RequestMapping("api/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> findAll() {
        return this.contactService.findAllContacts();
    }

}
