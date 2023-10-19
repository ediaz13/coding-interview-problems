package hackerrank.arrays.regex;

public class Main {
    public static void main(String[] args) {
        String IP = "000.12.12.034";
        System.out.println(IP.matches(new MyRegex().patternMine));
    }

}
