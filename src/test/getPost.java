package test;

import java.util.Scanner;

import com.google.gson.JsonObject;

import config.Constant;
import config.Result;
import models.Post;

public class getPost {
	public static void main(String[] args) {
		Result rs = new Result();
		JsonObject fake_post = Result.fakePost();
		
		Scanner sc = new Scanner(System.in);
		Post post = new Post();
		System.out.print("Enter Id: ");
		String id = sc.nextLine();
		post.setId(id);
		System.out.print("Enter Token: ");
		String token = sc.nextLine();
		post.setToken(token);
//		TH1 : Missing parameters
		assert(token != null && !"".equals(token)) : 
			rs.failResult(Constant.TOKEN_INVALID, Constant.TOKEN_INVALID_MSG);
		assert(id != null && !"".equals(id)) : 
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_NOT_FOUND_MSG);
//		TH2: Wrong Id
		assert(id.toString().equals(fake_post.get("id").toString())) : 
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_NOT_FOUND_MSG);
//		TH3: Post id banned
		assert(fake_post.get("banned").getAsInt() != Constant.IS_BANNED) : 
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_IS_BANNED);
//		TH4: Post is blocked
		assert(fake_post.get("is_blocked").getAsInt() != Constant.IS_BLOCKED) : 
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_IS_BLOCKED);
//		TH5: Described is null
		assert(fake_post.get("described") != null) : 
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_ERROR);
//		TH6: Like or comment or is_liked is null
		assert(fake_post.get("like") != null && fake_post.get("comment") != null && fake_post.get("is_liked") != null) : 
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_ERROR);
//		TH7 : Post can't be commented or can_comment is null
		assert(fake_post.get("can_comment") != null && fake_post.get("can_comment").getAsInt() == Constant.CAN_COMMENT) : 
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_ERROR);
//		TH8: Post author is null
		assert(fake_post.get("author") != null) :
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_ERROR);
//		TH9: Post author's name or author's avatar is null
		assert(fake_post.get("author").getAsJsonObject().get("name") != null && fake_post.get("author").getAsJsonObject().get("avatar") != null
				&& !"".equals(fake_post.get("author").getAsJsonObject().get("name").toString())
				&& !"".equals(fake_post.get("author").getAsJsonObject().get("avatar").toString())) : 
			rs.failResult(Constant.POST_NOT_FOUND, Constant.POST_ERROR);
//		TH10: Invalid token
		assert(token.equals(Constant.TOKEN)) : rs.failResult(Constant.TOKEN_INVALID, Constant.TOKEN_INVALID_MSG);;
		
		System.out.println(rs.successResult(Constant.OK, fake_post));
	}
}
