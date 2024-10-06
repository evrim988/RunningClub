package org.example.webdemoproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String photoUrl;
    String content;

    @CreationTimestamp
    LocalDateTime createdOn;

    @UpdateTimestamp
    LocalDateTime updatedOn;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    List<Event> events;
}
