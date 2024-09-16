package de.ricardo.javaailesson.model;

import java.util.List;

/**
 * {
 *      "model": "gpt-4o-mini",
 *      "messages": [{"role": "user", "content": "Say this is a test!"}],
 *      "temperature": 0.2
 *    }
 */

public record OpenAIRequest(String model, List<OpenAiMessage> messages, double temperature) {
}
