package com.example.demo.date.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by cuizhixiang on 2017/6/13.
 **/
public class TestDate {
    public static void main(String agrs[]){
        try{
           // new TestDate().test4();
        }catch (Exception e){
            e.printStackTrace();
        }
        new TestDate().test5();
    }
    public void test()throws InterruptedException{
        //创建一个当前系统时间对象
        Date date1 = new Date();
        //将当前线程休眠4秒钟
        Thread.sleep(4000);
        //休眠4秒钟后，创建date2时间对象
        Date date2 = new Date();
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date2));
        System.out.println(date1.compareTo(date2));
        date2.setTime(date1.getTime());
        System.out.println(date1.equals(date2));
    }

    public void test2(){
//        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.get(Calendar.YEAR));
//        cal.add(Calendar.MONTH, 12);
//        System.out.println(cal.get(Calendar.YEAR));
//        System.out.println("add会进位");
//        System.out.println("==================================");
//        cal = Calendar.getInstance();
//        System.out.println(cal.get(Calendar.YEAR));
//        cal.roll(Calendar.MONTH, 12);
//        System.out.println(cal.get(Calendar.YEAR));
//        System.out.println("roll不会进位");
//        System.out.println("==================================");

//        //获得年月日时分秒毫秒
//        Calendar cal = Calendar.getInstance();
//        System.out.println("年："+cal.get(Calendar.YEAR));
//        System.out.println("月："+cal.get(Calendar.MONTH));
//        System.out.println("日："+cal.get(Calendar.DATE));
//        System.out.println("时："+cal.get(Calendar.HOUR));
//        System.out.println("分："+cal.get(Calendar.MINUTE ));
//        System.out.println("秒："+cal.get(Calendar.SECOND));
//        System.out.println("毫秒："+cal.get(Calendar.MILLISECOND));
//        System.out.println("==================================");
//        System.out.println(cal.getActualMaximum(Calendar.MONTH));
//        System.out.println(cal.getActualMinimum(Calendar.MONTH));
//        System.out.println("今年到此时的星期数："+cal.get(Calendar.WEEK_OF_YEAR));
//        System.out.println("今年到此时的天数："+cal.get(Calendar.DAY_OF_YEAR));
//        System.out.println("今月到此时的星期数："+cal.get(Calendar.WEEK_OF_MONTH));
//        System.out.println("今月到此时的天数："+cal.get(Calendar.DAY_OF_MONTH));
//        System.out.println("今月到此时的天数："+cal.get(Calendar.DAY_OF_MONTH));
//        System.out.println("这个星期到此时的天数："+cal.get(Calendar.DAY_OF_WEEK));
//        System.out.println("这个月有多少天："+cal.getActualMaximum(Calendar.DATE));
//        System.out.println("到此时的小时："+cal.get(Calendar.HOUR_OF_DAY));
//        System.out.println("指示当前月中的第几个星期："+cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//        System.out.println("距 GMT 的大致偏移量：毫秒值"+cal.get(Calendar.ZONE_OFFSET));

        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.YEAR,-1);
        calendar.add(calendar.MONTH,1);
        for(int i = 0;i<12;i++) {
            int year = calendar.get(calendar.YEAR);
            int month = calendar.get(calendar.MONTH)+1;
            if (month == 0) {
                month = 12;
            }
            System.out.println("年："+year);
            System.out.println("月："+month);
            System.out.println("日："+calendar.getActualMaximum(Calendar.DATE));
            calendar.add(calendar.MONTH,1);
        }
    }
    public void test3(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getActualMaximum(Calendar.MONTH));
        System.out.println(cal.getActualMinimum(Calendar.MONTH));
        System.out.println(cal.getActualMaximum(Calendar.DATE));
        System.out.println(cal.getActualMinimum(Calendar.DATE));
        System.out.print("1月:"+Calendar.JANUARY+", ");
        System.out.print("2月:"+Calendar.FEBRUARY+", ");
        System.out.print("3月:"+Calendar.MARCH+", ");
        System.out.print("4月:"+Calendar.APRIL+", ");
        System.out.print("5月:"+Calendar.MAY+", ");
        System.out.println("6月:"+Calendar.JUNE+", ");
        System.out.print("7月:"+Calendar.JULY+", ");
        System.out.print("8月:"+Calendar.OCTOBER+", ");
        System.out.print("9月:"+Calendar.SEPTEMBER+", ");
        System.out.print("10月:"+Calendar.OCTOBER+", ");
        System.out.print("11月:"+Calendar.NOVEMBER+", ");
        System.out.println("12月:"+Calendar.DECEMBER+", ");
        System.out.print("星期日:"+Calendar.SUNDAY+", ");
        System.out.print("星期一:"+Calendar.MONDAY+", ");
        System.out.print("星期二:"+Calendar.TUESDAY+", ");
        System.out.println("星期三:"+Calendar.WEDNESDAY+", ");
        System.out.print("星期四:"+Calendar.THURSDAY+", ");
        System.out.print("星期五:"+Calendar.FRIDAY+", ");
        System.out.print("星期六:"+Calendar.SATURDAY);
    }

    public void test4() throws ParseException{
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getInstance();
        System.out.println(dateFormat.format(date));
        DateFormat dateFormat1 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        DateFormat dateFormat12 = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        DateFormat dateFormat13 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        DateFormat dateFormat14 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        System.out.println("SHORT:"+dateFormat1.format(date));
        System.out.println("LONG:"+dateFormat12.format(date));
        System.out.println("FULL:"+dateFormat13.format(date));
        System.out.println("MEDIUM:"+dateFormat14.format(date));
        DateFormat dateFormat2 = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
        DateFormat dateFormat22 = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);
        DateFormat dateFormat23 = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        DateFormat dateFormat24 = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        System.out.println("SHORT:"+dateFormat2.format(date));
        System.out.println("LONG:"+dateFormat22.format(date));
        System.out.println("FULL:"+dateFormat23.format(date));
        System.out.println("MEDIUM:"+dateFormat24.format(date));
        System.out.println("北京时间:"+dateFormat12.format(date)+" "+dateFormat22.format(date));
        DateFormat dateFormat3 = DateFormat.getDateTimeInstance();
        System.out.println(dateFormat3.format(date));
        System.out.println("********************************");
        TimeZone timeZone = dateFormat.getTimeZone();
        System.out.println("本机默认时区："+timeZone.getDefault());
        System.out.println("时区名称："+timeZone.getDisplayName());
        System.out.println("********************************");
        Date date1 = dateFormat.parse("17-6-13 下午2:08");
        System.out.println("解析时间字符串："+date1);

    }
    public void test5(){
        Date date = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(simple.format(date));
        simple = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(simple.format(date));
    }
}
