package org.example.webdemoproject.repository;

import org.example.webdemoproject.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {

    /**
     *  başlığa göre bul ve getir.
     */
    Optional<Club> findByTitle(String title);

    /**
     * arama yapılırken girilen başlık değeri içeriyorsa şeklinde bir arama yapar.
     */
    @Query("SELECT c FROM Club c WHERE c.title LIKE CONCAT('%', :query, '%') ")
    List<Club> searchClubs(String query);

}
