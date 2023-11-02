package com.bounteous.cfToJava.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String username;
    private String password;
    private String passwordSalt;
    private Boolean isActive;
    private Date dateCreated;
    private Date dateLastModified;

    public boolean isEmpty() {
        return (pkId == null);
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
