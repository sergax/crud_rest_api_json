package com.sergax.crudrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created")
    @EqualsAndHashCode.Exclude
    private LocalDate created;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "file")
    @JoinColumn(name = "file_id")
    private List<Event> eventList;

    public File(String fileName, LocalDate created) {
        this.fileName = fileName;
        this.created = LocalDate.now();
    }

    public File(Long id, String fileName, LocalDate created) {
        this.id = id;
        this.fileName = fileName;
        this.created = LocalDate.now();
    }
}
