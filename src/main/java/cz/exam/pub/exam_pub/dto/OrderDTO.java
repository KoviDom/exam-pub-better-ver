package cz.exam.pub.exam_pub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.exam.pub.exam_pub.entity.DrinkEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @JsonProperty("_id")
    private Long id;

    private DrinkEntity drinkEntity;

    private int amount;

    private double price;

}
