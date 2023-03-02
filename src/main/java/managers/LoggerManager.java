package managers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerManager {
    private static Logger logger;

    public static void initLogger() {
        logger = Logger.getLogger(LoggerManager.class.getName());
    }

    public static void logInfo(String message) {
        if (logger == null) initLogger();
        logger.log(Level.INFO, message);

    }

}
