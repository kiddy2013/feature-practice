package practice.feature.gof.design.factory.kata.logprint;

public class ConsoleLogger implements Logger {
    @Override
    public void info(String message) {
        System.out.println("Logging to console: " + message);
    }
}
