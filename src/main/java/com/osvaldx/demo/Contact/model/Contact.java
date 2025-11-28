package com.osvaldx.demo.Contact.model;

import com.osvaldx.demo.Contact.enums.ContactCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity // Indica que esta clase es una entidad JPA
@Table(name = "contacts") // Mapea a la tabla contacts
public class Contact {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    private String firstname;

    @Column(nullable = true)
    private String lastname;

    private String email;
    private String phone;
    private ContactCategory category;

    public Contact() {};

    public Contact(Long id, String firstname, String lastname, String email, String phone, ContactCategory category) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.category = category;
    }

}
