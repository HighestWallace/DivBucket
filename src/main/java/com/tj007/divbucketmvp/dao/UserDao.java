package com.tj007.divbucketmvp.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

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

    public Document signUp(String user_name, String psw, String user_id){

        Document tmp = new Document();

        String result = "fail";

        Bson filter = Filters.eq("user_id", user_id);

        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        if(mongoCursor.hasNext()){
            tmp.put("result", result);
            tmp.put("user_id", "invalid");
        }
        else {
            result = "success";
            tmp.put("result", result);
            tmp.put("user_id", user_id);

            Document document = new Document();
            document.put("user_id", user_name);
            document.put("psw", psw);
            document.put("user_name",user_id);
            document.put("work", "");
            document.put("sex", 0);
            document.put("age", 0);
            document.put("avatar", "https://i.loli.net/2020/01/07/m765yUlHYfQVXeK.jpg");

            collection.insertOne(document);

        }
        return tmp;

    }

    public Document updateAvatar(String user_id, String avatar){
        String result= "fail";

        Bson filter = Filters.eq("user_id", user_id);
        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        if(mongoCursor.hasNext()){
            result = "success";
            BasicDBObject searchDoc = new BasicDBObject().append("user_id", user_id);
            BasicDBObject updateNewOne = new BasicDBObject("$set", new BasicDBObject("avatar", avatar));
            collection.updateOne(searchDoc,updateNewOne);

        }

        Document tmp = new Document();
        tmp.put("result", result);
        tmp.put("user_id", user_id);
        return tmp;
    }

    public Document updateUserInfo(String user_id, String user_name, String work, Integer age, Integer sex, String location){
        String result= "fail";

        Bson filter = Filters.eq("user_id", user_id);
        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        if(mongoCursor.hasNext()){
            result = "success";
            BasicDBObject searchDoc = new BasicDBObject().append("user_id", user_id);

            BasicDBObject updateUser_name = new BasicDBObject("$set", new BasicDBObject("user_name", user_name));
            collection.updateOne(searchDoc, updateUser_name);

            BasicDBObject updateWork = new BasicDBObject("$set", new BasicDBObject("work", work));
            collection.updateOne(searchDoc, updateWork);

            BasicDBObject updateAge = new BasicDBObject("$set", new BasicDBObject("age", age));
            collection.updateOne(searchDoc, updateAge);

            BasicDBObject updateSex = new BasicDBObject("$set", new BasicDBObject("sex", sex));
            collection.updateOne(searchDoc, updateSex);

            BasicDBObject updateLocation = new BasicDBObject("$set", new BasicDBObject("location", location));
            collection.updateOne(searchDoc, updateLocation);
        }

        Document tmp = new Document();
        tmp.put("result", result);
        tmp.put("user_id", user_id);
        return tmp;
    }

    public Document getUserInfo(String user_id){
        String result= "fail";

        Bson filter = Filters.eq("user_id", user_id);
        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();


        if(mongoCursor.hasNext()){
            result = "success";
            BasicDBObject searchDoc = new BasicDBObject().append("user_id", user_id);
            Document document = mongoCursor.next();
            document.put("result", result);
            return document;
        }

        Document tmp = new Document();
        tmp.put("result", result);
        tmp.put("user_id", user_id);
        return tmp;
    }

}
