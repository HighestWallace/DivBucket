package com.tj007.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Hashtable;

public class UserDao extends BaseDao {

    public MongoCollection<Document> collection = mongoDatabase.getCollection("user");

    public Document login(String user_id, String psw){

        String result= "fail";

        Bson filter = Filters.eq("user_id", user_id);
        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        if(mongoCursor.hasNext() && mongoCursor.next().get("psw").equals(psw)){
                result = "success";
        }

        Document tmp = new Document();
        tmp.put("result", result);
        tmp.put("user_id", user_id);
        return tmp;
    }

    public Document signUp(String user_name, String psw, String binding_email, String work){

        Document tmp = new Document();

        String result = "fail";

        Bson filter = Filters.eq("user_id", binding_email);

        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        if(mongoCursor.hasNext()){
            tmp.put("result", result);
            tmp.put("user_id", "invalid");
        }
        else {
            result = "success";
            tmp.put("result", result);
            tmp.put("user_id", binding_email);

            Document document = new Document();
            document.put("user_id", binding_email);
            document.put("psw", psw);
            document.put("binding_email", binding_email);
            document.put("user_name",user_name);
            document.put("work", work);
            collection.insertOne(document);

        }
        return tmp;

    }

}
