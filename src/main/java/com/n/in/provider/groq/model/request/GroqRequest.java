package com.n.in.provider.groq.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.n.in.provider.groq.model.reponse.Message;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroqRequest {
    private String model;
    private List<Message> messages;
}
