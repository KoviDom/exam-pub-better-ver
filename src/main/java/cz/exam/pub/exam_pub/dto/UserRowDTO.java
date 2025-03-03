package cz.exam.pub.exam_pub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRowDTO {

    @JsonProperty("_id")
    private Long id;

    private String name;

    private boolean isActive;

    private boolean isAdult;

    private double pocket;

    //todo orders

}
