package com.projects.CheChatGPT.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTUsage {

    @JsonProperty("prompt_tokens")
    String prompTokens;

    @JsonProperty("completion_tokens")
    String completionTokens;

    @JsonProperty("total_tokens")
    String totalTokens;
}
