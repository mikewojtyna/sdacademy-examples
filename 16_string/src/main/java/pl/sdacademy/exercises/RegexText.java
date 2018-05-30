package pl.sdacademy.exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexText {

    private static final String log = "64.242.88.10 - - [07/Aug/2004:16:05:49 -0800] \"GET /twiki/bin/edit/StringTest1/Double_bounce_sender?topicparent=StringTest1.ConfigurationVariables HTTP/1.1\" 401 12846\n"
            + "192.168.88.22 - - [07/Apr/2004:16:06:51 -0800] \"GET /twiki/bin/rdiff/TWiki/NewUserTemplate?rev1=1.3&rev2=1.2 HTTP/1.1\" 200 4523\n"
            + "64.242.88.10 - - [07/May/2004:16:10:02 -0800] \"GET /mailman/listinfo/hsdivision HTTP/1.1\" 200 6291\n"
            + "192.168.8.11 - - [07/Dec/2004:16:11:58 -0800] \"GET /twiki/bin/view/TWiki/WikiSyntax HTTP/1.1\" 200 7352\n"
            + "64.242.88.12 - - [07/Nov/2004:16:20:55 -0800] \"GET /twiki/bin/view/StringTest1/DCCAndPostFix HTTP/1.1\" 200 5253";

    public static void main(String[] args) {
        Pattern ipPattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
        Pattern datePattern = Pattern.compile("\\d{2}/[a-zA-Z]{3}/\\d{4}");

        System.out.println(log);
        Matcher ipMatcher = ipPattern.matcher(log);
        Matcher dateMatcher = datePattern.matcher(log);

        while(ipMatcher.find()) {
            System.out.println("Found ips: " + ipMatcher.group());
        }
        while(dateMatcher.find()) {
            System.out.println("Found dates: " + dateMatcher.group());
        }
    }
}
