package pl.sdacademy.regular_expression.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpFinder {

    Pattern ipPattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");

    public boolean hasIp(String text) {
        Matcher timeMatcher = ipPattern.matcher(text);
        return timeMatcher.find();
    }

    public String getIp(String text) {
        Matcher dateMatcher = ipPattern.matcher(text);
        if (dateMatcher.find()) {

            return dateMatcher.group();
        } else return null;
    }

}
