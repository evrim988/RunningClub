package org.example.webdemoproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String type;
    String photoUrl;

    @CreationTimestamp
    LocalDateTime createdOn;

    @CreationTimestamp
    LocalDateTime updatedOn;

    @ManyToOne
    Club club;
}
