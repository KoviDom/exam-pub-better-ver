package cz.exam.pub.exam_pub.service;

import cz.exam.pub.exam_pub.dto.OrderDTO;
import cz.exam.pub.exam_pub.dto.OrderPayload;
import cz.exam.pub.exam_pub.entity.DrinkEntity;
import cz.exam.pub.exam_pub.entity.OrderEntity;
import cz.exam.pub.exam_pub.entity.UserEntity;
import cz.exam.pub.exam_pub.repository.DrinkRepository;
import cz.exam.pub.exam_pub.repository.OrderRepository;
import cz.exam.pub.exam_pub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class OrderService{

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final DrinkRepository drinkRepository;

    public OrderDTO buyDrink(OrderPayload payload) {

        UserEntity user = userRepository.findById(payload.getUserId())
                .orElseThrow(() -> new RuntimeException("User is not found"));

        DrinkEntity drink = drinkRepository.findById(payload.getDrinkId())
                .orElseThrow(() -> new RuntimeException("Drink is not found"));

        if (user.getPocket() < drink.getPrice()) {
            throw new RuntimeException("You can not buy, not enough money");
        }

        LocalDate today = LocalDate.now();
        Period p = Period.between(user.getDateOfBirth(), today);
        if (p.getYears() < 18 && drink.isForAdult()) {
            throw new RuntimeException("You are not adult");
        }

        OrderEntity order = new OrderEntity();

        order.setAmount(1);
        order.setPrice(drink.getPrice());
        order.setUser(user);
        order.setDrink(drink);

        order = orderRepository.save(order);

        //zaplatit
        user.setPocket(user.getPocket() - drink.getPrice());

        user = userRepository.save(user);

        return null;
    }

}
