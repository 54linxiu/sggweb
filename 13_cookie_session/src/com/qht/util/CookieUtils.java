package com.qht.util;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class CookieUtils {

    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name == null || cookies == null || cookies.length == 0){
            return null;
        }
        Stream<Cookie> stream = Arrays.stream(cookies);
        Optional<Cookie> first = stream.filter(e -> name.equals(e.getName())).findFirst();
        Cookie cookie = first.get();
        if (cookie != null){
            return cookie;
        }
        return null;
    }
}
