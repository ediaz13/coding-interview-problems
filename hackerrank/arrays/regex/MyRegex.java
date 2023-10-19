package hackerrank.arrays.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MyRegex {

    String patternMine = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    public boolean isValidIPAddress(String ipAddress) {
        Pattern pattern = Pattern.compile(patternMine);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
}
