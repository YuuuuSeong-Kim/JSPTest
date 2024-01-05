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

public class testMain3 {
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
        
        for (int i = 0; i < arr.size(); i++) {
           System.out.println(i + "번쨰");
           HashMap<String, String> map = (HashMap<String, String>) arr.get(i);
           Dao3 dao = new Dao3();
//           VO vo = new VO(Integer.parseInt(map.get("e_id"))
//        		   , map.get("qualgbcd")
//        		   , map.get("qualgbnm")
//        		   , Integer.parseInt(map.get("seriescd"))
//        		   , map.get("seriesnm")
//        		   ,Integer.parseInt(map.get("jmcd"))
//        		   , map.get("jmfldnm")
//        		   , Integer.parseInt(map.get("y_id"))
//        		   ,Integer.parseInt(map.get("obligfldcd"))
//        		   , map.get("obligfldnm")
//        		   , Integer.parseInt(map.get("mdobligfldcd"))
//        		   , map.get("mdobligfldnm")
//        		   , map.get("detail"));
//           dao.insertApi(vo);
           System.out.println(map);
        }
        
        rd.close();
        conn.disconnect();
    }
}