package de.ricardo.javaailesson.controller;

import de.ricardo.javaailesson.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/open")
@RequiredArgsConstructor // Für Dependency Injection -> "Verkapselung von Controller Service Repo
public class OpenAiController {

    private final OpenAIService service;

    @PostMapping
    public String getAnswerFromOpenAi(@RequestBody String question){
        return service.getAnswerFromOpenAi(question);
    }
}
