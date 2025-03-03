package cz.exam.pub.exam_pub.controller;

import cz.exam.pub.exam_pub.dto.OrderDTO;
import cz.exam.pub.exam_pub.dto.OrderPayload;
import cz.exam.pub.exam_pub.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/buy")
    public OrderDTO buyDrink(@RequestBody OrderPayload payload) {
        return orderService.buyDrink(payload);
    }

}
