package com.mhd.mvnmvc.controller;

import com.mhd.mvnmvc.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    static List<User> list;

    static {
        list = new ArrayList<>();
        list.add(new User(1L, "mhd", "021725683"));
        list.add(new User(2L, "hsn", "546545555"));
        list.add(new User(3L, "rkb", "021615874"));
    }

    @GetMapping(value = "/")
    public String home() {
        return "Hello.........";
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Test..........";
    }

    //@GetMapping(value = "/users")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getList() {
        return this.list;
    }


    @GetMapping(value = "user")
    public User getUser() {
        return new User(1L, "mhd", "021725683");
    }


    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Long userid) {
        User user = null;
        for (User u : this.list) {
            if (userid == u.getId()) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;
            }
        }
        return user;
    }

    @GetMapping(value = "/user/{id}/{mobile}")
    public User getUserById(@PathVariable("id") Long userid, @PathVariable("mobile") String m) {
        User user = null;
        for (User u : this.list) {
            if (userid == u.getId() && m.equalsIgnoreCase(u.getMobile())) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;
            }
        }
        return user;
    }

    @GetMapping(value = "/addUser")
    public List<User> addUserToList() {
        list.add(new User(4L,"JHgdjfhs","89798463135462"));
        return list;
    }

    long id = list.size();

    @GetMapping(value = "/add/{userName}/{mobile}")
    public List<User> addUserToListDynamically(@PathVariable("userName") String username, @PathVariable("mobile") String m) {
        id++;
        list.add(new User(id,username,m));
        return list;
    }

    @GetMapping(value = "/del/{id}")
    public List<User> removeUserToListDynamically(@PathVariable("id") Long id) {
        list.remove(getUserByIdForDel(id));
        return list;
    }

    ////////Extra helper method
    public User getUserByIdForDel(Long userid) {
        User user = null;
        for (User u : this.list) {
            if (userid == u.getId()) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;
            }
        }
        return user;
    }
}
