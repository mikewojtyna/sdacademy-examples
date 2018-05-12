package pl.sdacademy.logger;


import org.apache.log4j.Logger;

public class LoggerTest {
    static Logger logger = Logger.getLogger(LoggerTest.class.getName());

    public static void main(String[] args) {
        logger.info("This is info log");
        logger.debug("This is debug message");
    }
}
