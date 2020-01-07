package com.tj007.divbucketmvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
