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

public class GetPost {
	public static void run(String sourceName, int testCaseNum, JTextArea textResult, JTextArea textResponse) {
		try {
			URL url = new URL(sourceName + "get_post"
					+ "?token=" + Constant.TOKEN 
					+ "&id=" + Constant.POST_ID_SOURCE_5);
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
		        ResponsePostSuccess rp = g.fromJson(content.toString(), ResponsePostSuccess.class);
		        if (testCaseNum == 1) {
		        	assert(rp.code != null && !"".equals(rp.code));
			        assert(rp.message != null && !"".equals(rp.message));
			        if (rp.code.equals(Constant.OK)) {
			        	assert(rp.data != null);
			        }
			        textResult.setText("Test case 1 is finished! Satisfied!");
		        } else if (testCaseNum == 2) {
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
		        	textResult.setText("Test case 2 is finished! Satisfied!");
		        } else if (testCaseNum == 3) {
			        assert(rp.data.banned.equals(Constant.IS_BANNED));
			        textResult.setText("Test case 3 is finished! Satisfied!");
		        } else if (testCaseNum == 4) {
			        assert(!rp.data.is_blocked.equals(Constant.IS_BLOCKED));
			        textResult.setText("Test case 4 is finished! Satisfied!");
		        } else if (testCaseNum == 5) {
			        assert(rp.data.author.id != null && !"".equals(rp.data.author.id));
			        assert(rp.data.author.name != null && !"".equals(rp.data.author.name));
			        assert(rp.data.author.avatar != null && !"".equals(rp.data.author.avatar));
			        textResult.setText("Test case 5 is finished! Satisfied!");
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