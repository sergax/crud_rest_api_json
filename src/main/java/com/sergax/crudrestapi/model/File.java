package com.sergax.crudrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "file")
    @JoinColumn(name = "file_id")
    private List<Event> eventList;
}
