package com.codingbox.monster;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import java.io.IOException;

public class CocktailAPI {
    public static void main(String[] args) {
        // OkHttpClient 생성
        OkHttpClient client = new OkHttpClient();

        // Request 생성
        Request request = new Request.Builder()
                .url("/Monster")
                .build();

        // 동기적으로 요청 보내기
        try (Response response = client.newCall(request).execute()) {
            // 응답 코드 확인
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // 응답 바디 가져오기
            ResponseBody body = response.body();
            if (body != null) {
                // 바디를 문자열로 읽기
                String responseBody = body.string();
                System.out.println(responseBody);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
