package org.example.webdemoproject.mapper;

import org.example.webdemoproject.dto.ClubDto;
import org.example.webdemoproject.models.Club;

import java.util.stream.Collectors;

import static org.example.webdemoproject.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    //entity ile dto eşleştiriyoruz. Geriye entity dönüyor.
    public static Club maptoClub(ClubDto clubDto) {
        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .content(clubDto.getContent())
                .photoUrl(clubDto.getPhotoUrl())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
        return club;
    }


    //dto ile modelimizi(entity) eşleştiriyoruz. Geriye dto dönüyoruz.
    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .photoUrl(club.getPhotoUrl())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((events) -> mapToEventDto(events)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}
