package com.api.test;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

public class testMain {
    public static void main(String[] args) throws IOException, ParseException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.q-net.or.kr/api/service/rest/InquiryListNationalQualifcationSVC/getList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=6oUCNyNfLRSPWRqYGbhvMIoq0DAa1wDFrEZmcau6aDPC4jJtXtPXAWK%2FeaV6hJsM%2BZavP1lMg6zHnfHeWQD%2Bwg%3D%3D"); /*Service Key*/
        urlBuilder.append("&_type=json"); /*Service Key*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(sb.toString());
        JSONObject rp = (JSONObject)jsonObject.get("response");
        JSONObject body = (JSONObject)rp.get("body");
        JSONObject items = (JSONObject)body.get("items");
        
        ArrayList<JSONObject> arr = (ArrayList<JSONObject>) items.get("item");
        
        for (int i = 1; i <= arr.size(); i++) {
           System.out.println(i + "번쨰");
           HashMap<String, String> map = (HashMap<String, String>) arr.get(i);
           Dao dao = new Dao();
       	int e_id=i;
    	String qualgbcd;
    	String qualgbnm;
    	int seriescd;
    	String seriesnm;
    	int jmcd;
    	String jmfldnm;
    	int y_id;
    	int obligfldcd;
    	String obligfldnm;
    	int mdobligfldcd;
    	String mdobligfldnm;
    	String detail;
    	
    	if((String)map.get("qualgbcd")==null) {
    		qualgbcd = "-1";
    	}else {
    		qualgbcd = map.get("qualgbcd");
    	}
    	
    	if((String)map.get("qualgbnm")==null) {
    		qualgbnm = "-1";
    	}else {
    		qualgbnm = map.get("qualgbnm");
    	}
    	
    	if((String)map.get("seriescd")==null) {
    		seriescd = -1;
    	}else {
    		seriescd = Integer.parseInt(map.get("seriescd"));
    	}
    	
    	if((String)map.get("seriesnm")==null) {
    		seriesnm = "-1";
    	}else {
    		seriesnm = map.get("seriesnm");
    	}
    	
    	if((String)map.get("jmcd")==null) {
    		jmcd = -1;
    	}else {
    		jmcd = Integer.parseInt(map.get("jmcd"));
    	}
    	
    	if((String)map.get("jmfldnm")==null) {
    		jmfldnm = "-1";
    	}else {
    		jmfldnm = map.get("jmfldnm");
    	}
    	
    	if((String)map.get("y_id")==null) {
    		y_id = -1;
    	}else {
    		y_id = Integer.parseInt(map.get("y_id"));
    	}
    	
    	
    	if((String)map.get("obligfldcd")==null) {
    		obligfldcd = -1;
    	}else {
    		obligfldcd = Integer.parseInt(map.get("obligfldcd"));
    	}
    	
    	if((String)map.get("obligfldnm")==null) {
    		obligfldnm = "-1";
    	}else {
    		obligfldnm = map.get("obligfldnm");
    	}
    	
    	if((String)map.get("mdobligfldcd")==null) {
    		mdobligfldcd = -1;
    	}else {
    		mdobligfldcd = Integer.parseInt(map.get("mdobligfldcd"));
    	}
    	
    	if((String)map.get("mdobligfldnm")==null) {
    		mdobligfldnm = "-1";
    	}else {
    		mdobligfldnm = map.get("mdobligfldnm");
    	}
    	
    	if((String)map.get("detail")==null) {
    		detail = "-1";
    	}else {
    		detail = map.get("detail");
    	}
    	
           VO vo = new VO(e_id
        		   , qualgbcd
        		   , qualgbnm
        		   , seriescd
        		   , seriesnm
        		   ,jmcd
        		   , jmfldnm
        		   , y_id
        		   ,obligfldcd
        		   , obligfldnm
        		   , mdobligfldcd
        		   ,mdobligfldnm
        		   , detail);
           dao.insertApi(vo);
        }
        
        rd.close();
        conn.disconnect();
    }
}