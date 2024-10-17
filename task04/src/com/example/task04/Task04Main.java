package com.example.task04;
import java.io.File;

public class Task04Main {
    public static void main(String[] args) {
        File logDirectory = new File("logs");
        if (!logDirectory.exists()) {
            logDirectory.mkdirs();  // Создаём все недостающие директории
        }

        // Получение логгера
        Logger logger = Logger.getLogger("AdvancedLogger");

        // Добавление обработчиков
        logger.addHandler(new ConsoleHandler());
        logger.addHandler(new FileHandler("logs/log.txt"));
        logger.debug("This is a debug message.");

        // Установка уровня логирования
        logger.setLevel(Logger.Level.INFO);

        // Логирование сообщений
        logger.info("This is an info message.");
        logger.warning("This is a warning message.");
        logger.error("This is an error message.");
    }
}
