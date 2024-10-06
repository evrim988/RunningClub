package org.example.webdemoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.webdemoproject.models.Club;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    Long id;
    String name;
    @DateTimeFormat(pattern = "yyy-MM-dd'T'HH:mm")
    LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyy-MM-dd'T'HH:mm")
    LocalDateTime endTime;
    String type;
    String photoUrl;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    Club club;
}
