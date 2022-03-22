package com.sergax.crudrestapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_name")
    private String fileName;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    @Column(name = "created")
//    @EqualsAndHashCode.Exclude
//    private LocalDate created;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
            mappedBy = "file")
    private List<Event> eventList;

    public File(String fileName) {
        this.fileName = fileName;
//        this.created = LocalDate.now();
    }

    public File(Long id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }
}
