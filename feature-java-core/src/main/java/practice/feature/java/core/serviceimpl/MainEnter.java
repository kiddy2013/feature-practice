package practice.feature.java.core.serviceimpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainEnter {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^\\d");
        Matcher matcher = pattern.matcher("0:00-24:00");
        System.out.println(matcher.find());
    }
}
