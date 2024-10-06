package org.example.webdemoproject.services.impl;

import org.example.webdemoproject.dto.ClubDto;
import org.example.webdemoproject.models.Club;
import org.example.webdemoproject.repository.ClubRepository;
import org.example.webdemoproject.services.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.webdemoproject.mapper.ClubMapper.mapToClubDto;
import static org.example.webdemoproject.mapper.ClubMapper.maptoClub;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubList = clubRepository.findAll();
        return clubList.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = maptoClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club); //dto yu doldurmak gerekiyordu alt kısımda olan metodu çağırdığımızda işimiz çözülür.
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = maptoClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }


}
/**
 * clubList.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
 * burada map() fonksiyonunu kullanarak, her bir Club nesnesini bir ClubDto nesnesine dönüştürüyorsun.
 * Bu dönüşüm işlemi DTO (Data Transfer Object) tasarım deseni kapsamında,
 * veri transferi sırasında model ve DTO nesneleri arasında veri uyumunu sağlamak için yapılır.
 */