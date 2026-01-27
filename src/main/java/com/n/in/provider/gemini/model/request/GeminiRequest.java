package com.n.in.provider.gemini.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiRequest {
    /**
     * Lista de objetos ContentDto, que representan turnos de conversación
     * o el mensaje inicial del usuario.
     */
    private List<Content> contents;
}