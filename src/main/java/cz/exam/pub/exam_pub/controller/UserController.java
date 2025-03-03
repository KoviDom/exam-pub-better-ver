package cz.exam.pub.exam_pub.controller;

import cz.exam.pub.exam_pub.dto.UserDTO;
import cz.exam.pub.exam_pub.dto.UserRowDTO;
import cz.exam.pub.exam_pub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserRowDTO> allUsers() {
        return userService.allUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO findById(@PathVariable long id) {
        return userService.findById(id);
    }

}
