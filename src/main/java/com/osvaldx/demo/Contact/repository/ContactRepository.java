package com.osvaldx.demo.Contact.repository;

import com.osvaldx.demo.Contact.enums.ContactCategory;
import com.osvaldx.demo.Contact.model.Contact;
// Importamos JpaRepository, que nos da los métodos CRUD listos
import org.springframework.data.jpa.repository.JpaRepository;
// Importamos la anotación @Repository que marca esta interfaz como componente de acceso a datos
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findContactsByCategory(ContactCategory category);
    List<Contact> findByPhone(String phone);
    List<Contact> findByEmail(String email);
    List<Contact> findByFirstnameContaining(String text);

}
