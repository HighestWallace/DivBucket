package com.tj007.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.query.Criteria;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ManagerDao extends BaseDao {
    public MongoCollection<Document> collection = mongoDatabase.getCollection("manager");

    public Document login(String manager_id, String psw){

        String result= "fail";

        Bson filter = Filters.eq("manager_id", manager_id);
        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        if(mongoCursor.hasNext() && mongoCursor.next().get("psw").equals(psw)){
            result = "success";
        }

        Document tmp = new Document();
        tmp.put("result", result);
        tmp.put("manager_id", manager_id);
        return tmp;
    }

    public Document getUserInfo(String user_id){

        String result= "fail";
        MongoCollection<Document> user_collection = mongoDatabase.getCollection("user");

        Bson filter = Filters.eq("user_id", user_id);
        FindIterable<Document> findIterable = user_collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        if(mongoCursor.hasNext()){
            result = "success";
            MongoCollection<Document> record_collection = mongoDatabase.getCollection("record");
            BasicDBObject searchDoc = new BasicDBObject().append("user_id", user_id);
            FindIterable<Document> findRecord = record_collection.find(searchDoc).sort(new Document().append("date",1));

            ArrayList<Document> Oct = new ArrayList<Document>();
            ArrayList<Document> Nov = new ArrayList<Document>();
            ArrayList<Document> Dec = new ArrayList<Document>();
            ArrayList<Document> Jan = new ArrayList<Document>();

            for(Document document: findRecord){
                if ((((String)document.get("date")).compareTo("2019-10-01 00:00:00")>=0)
                && (((String)document.get("date")).compareTo("2019-11-01 00:00:00") < 0))
                    Oct.add(document);
                else if ((((String)document.get("date")).compareTo("2019-11-01 00:00:00")>=0)
                        && (((String)document.get("date")).compareTo("2019-12-01 00:00:00") < 0))
                    Nov.add(document);
                else if ((((String)document.get("date")).compareTo("2019-12-01 00:00:00")>=0)
                        && (((String)document.get("date")).compareTo("2020-1-01 00:00:00") < 0))
                    Dec.add(document);
                else Jan.add(document);
            }
            Document document= new Document();
            document.append("Oct", Oct.size());
            document.append("Nov", Nov.size());
            document.append("Dec", Dec.size());
            document.append("Jan", Jan.size());

            //按日期排序
            return document;
        }
        else {
            Document tmp = new Document();
            tmp.put("result", result);
            tmp.put("user_id", "invalid");
            return tmp;
        }
    }

    public Document getLabel(){

        MongoCollection<Document> web_collection = mongoDatabase.getCollection("web_monitor");
        FindIterable<Document> findWeb = web_collection.find();

        Document count = new Document();

        for(Document document: findWeb){

            for(String tag : (ArrayList<String>)document.get("tag")){
                if (count.get(tag) == null)
                    count.put(tag, 1);
                else count.put(tag, (int)count.get(tag)+1);

            }
        }
        //
        return count;
    }
}
