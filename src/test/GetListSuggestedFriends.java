package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.swing.JTextArea;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import config.Constant;
import models.*;

public class GetListSuggestedFriends {
	public static void run(String sourceName, int testCaseNum, JTextArea textResult, JTextArea textResponse) {
		try {
			URL url = new URL(sourceName + "get_list_suggested_friends"
					+ "?token=" + Constant.TOKEN 
					+ "&index=0"  
					+ "&count=20"
					);
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
		        textResponse.setText(content.toString());
		        
		        Gson  g = new Gson();
		        ResponseListFriend rp = g.fromJson(content.toString(), ResponseListFriend.class);
		        if (testCaseNum == 1) {
		        	assert(rp.code != null && !"".equals(rp.code));
			        assert(rp.message != null && !"".equals(rp.message));
			        if (rp.code.equals(Constant.OK)) {
			        	assert(rp.data != null);
			        }
			        textResult.setText("Test case 1 is finished! Satisfied!");
				} else if (testCaseNum == 2) {
					assert(rp.data.list_users!= null);
					if (rp.data.list_users.length > 0) {
						for (int i = 0; i < rp.data.list_users.length; i++) {
							assert(rp.data.list_users[i].user_id != null && !"".equals(rp.data.list_users[i].user_id));
							assert(rp.data.list_users[i].username != null && !"".equals(rp.data.list_users[i].username));
							assert(rp.data.list_users[i].avatar != null && !"".equals(rp.data.list_users[i].avatar));
							assert(rp.data.list_users[i].same_friends != null && !"".equals(rp.data.list_users[i].same_friends));
						}
					}
		        	textResult.setText("Test case 2 is finished! Satisfied!");
		        } else if (testCaseNum == 3) {
					assert(rp.data.list_users!= null);
					if (rp.data.list_users.length > 0) {
						for (int i = 0; i < rp.data.list_users.length; i++) {
							for (int j = i + 1; j < rp.data.list_users.length; j++) {
								assert(rp.data.list_users[i].user_id != rp.data.list_users[j].user_id);
							}
						}
					}
		        	textResult.setText("Test case 3 is finished! Satisfied!");
		        } else if (testCaseNum == 4) {
					assert(rp.data.list_users!= null);
					if (rp.data.list_users.length > 0) {
						for (int i = 0; i < rp.data.list_users.length; i++) {
							assert(rp.data.list_users[i].user_id != "5ff51584d19c830017c6abe6");
						}
					}
		        	textResult.setText("Test case 4 is finished! Satisfied!");
		        }	    
		    } catch (IOException e) {
		    	textResult.setText("Test case failed!");
				e.printStackTrace();
			} finally {
		        connection.disconnect();
		    }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}