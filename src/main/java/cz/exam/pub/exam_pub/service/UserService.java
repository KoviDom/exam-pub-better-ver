package cz.exam.pub.exam_pub.service;


import cz.exam.pub.exam_pub.dto.UserDTO;
import cz.exam.pub.exam_pub.dto.UserOrderDTO;
import cz.exam.pub.exam_pub.dto.UserRowDTO;
import cz.exam.pub.exam_pub.entity.UserEntity;
import cz.exam.pub.exam_pub.repository.OrderRepository;
import cz.exam.pub.exam_pub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;


    public List<UserRowDTO> allUsers() {
        return userRepository.findAll()
                .stream()
                .map(entity -> {
                            UserRowDTO dto = new UserRowDTO();

                            dto.setId(entity.getId());
                            dto.setName(entity.getName());
                            dto.setActive(entity.isActive());
                            dto.setPocket(entity.getPocket());

                            return dto;
                        }
                )
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {

        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User is not found with id: " + id));
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setActive(entity.isActive());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setPocket(entity.getPocket());

        List<UserOrderDTO> ordersRepository = orderRepository.findByUserId(entity.getId())
                .stream()
                .map(order -> {
                    UserOrderDTO orderDto = new UserOrderDTO();
                    orderDto.setProductName(order.getDrink().getName());
                    return orderDto;
                }).toList();

        List<UserOrderDTO> ordersMapping = entity.getOrders()
                .stream()
                .map(order -> {
                    UserOrderDTO orderDto = new UserOrderDTO();
                    orderDto.setProductName(order.getDrink().getName());
                    return orderDto;
                }).toList();


        dto.setOrdersRepository(ordersRepository);
        dto.setOrdersMapping(ordersMapping);

        return dto;
    }
}
