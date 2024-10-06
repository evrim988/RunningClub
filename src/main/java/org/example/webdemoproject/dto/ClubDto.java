package org.example.webdemoproject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubDto {
    Long id;
    @NotEmpty(message = "Club title should not be empty")
    String title;
    @NotEmpty(message = "Photo link should not be empty")
    String photoUrl;
    @NotEmpty(message = "Club content should not be empty")
    String content;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    List<EventDto> events;
}
