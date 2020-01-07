package com.tj007.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class WebDao extends BaseDao {

    public MongoCollection<Document> collection = mongoDatabase.getCollection("web_monitor");

    public Document getUserWebInfo(String user_id, String url){
        MongoCollection<Document> record_collection = mongoDatabase.getCollection("record");
        String result = "fail";

        Bson filter = Filters.and(Filters.eq("user_id", user_id), Filters.eq("url", url)) ;

        FindIterable<Document> findIterable = record_collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        if(mongoCursor.hasNext()){
            result = "success";
            Document webInfo = new Document();
            for (Document document: findIterable){
                webInfo.put((String) webInfo.get("url"), webInfo);
            }
            return webInfo;
        }
        return new Document("result",result);
    }

    public Document getUserWebRule(String user_id, String url){
        String result = "fail";
        Bson filter = Filters.and(Filters.eq("user_id", user_id), Filters.eq("url", url)) ;

        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        if(mongoCursor.hasNext()){
            result = "success";
            return findIterable.first();
        }
        return new Document("result", result);
    }

    public Document addWebMonitor(
            String user_id, String url, String remark, String cookie, ArrayList<String> label,
            ArrayList<String> path, boolean isActive){

        String result = "success";
        Document tmp = new Document();
        tmp.put("result", result);

        Document document = new Document();
        document.put("user_id", user_id);
        document.put("url", url);
        document.put("remark", remark);
        document.put("cookie", cookie);
        document.put("label", label);
        document.put("path", path);
        document.put("isActive", isActive);

        collection.insertOne(document);
        //Bson filter = Filters.and(Filters.eq("user_id", user_id), Filters.eq("url", url)) ;

        return tmp;

    }


}
