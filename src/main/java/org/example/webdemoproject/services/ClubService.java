package org.example.webdemoproject.services;

import org.example.webdemoproject.dto.ClubDto;
import org.example.webdemoproject.models.Club;

import java.util.List;


public interface ClubService {

    /**
     * Tüm klupleri listele
     */
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto clubDto);

    void delete(Long clubId);

    List<ClubDto> searchClubs(String query);
}
