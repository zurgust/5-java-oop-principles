package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private List<String> messages = new ArrayList<>();
    private int capacity;
    private MessageHandler proxiedHandler;

    public MemoryHandler(int capacity, MessageHandler proxiedHandler) {
        this.capacity = capacity;
        this.proxiedHandler = proxiedHandler;
    }

    @Override
    public void handle(String message) {
        messages.add(message);
        if (messages.size() >= capacity) {
            flush();
        }
    }

    public void flush() {
        for (String msg : messages) {
            proxiedHandler.handle(msg);
        }
        messages.clear();
    }
}
