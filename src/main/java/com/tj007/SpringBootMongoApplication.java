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

@SpringBootApplication
public class SpringBootMongoApplication {

	public static void main(String[] args) {
//		MongoClient mongoClient  = new MongoClient("localhost", 27017);
//		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
//
//		MongoCollection<Document> collection = mongoDatabase.getCollection("user");

//		UserDao userDao = new UserDao();
//		User user =new User();
//		System.out.println(userDao.login("1", "1"));
//		System.out.println(userDao.signUp("2","2","xxx@qq.com","student"));


//		System.out.println(userDao.login(user.getUser_id(), user.getPsw()));
		//FindIterable<Document> findIterable = collection.find();

//		String user_id = "1", psw = "1", result = "fail";
//
//		Bson filter = Filters.eq("user_id", user_id);
//		FindIterable<Document> findIterable = collection.find(filter);

		SpringApplication.run(SpringBootMongoApplication.class, args);
	}
}
