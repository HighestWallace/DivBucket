package com.tj007;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.tj007.dao.UserDao;
import com.tj007.model.User;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootMongoApplication {

	public static void main(String[] args) {
//		MongoClient mongoClient  = new MongoClient("localhost", 27017);
//		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
//		MongoCollection<Document> web_collection = mongoDatabase.getCollection("web_monitor");
//		FindIterable<Document> findWeb = web_collection.find();
//		for(Document document: findWeb) {
//			for(String tag : (ArrayList<String>)document.get("tag")){
//				System.out.println(tag);
//			}
//		}

		SpringApplication.run(SpringBootMongoApplication.class, args);
	}
}
