package board.demo.controller;

import board.demo.dto.UserDto;
import board.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 목록 조회
    @GetMapping
    private List<UserDto> findAllUsers() {
        return this.userService.getAllUser();
    }

    // 회원 상세 조회
    @GetMapping("/{userId}")
    private UserDto findUserById(@PathVariable Integer userId) {
        return this.userService.getUserById(userId);
    }

    // 회원 등록
    @PostMapping
    private void createUserInfo(@RequestBody UserDto dto) {
        this.userService.createUser(dto);
    }

    // 회원 수정
    @PutMapping("/{userId}")
    private void editUserInfo(@PathVariable Integer userId, @RequestBody UserDto dto) {
        this.userService.modifyUser(userId, dto);
    }


    // 회원 삭제
    @DeleteMapping("/{userId}")
    private void deleteUserInfo(@PathVariable Integer userId) {
        this.userService.removeUser(userId);
    }
}
