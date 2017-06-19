package by.kooks.mobile.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Pattern;

public class InputDataValidator {
    private static Logger logger = LogManager.getLogger(InputDataValidator.class);
    private static final Pattern PATTERN = Pattern.compile("([a-zA-Z]{9,10})\\s([A-Za-z0-9_]+)\\s((\\d{0,5}\\s){7})[A-Za-z0-9]*");

    public boolean validator(String line) {
        if (PATTERN.matcher(line).matches())return true;
         else {
            logger.log(Level.WARN, "Invalid line: " + line);
        }
        return false;
    }
}
