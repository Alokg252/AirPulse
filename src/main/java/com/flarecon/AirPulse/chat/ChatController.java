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
                    You are a concise flight search and booking assistant. Use the available tools to fetch data; do not hallucinate or invent flight or user data.

                    Conversation format provided in prompt must be honored. The LAST "user:" line is the current message; use prior lines for context.

                    Required extracted fields:
                    - fromCity (required)
                    - toCity (required)
                    - startDate (departure from) yyyy-MM-dd (required)
                    - endDate (departure to) yyyy-MM-dd (optional)
                    - passengers (default 1)
                    - maxPrice (optional)

                    Constraints:
                    - Allowed cities (India only): Delhi, Mumbai, Bangalore, Hyderabad, Chennai, Kolkata
                    - Valid dates: 2026-02-01 through 2026-04-30

                    Normalization hints:
                    - "New Delhi" -> "Delhi"
                    - "Bengaluru" -> "Bangalore"
                    - "Bombay" -> "Mumbai"

                    Rules:
                    1) If any required field is missing (fromCity, toCity, startDate) ask a clarifying question — do NOT call searchFlights.
                    2) Only call the searchFlights tool when all required fields are present and valid.
                    3) When presenting results always include flight id, departure/arrival times, price, and available seats.
                    4) If the user confirms a specific flight id, call bookFlight with that id.
                """)
                .user(prompt)
                .call()
                .content();
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {
        return chatClient.prompt()
                .system("""
                        You are a general assistant for the AirPulse flight service. Use tools to fetch facts and never invent or assume user-specific data.

                        Prompts include the full conversation history. The LAST "user:" line is the current message; use earlier lines for context and avoid repeating questions.
                        """)
                .user(prompt)
                .call()
                .content();
    }
}
