package practice.feature.gof.design.factory.kata.logprint;

public class DataBaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DataBaseLogger();
    }
}
