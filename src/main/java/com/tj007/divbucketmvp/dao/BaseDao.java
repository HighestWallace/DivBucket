package com.tj007.divbucketmvp.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class BaseDao {
    static final MongoClient mongoClient  = new MongoClient("localhost", 27017);
    static final MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

//    MongoCollection<Document> collection = mongoDatabase.getCollection("user");

//    FindIterable<Document> findIterable = collection.find();
}
