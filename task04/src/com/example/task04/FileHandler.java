package com.example.task04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void handle(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(message);
            writer.newLine();
            writer.flush();  // Принудительный сброс данных в файл
        } catch (IOException e) {
            e.printStackTrace();  // Печать стека ошибок, чтобы видеть, что пошло не так
        }
    }
}
