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

public class GetPushSettings {
	public static void run(String sourceName, int testCaseNum, JTextArea textResult, JTextArea textResponse) {
		try {
			URL url = new URL(sourceName + "get_push_settings" + "?token=" + Constant.TOKEN);
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
				ResponsePushSettings rp = g.fromJson(content.toString(), ResponsePushSettings.class);
				if (testCaseNum == 1) {
					assert (rp.code != null && !"".equals(rp.code));
					assert (rp.message != null && !"".equals(rp.message));
					if (rp.code.equals(Constant.OK)) {
						assert (rp.data != null);
					}
					textResult.setText("Test case 1 is finished! Satisfied!");
				} else if (testCaseNum == 2) {
					assert (rp.data.like_comment != null && !"".equals(rp.data.like_comment));
					assert (rp.data.from_friends != null && !"".equals(rp.data.from_friends));
					assert (rp.data.requested_friend != null && !"".equals(rp.data.requested_friend));
					assert (rp.data.suggested_friend != null && !"".equals(rp.data.suggested_friend));
					assert (rp.data.birthday != null && !"".equals(rp.data.birthday));
					assert (rp.data.video != null && !"".equals(rp.data.video));
					assert (rp.data.report != null && !"".equals(rp.data.report));
					assert (rp.data.sound_on != null && !"".equals(rp.data.sound_on));
					assert (rp.data.notification_on != null && !"".equals(rp.data.notification_on));
					assert (rp.data.vibrant_on != null && !"".equals(rp.data.vibrant_on));
					assert (rp.data.led_on != null && !"".equals(rp.data.led_on));
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