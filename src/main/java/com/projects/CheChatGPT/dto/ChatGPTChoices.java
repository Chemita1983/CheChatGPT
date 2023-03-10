package com.projects.CheChatGPT.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTChoices {
    String text;

    String index;

    String logprobs;

    @JsonProperty("finish_reason")
    String finishReason;
}
