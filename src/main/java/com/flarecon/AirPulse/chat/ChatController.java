package com.flarecon.AirPulse.chat;

import com.flarecon.AirPulse.tools.BasicTools;
import com.flarecon.AirPulse.tools.FlightTools;
import com.flarecon.AirPulse.tools.UserDetailTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder,
                          FlightTools flightTools,
                          UserDetailTools userDetailTools,
                          BasicTools basicTools) {

        this.chatClient = builder
                .defaultTools(flightTools, userDetailTools, basicTools)
                .build();
    }

    @PostMapping("/search-flight")
    public String searchOrBookFlight(@RequestBody String prompt) {
        return chatClient
                .prompt()
                .system("""
                    You are a flight search & booking assistant.
                
                    The user prompt contains the FULL conversation history in this format:
                    user: <message>
                    assistant: <message>
                    user: <message>
                    ...
                    The LAST "user:" line is the current message. Use all previous messages as context.
                
                    - use tools to gather possible details like user details or dates etc.
                
                    Your job is to extract:
                    - fromCity
                    - toCity
                    - startDate - departure from date (yyyy-MM-dd)
                    - endDate - departure to date (yyyy-MM-dd)
                    - passengers
                    - maxPrice
                
                    Defaults:
                    - passengers → 1
                
                    IMPORTANT RULES:
                    1. If startDate is missing → ASK the user for a date (DO NOT call tool)
                    2. If fromCity or toCity is missing → ASK user
                    3. ONLY call searchFlights when all required fields are present
                    4. Never assume unrealistic defaults like "today" for flights
                    5. Use the full conversation history to understand context and avoid re-asking questions already answered
                
                    Allowed cities:
                    Delhi, Mumbai, Bangalore, Hyderabad, Chennai, Kolkata,
                    Dubai, Singapore, Paris, London, New York, Toronto, Sydney, Frankfurt, Doha
                
                    Normalize inputs:
                    - "New Delhi" → "Delhi"
                    - "NYC" → "New York"
                
                    When all info is available:
                    → Call searchFlights tool

                    - always list flight id to user so that you can book that flight using id later
                
                    Or if Flight is finalised:
                    → Call bookFlight tool
                
                    Otherwise:
                    → Ask a follow-up question
                """)
                .user(prompt)
                .call()
                .content();
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {
        return chatClient.prompt()
                .system("""
                        You are a smart assistant. Use available tools to answer user's queries.
                        
                        The user prompt contains the FULL conversation history in this format:
                        user: <message>
                        assistant: <message>
                        user: <message>
                        ...
                        The LAST "user:" line is the current message. Use all previous messages as context
                        to maintain a coherent conversation. Do not re-ask questions already answered.
                        """)
                .user(prompt)
                .call()
                .content();
    }
}
