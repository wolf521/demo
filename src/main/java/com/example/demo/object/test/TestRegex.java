package com.example.demo.object.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cuizhixiang on 2017/6/19.
 **/
public class TestRegex {
    public static void main(String agrs[]){
        new TestRegex().test();
    }
    public void test(){
        Pattern pattern = Pattern.compile("^1[34578]\\d{9}$");
        Matcher matcher = pattern.matcher("15953185719");
        boolean b = matcher.matches();
        // 校验手机号
        System.out.println(Pattern.matches("^1[34578]\\d{9}$","15953185719"));

        // 校验汉字
        System.out.println(Pattern.matches("^[\\u4e00-\\u9fa5]{0,}$","四子"));
        // 校验URL
        System.out.println(Pattern.matches("^(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&:/~\\+#]*[\\w\\-\\@?^=%&/~\\+#])?$","http://www.baidu.com"));
    }
}
