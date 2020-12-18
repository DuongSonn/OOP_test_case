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

public class GetComment {
	public static void main(String[] args) throws MalformedURLException, ProtocolException, 
	IOException {
	    URL url = new URL(Constant.API_URL + "comment/get_comment"
    			+ "?token=" + Constant.TOKEN 
	    		+ "&id=" + Constant.POST_ID
	    		+ "&index=0"
	    		+ "&count=20");
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
	        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);

	        System.out.println("Unit test 1: The code, message, data strings shall not be NULL as well as non-empty:");
	        assert(rp.code != null && !"".equals(rp.code));
	        assert(rp.message != null && !"".equals(rp.message));
	        if (rp.code.equals(Constant.OK)) {
	        	assert(rp.data != null);
	        }
	        System.out.println("Test case 1 is finished! Satisfied!");

	        if (rp.data != null) {
	        	for (int i = 0; i < rp.data.length; i++) {
	        		System.out.println("Unit test 2: The required fields shall be not NULL as well as non-empty:");
		        	assert(rp.data[i].id != null && !"".equals(rp.data[i].id));
		        	assert(rp.data[i].comment != null && !"".equals(rp.data[i].comment));
		        	assert(rp.data[i].created != null && !"".equals(rp.data[i].created));
		        	assert(rp.data[i].poster != null);
		        	assert(rp.data[i].is_blocked != null && !"".equals(rp.data[i].is_blocked));
			        System.out.println("Test case 2 is finished! Satisfied!");
			        
			        System.out.println("Unit test 3: The is_blocked field can't be 1");
			        assert(!rp.data[i].is_blocked.equals(Constant.IS_BLOCKED));
			        System.out.println("Test case 3 is finished! Satisfied!");
			        
			        System.out.println("Unit test 4: The name, id, avatar, online  field can't be NULL or empty");
			        assert(rp.data[i].poster.id != null && !"".equals(rp.data[i].poster.id));
			        assert(rp.data[i].poster.name != null && !"".equals(rp.data[i].poster.name));
			        assert(rp.data[i].poster.avatar != null && !"".equals(rp.data[i].poster.avatar));
			        System.out.println("Test case 4 is finished! Satisfied!");
				}
	        }
	    } finally {
	        connection.disconnect();
	    }
	}
}