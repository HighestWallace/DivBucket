package com.tj007;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongoApplication {

	public static void main(String[] args) {
		MongoClient mongoClient  = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

		MongoCollection<Document> collection = mongoDatabase.getCollection("user");

		//FindIterable<Document> findIterable = collection.find();

//		String user_id = "1", psw = "1", result = "fail";
//
//		Bson filter = Filters.eq("user_id", user_id);
//		FindIterable<Document> findIterable = collection.find(filter);
//
//
//		MongoCursor<Document> mongoCursor = findIterable.iterator();
//		//System.out.println(mongoCursor.next().get("user_name"));
//		if(mongoCursor.hasNext()){
//			Document tmp =  mongoCursor.next();
//			System.out.println(tmp);
//			if(tmp.get("psw").equals(psw))
//				result = "success";
//		}
//		System.out.println(result);

//		MongoCursor<Document> mongoCursor = findIterable.iterator();
//		//System.out.println(mongoCursor.next().get("user_name"));
//		while(mongoCursor.hasNext()){
//			System.out.println(mongoCursor.next());
//		}
//
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}
}
