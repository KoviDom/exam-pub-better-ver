package cz.exam.pub.exam_pub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @JsonProperty("_id")
    private Long id;

    private String name;

    private boolean isActive;

    private LocalDate dateOfBirth;

    private double pocket;

    List<UserOrderDTO> ordersRepository;

    List<UserOrderDTO> ordersMapping;


}
