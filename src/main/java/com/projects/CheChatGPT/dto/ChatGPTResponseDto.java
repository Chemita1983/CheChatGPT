package com.projects.CheChatGPT.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTResponseDto {

    String id;
    String object;
    String created;
    String model;
    List<ChatGPTChoices> choices;
    ChatGPTUsage usage;

    public String getChatGPTTextResponse(){
        return this.getChoices().get(0).getText();
    }
}
