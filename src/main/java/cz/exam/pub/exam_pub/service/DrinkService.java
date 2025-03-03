package cz.exam.pub.exam_pub.service;

import cz.exam.pub.exam_pub.dto.DrinkDTO;
import cz.exam.pub.exam_pub.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkService{

    private final DrinkRepository drinkRepository;

    public List<DrinkDTO> drinkMenu() {
        return drinkRepository.findAll()
                .stream()
                .map(entity -> {
                    DrinkDTO dto = new DrinkDTO();

                    dto.setId(entity.getId());
                    dto.setProductName(entity.getName());
                    dto.setPrice(entity.getPrice());
                    dto.setForAdult(entity.isForAdult());

                    return dto;
                })
                .collect(Collectors.toList());
    }
}
