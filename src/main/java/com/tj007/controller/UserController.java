package com.tj007.controller;
import com.tj007.dao.UserDao;
import com.tj007.model.User;
import org.bson.Document;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login")
    //@RequestMapping(value = "/login" , method = RequestMethod.POST)
    public Document login(@RequestBody User user){
        UserDao userDao = new UserDao();

        //System.out.println(userDao.login(user.getUser_id(), user.getPsw()));
        return userDao.login(user.getUser_id(), user.getPsw());


    }

    @RequestMapping(value = "/signup" , method = RequestMethod.POST ,produces = "application/json")
    public Document signUp(
            @RequestBody User user
    ){
        UserDao userDao = new UserDao();

        return userDao.signUp(user.getUser_name(),user.getPsw(), user.getBinding_email(), user.getWork());

    }

}
