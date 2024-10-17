package com.example.task04;
import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }


    private String name;
    private static Level currentLvl = Level.DEBUG;
    private static final Map<String, Logger> loggers = new HashMap<>();
    private List<MessageHandler> handlers = new ArrayList<>();

    // Приватный конструктор
    private Logger(String name) {
        this.name = name;
    }

    public void addHandler(MessageHandler handler) {
        handlers.add(handler);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        return loggers.computeIfAbsent(name, Logger::new); // Создание логгера, если его ещё нет
    }

    public void setLevel(Level level) {
        currentLvl = level;
    }



    public static Level getLevel(){
        return currentLvl;
    }

    // Метод для форматирования и вывода сообщений
    private void logMessage(Level level, String message) {
        if (level.ordinal() >= currentLvl.ordinal()) {  // Проверяем уровень важности
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String dateTime = dateFormat.format(new Date());
            String formattedMessage = "[" + level + "] " + dateTime + " " + name + " - " + message;

            // Отправка сообщения всем зарегистрированным обработчикам
            for (MessageHandler handler : handlers) {
                handler.handle(formattedMessage);
            }
        }
    }

    // Методы для каждого уровня логирования
    public void debug(String message) {
        logMessage(Level.DEBUG, message);
    }

    public void debug(String format, Object... args) {
        logMessage(Level.DEBUG, String.format(format, args));
    }

    public void info(String message) {
        logMessage(Level.INFO, message);
    }

    public void info(String format, Object... args) {
        logMessage(Level.INFO, String.format(format, args));
    }

    public void warning(String message) {
        logMessage(Level.WARNING, message);
    }

    public void warning(String format, Object... args) {
        logMessage(Level.WARNING, String.format(format, args));
    }

    public void error(String message) {
        logMessage(Level.ERROR, message);
    }

    public void error(String format, Object... args) {
        logMessage(Level.ERROR, String.format(format, args));
    }

    // Универсальные методы log для всех уровней
    public void log(Level level, String message) {
        logMessage(level, message);
    }

    public void log(Level level, String format, Object... args) {
        logMessage(level, String.format(format, args));
    }

}
