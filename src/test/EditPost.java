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

public class EditPost {
	public static void run(int testCaseNum, JTextArea textResult, JTextArea textResponse) {
		try {
			String encodedDescribed=java.net.URLEncoder.encode("Teach me how to love - TLinh3","UTF-8");
			String encodedStatus=java.net.URLEncoder.encode("happy3","UTF-8");
			URL url = new URL(Constant.SOURCES[3] + "edit_post"
					+ "?token=" + Constant.TOKEN 
					+ "&id=" + Constant.POST_ID_SOURCE_4
					+ "&described=" + encodedDescribed 
					+ "&status="+ encodedStatus
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
		        ResponseEditPost rp = g.fromJson(content.toString(), ResponseEditPost.class);
		        if (testCaseNum == 1) {
		        	assert(rp.code != null && !"".equals(rp.code));
			        assert(rp.message != null && !"".equals(rp.message));
			        if (rp.code.equals(Constant.OK)) {
			        	assert(rp.data != null);
			        }
			        textResult.setText("Test case 1 is finished! Satisfied!");
		        } else if (testCaseNum == 2) {
		        	assert(rp.data.id.equals(Constant.POST_ID_SOURCE_4));
		        	textResult.setText("Test case 2 is finished! Satisfied!");
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