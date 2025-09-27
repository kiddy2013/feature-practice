package practice.feature.gof.design.factory.kata.logprint;

/**
 * 🔧 Kata 2：日志记录器（Logger）系统
 * 场景：
 * 支持写日志到文件、数据库、控制台。
 *
 * @program: java-feature-demo
 * @description:
 */
public class MainEnter {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new FileLoggerFactory();
        Logger logger = loggerFactory.createLogger();
        logger.info("Hello World!");

        loggerFactory = new DataBaseLoggerFactory();
        logger = loggerFactory.createLogger();
        logger.info("Hello World!");

        loggerFactory = new ConsoleLoggerFactory();
        logger = loggerFactory.createLogger();
        logger.info("Hello World!");
    }
}
