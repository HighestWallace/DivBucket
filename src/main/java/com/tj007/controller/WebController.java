package com.tj007.controller;

import com.tj007.dao.WebDao;
import com.tj007.model.WebMonitor;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/web")
public class WebController {

    @RequestMapping(value = "/add")
    public Document addWebMonitor(@RequestBody WebMonitor webMonitor){
        WebDao webDao = new WebDao();

        return webDao.addWebMonitor(webMonitor.getUser_id(), webMonitor.getUrl(), webMonitor.getRemark(),
                webMonitor.getCookie(), webMonitor.getTag(), webMonitor.getPath(), webMonitor.getIsActive());
    }

    @RequestMapping(value = "/getWebInfo")
   public Document getWebInfo(@RequestBody WebMonitor webMonitor){
        WebDao webDao = new WebDao();

        return webDao.getUserWebInfo(webMonitor.getUser_id(), webMonitor.getUrl());
    }

    @RequestMapping(value = "/rule")
    public Document getUserWebRule(@RequestBody WebMonitor webMonitor){
        WebDao webDao = new WebDao();

        return webDao.getUserWebRule(webMonitor.getUser_id(), webMonitor.getUrl());
    }

}
