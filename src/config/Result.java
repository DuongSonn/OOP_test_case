package config;

import com.google.gson.JsonObject;

public class Result {
	public static JsonObject fakePost() {
		JsonObject post = new JsonObject();
		JsonObject user = new JsonObject();
		
		user.addProperty("name", "test user");
		user.addProperty("avatar", "avatar's link");
		
		post.addProperty("id", 1);
		post.addProperty("described", "test");
		post.addProperty("banned", 0);
		post.addProperty("is_blocked", 0);
		post.addProperty("like", 0);
		post.addProperty("comment", 0);
		post.addProperty("is_liked", 0);
		post.addProperty("can_comment", 0);
		post.add("author", user);
		return post;
	}
	
	public static JsonObject successResult(int status, JsonObject data) {
		JsonObject result = new JsonObject();
		result.addProperty("status", status);
		result.add("data", data);
		return result;
	}
	
	public static JsonObject failResult(int status, String message) {
		JsonObject result =new JsonObject();
		result.addProperty("status", status);
		result.addProperty("message", message);
		return result;
	}
}
