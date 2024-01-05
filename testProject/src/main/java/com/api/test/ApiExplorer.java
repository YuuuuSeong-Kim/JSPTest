package com.api.test;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;

public class ApiExplorer {
	public static void main(String[] args) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.q-net.or.kr/api/service/rest/InquiryListNationalQualifcationSVC/getList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=mjJMdl1IEJmtDxQ%2B5j7WOGf40HXzwOlqkJ971ptzR7AndA9ONtQgYvugFAk19JKPRW2h%2FZ4Oe46sN8F6KcX9PA%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		Gson gson = new Gson();
		JSONObject xmlobj = XML.toJSONObject(sb.toString());
		xmlobj = (JSONObject)xmlobj.get("response");
		xmlobj = (JSONObject)xmlobj.get("body");
		xmlobj = (JSONObject)xmlobj.get("items");
//		xmlobj = (JSONObject)xmlobj.get("item");
		
		String jsonobj = xmlobj.toString();
//       System.out.println(jsonobj);
		Type type = new TypeToken<Map<String, Object>>() {
		}.getType();
		Map data = gson.fromJson(jsonobj, type);
//		data = data.get("response");
		System.out.println(data);
	}
}