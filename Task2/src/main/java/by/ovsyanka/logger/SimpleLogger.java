package by.ovsyanka.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLogger {
    private static final Logger logger = LoggerFactory.getLogger(SimpleLogger.class);

    public static void writeLog(String log) {
        logger.debug(log);
    }
}
