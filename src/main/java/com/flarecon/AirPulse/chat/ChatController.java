package com.flarecon.AirPulse.chat;

import com.flarecon.AirPulse.tools.FlightTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder, FlightTools tools) {
        this.chatClient = builder
                .defaultTools(tools)
                .build();
    }
    @PostMapping
    public String chat(@RequestBody String userPrompt) {

        String today = LocalDate.now().toString();

        return chatClient
                .prompt()
                .system("""
                    You are a flight search assistant.
                
                    Today's date is: %s
                
                    Your job is to extract:
                    - fromCity
                    - toCity
                    - startDate (yyyy-MM-dd)
                    - endDate (yyyy-MM-dd)
                    - passengers
                    - maxPrice
                
                    Defaults:
                    - passengers → 1
                
                    IMPORTANT RULES:
                    1. If startDate is missing → ASK the user for a date (DO NOT call tool)
                    2. If fromCity or toCity is missing → ASK user
                    3. ONLY call searchFlights when all required fields are present
                    4. Never assume unrealistic defaults like "today" for flights
                
                    Allowed cities:
                    Delhi, Mumbai, Bangalore, Hyderabad, Chennai, Kolkata,
                    Dubai, Singapore, Paris, London, New York, Toronto, Sydney, Frankfurt, Doha
                
                    Normalize inputs:
                    - "New Delhi" → "Delhi"
                    - "NYC" → "New York"
                
                    When all info is available:
                    → Call searchFlights tool
                
                    Otherwise:
                    → Ask a follow-up question
                """.formatted(today))
                .user(userPrompt)
                .call()
                .content();
    }
}
