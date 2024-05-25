package com.example.Demo_spring_boot_project.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceSimple implements UserInterface<Integer, User> {
    private UserServiceSimple userServiceSimple;
    List<User> usersList = new ArrayList<>();
    Integer userID = 1;

    @Override
    public User create(User dto) {
        User user =  User.builder()
                .id(userID)
                .name(dto.getName())
                .age(dto.getAge())
                .build();
        usersList.add(user);
        userID++;
        return user;
    }

    @Override
    public User update(Integer id, User dto) {
        for (User user : usersList) {
            if(user.getId().equals(id)) {
                user.setName(dto.getName());
                user.setAge(dto.getAge());
                user.setId(id);
                return user;
            }
        }
        return new User();
    }

    @Override
    public User delete(Integer id) {
        for (User user : usersList) {
            if(user.getId().equals(id)) {
                usersList.remove(user);
                return user;
            }
        }
        return new User();
    }

    @Override
    public User get(Integer id) {
        for (User user : usersList) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return new User();
    }

    @Override
    public List<User> getAll() {
        return usersList;
    }
}