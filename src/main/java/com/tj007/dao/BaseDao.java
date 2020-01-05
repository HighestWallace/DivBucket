package com.tj007.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.WriteConcernResult;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.bulk.DeleteRequest;
import com.mongodb.bulk.InsertRequest;
import com.mongodb.bulk.UpdateRequest;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.Connection;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.QueryResult;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.FieldNameValidator;
import org.bson.codecs.Decoder;

import java.util.List;

public class BaseDao {
    static final MongoClient mongoClient  = new MongoClient("localhost", 27017);
    static final MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

//    MongoCollection<Document> collection = mongoDatabase.getCollection("user");

//    FindIterable<Document> findIterable = collection.find();
}
