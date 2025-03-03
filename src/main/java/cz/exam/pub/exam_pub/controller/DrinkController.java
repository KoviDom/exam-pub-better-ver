package cz.exam.pub.exam_pub.controller;

import cz.exam.pub.exam_pub.dto.DrinkDTO;
import cz.exam.pub.exam_pub.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class DrinkController {

    private final DrinkService drinkService;

    @GetMapping("/drink-menu")
    public List<DrinkDTO> drinkMenu() {
        return drinkService.drinkMenu();
    }

}
