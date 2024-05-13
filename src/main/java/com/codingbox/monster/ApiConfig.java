package com.codingbox.monster;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ApiConfig {
    @Value(/* 요기에 다른 사람은 볼수 없는 파일에서 값을 읽어 와야함*/)
    private String apiKey;
    @Value(/* 이곳 또한 마찬가지 */)
    private String apiHost;
}
