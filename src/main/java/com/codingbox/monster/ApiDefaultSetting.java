package com.codingbox.monster;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@RequiredArgsConstructor
public class ApiDefaultSetting {
    private final ApiConfig apiConfig;

    public StringBuilder getUrlBuilder() {
        return new StringBuilder("https://the-cocktail-db.p.rapidapi.com/search.php?s=vodka");
    }

    public String getResult(StringBuilder urlBuilder) {
        try {
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-RapidAPI-Key", apiConfig.getApiKey());
            conn.setRequestProperty("X-RapidAPI-requestURI", apiConfig.getApirequestURI());
            conn.setRequestProperty("X-RapidAPI-host", apiConfig.getApihost());
            BufferedReader br;
            String result;
            if (conn.getResponseCode() == 200 && conn.getResponseCode() <= 300) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                result = br.readLine();
                br.close();
                conn.disconnect();
            } else {
                conn.disconnect();
                result = "통신 실패\n Connection Error : " + conn.getRequestMethod();
            }
            return result;
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public JSONObject getResultJSON(String result) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(result);
            return (JSONObject) jsonObject.get("drinks");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
