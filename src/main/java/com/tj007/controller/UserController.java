package com.tj007.controller;
import com.tj007.dao.UserDao;
import com.tj007.model.User;
import org.bson.Document;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/User")
public class UserController {

//    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET, produces = "application/json")
//    public JSONResult profilePage(
//            @PathVariable(value = "user_id") int userId
//    ){
//        try {
//            return JSONResult.custom("200", "success", userService.getUserPublicInfo(userId));
//        } catch (Exception e) {
//            return JSONResult.custom("200", "fail", null);
//        }
//    }
    @RequestMapping(value = "/login" , method = RequestMethod.POST ,produces = "application/json")
    public Document login(
            @RequestBody User user
            ){
        UserDao userDao = new UserDao();

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
