package com.projects.CheChatGPT.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.projects.CheChatGPT.dto.ChatGPTResponseDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChatGpt {
    private static final URI CHAT_GPT_URI = URI.create("https://api.openai.com/v1/completions");

    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    public static String send(String textToSend) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            ObjectNode jsonBody = mapper.createObjectNode();
            jsonBody.put("prompt", textToSend);
            jsonBody.put("temperature", 1);
            jsonBody.put("model", "text-davinci-003");
            jsonBody.put("n", 1);
            jsonBody.put("max_tokens", 500);
            jsonBody.put("stop", ".");

            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(CHAT_GPT_URI)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer YOUR-API_KEY")
                    .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(jsonBody)));

            HttpResponse<String> response = HTTP_CLIENT.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());

            ChatGPTResponseDto chatGPTResponseDto = mapper.readValue(response.body(), ChatGPTResponseDto.class);

            return chatGPTResponseDto.getChatGPTTextResponse();

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
