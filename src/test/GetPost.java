package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import config.Constant;
import models.*;

public class GetPost {

	public static void main(String[] args) throws MalformedURLException, ProtocolException, 
	IOException {
	    URL url = new URL(Constant.API_URL + "post/get_post"
    			+ "?token=" + Constant.TOKEN 
	    		+ "&id=" + Constant.POST_ID);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setDoOutput(true);
	    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
	        
	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(
	                new InputStreamReader(connection.getInputStream()))) {
	        String line;
	        content = new StringBuilder();
	           while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	        System.out.println(content);
	        System.out.println("JSON response: " + content.toString());
	        
	        Gson  g = new Gson();
	        ResponsePostSuccess rp = g.fromJson(content.toString(), ResponsePostSuccess.class);

	        System.out.println("Unit test 1: The code, message, data strings shall not be NULL as well as non-empty:");
	        assert(rp.code != null && !"".equals(rp.code));
	        assert(rp.message != null && !"".equals(rp.message));
	        if (rp.code.equals(Constant.OK)) {
	        	assert(rp.data != null);
	        }
	        System.out.println("Test case 1 is finished! Satisfied!");
	        
	        if (rp.data != null) {
	        	System.out.println("Unit test 2: The required fields shall be not NULL as well as non-empty:");
	        	assert(rp.data.id != null && !"".equals(rp.data.id));
	        	assert(rp.data.described != null && !"".equals(rp.data.described));
	        	assert(rp.data.created != null && !"".equals(rp.data.created));
	        	assert(rp.data.modified != null && !"".equals(rp.data.modified));
	        	assert(rp.data.like != null && !"".equals(rp.data.like));
	        	assert(rp.data.comment != null && !"".equals(rp.data.comment));
	        	assert(rp.data.is_liked != null && !"".equals(rp.data.is_liked));
	        	assert(rp.data.is_blocked != null && !"".equals(rp.data.is_blocked));
	        	assert(rp.data.author != null);
	        	assert(rp.data.can_edit != null && !"".equals(rp.data.can_edit));
	        	assert(rp.data.banned != null && !"".equals(rp.data.banned)) : "Error";
		        System.out.println("Test case 2 is finished! Satisfied!");
		        
		        System.out.println("Unit test 3: The banned field can't be 1");
		        assert(rp.data.banned.equals(Constant.IS_BANNED));
		        System.out.println("Test case 3 is finished! Satisfied!");
		        
		        System.out.println("Unit test 4: The is_blocked field can't be 1");
		        assert(!rp.data.is_blocked.equals(Constant.IS_BLOCKED));
		        System.out.println("Test case 4 is finished! Satisfied!");
		        
		        System.out.println("Unit test 5: The name, id, avatar, online  field can't be NULL or empty");
		        assert(rp.data.author.id != null && !"".equals(rp.data.author.id));
		        assert(rp.data.author.name != null && !"".equals(rp.data.author.name));
		        assert(rp.data.author.avatar != null && !"".equals(rp.data.author.avatar));
		        System.out.println("Test case 5 is finished! Satisfied!");
	        }
	    } finally {
	        connection.disconnect();
	    }
	}
}