package com.example.demothymeleaf.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeaderUtils {
    public static boolean isPc(String userAgent) {
        if (userAgent == null) {
            return true;
        }
        // Regular expressions to match common patterns for mobile devices
        Pattern pattern = Pattern.compile("Mobile|iP(hone|od|ad)|Android|BlackBerry|IEMobile|Kindle|NetFront|Silk-Accelerated|(hpw|web)OS|Fennec|Minimo|Opera M(obi|ini)|Blazer|Dolfin|Dolphin|Skyfire|Zune", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(userAgent);

        return !matcher.find();
    }
}
