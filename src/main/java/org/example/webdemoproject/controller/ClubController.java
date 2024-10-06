package org.example.webdemoproject.controller;

import jakarta.validation.Valid;
import org.example.webdemoproject.dto.ClubDto;
import org.example.webdemoproject.models.Club;
import org.example.webdemoproject.services.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    /**
     * tüm klupleri listeler.
     */
    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDto> clubList = clubService.findAllClubs();
        model.addAttribute("clubList", clubList);
        return "clubs-list";
    }

    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") long clubId, Model model) {
        ClubDto clubDto = clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-detail";
    }

    /**
     *  kaydetme sayfasına yönlendirir.
     */
    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId, Model model) {
        clubService.delete(clubId);
        return "redirect:/clubs"; //TODO: sadece yöneticiler silecek o yüzden tekrar buraya bakılacak.
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model) {
        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    /**
     * bir üstteki metodda açılan sayfada kaydet butonuna basıldığında bu metod çalışır.
     */
    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("club", clubDto);
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs"; //kaydettikten sonra club sayfasına geri dön.
    }

    /**
     * düzenleme sayfasına gider.
     */
    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") Long clubId, Model model){
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    /**
     * düzenlemeyi kaydete basıldığında butondan bu metoda gelir. ve güncelleme işlemini yapar.
     */
    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId,
                             @Valid @ModelAttribute("club") ClubDto clubDto,
                             BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("club", clubDto);
            return "clubs-edit";
        }
        clubDto.setId(clubId);
        clubService.updateClub(clubDto);
        return "redirect:/clubs";
    }
}
/**
 * Model: Controller içinde işlenen verilerin view (görünüm) katmanına taşınmasında kullanılır.
 * Veriler, model içerisine konularak HTML şablonlarına aktarılır
 * ve şablon motorları tarafından sayfa üzerinde kullanılabilir.
 *
 * model.addAttribute("club", clubDto): Bu satırda, clubDto nesnesini "club" ismiyle modele ekliyorsun.
 * Bu işlem, veriyi view katmanına taşımanı sağlar.
 * Böylece clubs-create sayfasında (muhtemelen bir HTML şablonu) "club" ismiyle clubDto nesnesine erişip,
 * onun verilerini gösterebilirsin veya sayfa üzerinde bir formda düzenlenmesine olanak tanıyabilirsin.
 */