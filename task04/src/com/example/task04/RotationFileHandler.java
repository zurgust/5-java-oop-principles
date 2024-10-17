package com.example.task04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler implements MessageHandler {
    private String filePrefix;
    private DateTimeFormatter dateFormatter;

    public RotationFileHandler(String filePrefix) {
        this.filePrefix = filePrefix;
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH");
    }

    @Override
    public void handle(String message) {
        String fileName = filePrefix + "_" + LocalDateTime.now().format(dateFormatter) + ".log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
