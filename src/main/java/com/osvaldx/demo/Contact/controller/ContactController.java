package com.osvaldx.demo.Contact.controller;

import com.osvaldx.demo.Contact.enums.ContactCategory;
import com.osvaldx.demo.Contact.model.Contact;
import com.osvaldx.demo.Contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(params = "phone")
    public ResponseEntity<Contact> findContactByPhone(@RequestParam String phone) {
        return this.contactService.findContactByPhone(phone)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(params = "email")
    public ResponseEntity<Contact> findContactByEmail(@RequestParam String email) {
        return this.contactService.findContactByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(params = "category")
    public List<Contact> findContactsByCategory(@RequestParam ContactCategory category) {
        return this.contactService.findContactsByCategory(category);
    }

    @PostMapping
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        Contact contactCreated = this.contactService.createContact(contact);
        return ResponseEntity.ok(contactCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return this.contactService.findContactById(id)
                .map(contactFound -> {
                    Contact contactUpdated = this.contactService.updateContact(id, contact);
                    return ResponseEntity.ok(contactUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (this.contactService.findContactById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        this.contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

}
