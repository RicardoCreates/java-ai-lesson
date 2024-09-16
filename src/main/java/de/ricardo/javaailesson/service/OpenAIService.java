package de.ricardo.javaailesson.service;

import de.ricardo.javaailesson.model.OpenAIRequest;
import de.ricardo.javaailesson.model.OpenAiMessage;
import de.ricardo.javaailesson.model.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service // -> @Component
public class OpenAIService {

    private final RestClient client;

    public OpenAIService(@Value("${BASE_URL}") String baseUrl,
                         @Value("${AUTH_KEY}") String key) {
        client = RestClient.builder()
                .defaultHeader("Authorization", "Bearer" + key)
                .baseUrl(baseUrl)
                .build();
    }


    public String getAnswerFromOpenAi(String question) {
        OpenAIRequest request = new OpenAIRequest("gpt-4o-mini",
                List.of(new OpenAiMessage("user", question)),
                0.2
        );

        OpenAiResponse response = client.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(OpenAiResponse.class);

        return response.getAnswer();

    }
}
