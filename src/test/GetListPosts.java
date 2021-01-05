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

public class GetListPosts {
	public static void run(String sourceName, int testCaseNum, JTextArea textResult, JTextArea textResponse) {
		try {
			URL url = new URL(sourceName + "get_list_posts" + "?token=" + Constant.TOKEN + "&index=0&count=20");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {

				StringBuilder content;

				try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					String line;
					content = new StringBuilder();
					while ((line = in.readLine()) != null) {
						content.append(line);
						content.append(System.lineSeparator());
					}
				}
				textResponse.setText(content.toString());

				Gson g = new Gson();
				ResponseListPosts rp = g.fromJson(content.toString(), ResponseListPosts.class);
				if (testCaseNum == 1) {
					assert (rp.code != null && !"".equals(rp.code));
					assert (rp.message != null && !"".equals(rp.message));
					if (rp.code.equals(Constant.OK)) {
						assert (rp.data != null);
					}
					textResult.setText("Test case 1 is finished! Satisfied!");
				} else if (testCaseNum == 2) {
					assert (rp.data.new_items != null && !"".equals(rp.data.new_items));
					assert (rp.data.last_id != null && !"".equals(rp.data.last_id));
					if (rp.data.posts.length > 0) {
						for (int i = 0; i < rp.data.posts.length; i++) {
							assert (rp.data.posts[i].id != null && !"".equals(rp.data.posts[i].id));
							assert (rp.data.posts[i].described != null && !"".equals(rp.data.posts[i].described));
							assert (rp.data.posts[i].created != null && !"".equals(rp.data.posts[i].created));
							assert (rp.data.posts[i].modified != null && !"".equals(rp.data.posts[i].modified));
							assert (rp.data.posts[i].like != null && !"".equals(rp.data.posts[i].like));
							assert (rp.data.posts[i].comment != null && !"".equals(rp.data.posts[i].comment));
							assert (rp.data.posts[i].is_liked != null && !"".equals(rp.data.posts[i].is_liked));
							assert (rp.data.posts[i].is_blocked != null && !"".equals(rp.data.posts[i].is_blocked));
							assert (rp.data.posts[i].author != null);
							assert (rp.data.posts[i].can_edit != null && !"".equals(rp.data.posts[i].can_edit));
							assert (rp.data.posts[i].banned != null && !"".equals(rp.data.posts[i].banned)) : "Error";
						}
						textResult.setText("Test case 2 is finished! Satisfied!");
					} else if (testCaseNum == 3) {
						if (rp.data.posts.length > 0) {
							for (int i = 0; i < rp.data.posts.length; i++) {
								assert (rp.data.posts[i].banned.equals(Constant.IS_BANNED));
							}
						}
						textResult.setText("Test case 3 is finished! Satisfied!");
					} else if (testCaseNum == 4) {
						if (rp.data.posts.length > 0) {
							for (int i = 0; i < rp.data.posts.length; i++) {
								assert (!rp.data.posts[i].is_blocked.equals(Constant.IS_BLOCKED));
							}
						}
						textResult.setText("Test case 4 is finished! Satisfied!");
					} else if (testCaseNum == 5) {
						if (rp.data.posts.length > 0) {
							for (int i = 0; i < rp.data.posts.length; i++) {
								assert (rp.data.posts[i].author.id != null && !"".equals(rp.data.posts[i].author.id));
								assert (rp.data.posts[i].author.name != null
										&& !"".equals(rp.data.posts[i].author.name));
								assert (rp.data.posts[i].author.avatar != null
										&& !"".equals(rp.data.posts[i].author.avatar));
							}
						}
						textResult.setText("Test case 5 is finished! Satisfied!");
					}
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