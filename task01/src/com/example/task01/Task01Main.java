package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("Erriri");
        Logger logger2 = Logger.getLogger("Erriri");

        System.out.println(logger1 == logger2);  // true, оба логгера - один и тот же объект

        logger1.setLevel(Logger.Level.INFO);

        System.out.println(Logger.getLevel());

/*
        logger1.debug("This is a debug message");  // Не будет выведено, т.к. текущий уровень - INFO
        logger2.info("This is an info message");   // Выведется
        logger1.warning("This is a warning message");
        System.out.println(Logger.getLevel());
        logger2.error("This is an error message");
*/
        logger2.log(Logger.Level.INFO, "info");
        logger2.log(Logger.Level.DEBUG, "debug");
        logger2.log(Logger.Level.ERROR, "Error with code: %d", 404);


        // Логгирование с форматированием
        logger1.info("дрл message: %s", "INFO level");
        logger2.error("Error with code: %d", 404);
    }
}
