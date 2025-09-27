package practice.feature.gof.design.factory.kata.logprint;

public class DataBaseLogger implements Logger {
    @Override
    public void info(String message) {
        System.out.println("Logging to database: " + message);
    }
}
