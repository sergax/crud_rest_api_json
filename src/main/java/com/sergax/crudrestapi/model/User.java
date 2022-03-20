package com.sergax.crudrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;
//
//    @Column(name = "password")
//    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user")
    @JoinColumn(name = "user_id")
    private List<Event> eventList;
}
