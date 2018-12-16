package pl.sdacademy.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	static Logger logger = LoggerFactory.getLogger(LoggerTest.class);

	public static void main(String[] args) {
		logger.info("This is info log");
		logger.debug("This is debug message");
	}
}
