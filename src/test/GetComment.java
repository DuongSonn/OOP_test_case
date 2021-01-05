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

public class GetComment {
	public static void run(String sourceName, int testCaseNum, JTextArea textResult, JTextArea textResponse) {
		try {
			URL url = new URL(sourceName + "get_comment"
					+ "?token=" + Constant.TOKEN 
					+ "&id=" + Constant.POST_ID_SOURCE_4
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
		        textResponse.setText(content.toString());
		        
		        Gson  g = new Gson();
		        ResponseComment rp = g.fromJson(content.toString(), ResponseComment.class);
		        if (testCaseNum == 1) {
			        assert(rp.code == null && !"".equals(rp.code));
			        assert(rp.message != null && !"".equals(rp.message));
			        if (rp.code.equals(Constant.OK)) {
			        	assert(rp.data != null);
			        }
			        textResult.setText("Test case 1 is finished! Satisfied!");
		        } else if (testCaseNum == 2) {
		        	for (int i = 0; i < rp.data.length; i++) {
			        	assert(rp.data[i].id != null && !"".equals(rp.data[i].id));
			        	assert(rp.data[i].comment != null && !"".equals(rp.data[i].comment));
			        	assert(rp.data[i].created != null && !"".equals(rp.data[i].created));
			        	assert(rp.data[i].poster != null);
			        	assert(rp.data[i].is_blocked != null && !"".equals(rp.data[i].is_blocked));
		        	}
		        	textResult.setText("Test case 2 is finished! Satisfied!");
		        } else if (testCaseNum == 3) {
		        	for (int i = 0; i < rp.data.length; i++) {
				        assert(!rp.data[i].is_blocked.equals(Constant.IS_BLOCKED));
		        	}
		        	textResult.setText("Test case 3 is finished! Satisfied!");
		        } else if (testCaseNum == 4) {
		        	for (int i = 0; i < rp.data.length; i++) {
				        assert(rp.data[i].poster.id != null && !"".equals(rp.data[i].poster.id));
				        assert(rp.data[i].poster.name != null && !"".equals(rp.data[i].poster.name));
				        assert(rp.data[i].poster.avatar != null && !"".equals(rp.data[i].poster.avatar));
		        	}
		        	textResult.setText("Test case 4 is finished! Satisfied!");
		        }
		    } catch (IOException e) {
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