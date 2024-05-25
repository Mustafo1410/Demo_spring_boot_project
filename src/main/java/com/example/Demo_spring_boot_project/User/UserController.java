package com.example.Demo_spring_boot_project.User;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user/")
public class UserController  implements UserInterface<Integer,User>{
private final UserServiceSimple userServiceSimple;
    @Override
    @PostMapping("/create")
    public User create( @RequestBody User dto) {
        return userServiceSimple.create(dto);
    }

    @Override
    @PutMapping("/update{id}")
    public User update( @PathVariable("id") Integer id, @RequestBody User dto) {
        return userServiceSimple.update(id, dto);
    }

    @Override
    @DeleteMapping("/delete")
    public User delete( @RequestParam Integer id) {
        return userServiceSimple.delete(id);
    }

    @Override
    @GetMapping("/get")
    public User get( @RequestParam Integer id) {
        return userServiceSimple.get(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<User> getAll() {
        return userServiceSimple.getAll();
    }
}
