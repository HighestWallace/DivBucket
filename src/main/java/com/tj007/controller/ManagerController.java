package com.tj007.controller;

import com.tj007.dao.ManagerDao;
import com.tj007.model.Manager;
import com.tj007.model.User;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @RequestMapping(value = "/login")
    public Document login(@RequestBody Manager manager){
        ManagerDao managerDao = new ManagerDao();

        return (managerDao.login(manager.getManager_id(), manager.getPsw()));
    }

    @RequestMapping(value = "/getUserInfo")
    public Document getUserInfo(@RequestBody User user){
        ManagerDao managerDao = new ManagerDao();

        return managerDao.getUserInfo(user.getUser_id());
    }

    @RequestMapping(value = "/getTag")
    public Document getTag(){
        ManagerDao managerDao = new ManagerDao();

        return managerDao.getTag();
    }
}
