package com.example.demo.mail.ymlutil;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by cuizhixiang on 2017/5/31.
 **/
public class MailConfig {
    private static final String PROPERTIES_DEFAULT = "mailConfig.properties";
    public static String host;
    public static Integer port;
    public static String userName;
    public static String passWord;
    public static String emailForm;
    public static String timeout;
    public static String personal;
    public static Properties properties;
    static{
        init();
    }
    private static void init() {
//        File dumpFile = new File("mailConfig.yml");
//        Map father = Yaml. loadType(dumpFile, HashMap.class);
//        for(Object key:father.keySet()){
//            System.out.println(key+":\t"+father.get(key).toString());
//        }
    }
}
