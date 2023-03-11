package com.projects.CheChatGPT.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.projects.CheChatGPT.dto.ChatGPTResponseDto;
import com.projects.beans.Portal;
import org.springframework.stereotype.Component;

import java.net.URI;


@Component
public class ChatGpt {

    private static final URI CHAT_GPT_URI = URI.create("https://api.openai.com/v1/completions");

    private final Portal portal;

    public ChatGpt(Portal portal){
        this.portal = portal;
    }

    private static final String[] HEADERS;

    static {
        HEADERS = new String[]
                {"Content-Type", "application/json","Authorization",
                        "Bearer YOUR_API_KEY"} ;
    }

    public String send(String textToSend) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            ObjectNode jsonBody = mapper.createObjectNode();
            jsonBody.put("prompt", textToSend);
            jsonBody.put("temperature", 1);
            jsonBody.put("model", "text-davinci-003");
            jsonBody.put("n", 1);
            jsonBody.put("max_tokens", 500);

            String response = portal.post(CHAT_GPT_URI, HEADERS, jsonBody);

            ChatGPTResponseDto chatGPTResponseDto = mapper.readValue(response, ChatGPTResponseDto.class);

            return chatGPTResponseDto.getChatGPTTextResponse();

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
