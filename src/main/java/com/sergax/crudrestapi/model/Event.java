package com.sergax.crudrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_name")
    private String eventName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File file;

    public Event(String eventName, User user, File file) {
        this.eventName = eventName;
        this.user = user;
        this.file = file;
    }

    public Event(Long id, String eventName, User user, File file) {
        this.id = id;
        this.eventName = eventName;
        this.user = user;
        this.file = file;
    }
}
