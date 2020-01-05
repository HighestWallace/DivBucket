package com.tj007.dao;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class WebDao extends BaseDao {
    public MongoCollection<Document> collection = mongoDatabase.getCollection("web_monitor");



}
