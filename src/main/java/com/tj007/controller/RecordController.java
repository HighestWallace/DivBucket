package com.tj007.controller;

import com.tj007.dao.RecordDao;
import com.tj007.model.Record;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordController {
    @RequestMapping(value = "/getnewrecord")
    public Document login(@RequestBody Record record){
        RecordDao recordDao = new RecordDao();

        return recordDao.getNewRecord(
                record.getUser_id(), record.getUrl(), record.getId(), record.getValue(), record.getDate());


    }
}
