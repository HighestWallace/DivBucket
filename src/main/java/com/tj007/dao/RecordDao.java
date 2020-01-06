package com.tj007.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.tj007.model.Record;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Hashtable;

public class RecordDao extends BaseDao {
    public MongoCollection<Document> collection = mongoDatabase.getCollection("record");

    public Document getNewRecord( String user_id, String url, String id, String value, String date){

        Document document = new Document();
        document.put("user_id", user_id);
        document.put("url", url);
        if (!id.equals("unused"))
            document.put("id", id);
        document.put("value", value);
        document.put("date", date);

        collection.insertOne(document);

        return sendNewRecord(user_id);
    }

    public Document sendNewRecord(String user_id){
        BasicDBObject searchDoc = new BasicDBObject().append("user_id", user_id);

        FindIterable<Document> find = collection.find(searchDoc).sort(new Document().append("date", -1)).limit(1);
        Document document = find.first();
        return document;
    }






}
