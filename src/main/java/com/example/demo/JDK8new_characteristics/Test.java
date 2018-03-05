package com.example.demo.JDK8new_characteristics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 * JDK1.8新特性
 */
public class Test {
    public static void main(String[] agrs) {
//        1. 允许在接口中有默认方法实现
//
//        Java 8允许给接口添加一个非抽象的方法实现，需要使用 default关键字，这个特征又叫做扩展方法，示例如下：
//
//        interface Formula {
//            double calculate(int a);
//            default double sqrt(int a) {
//                return Math.sqrt(a);
//            }
//        }
//        2. Lambda表达式
//
//        首先看看在老版本的Java中是如何排列字符串的：
//
//        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });
//        只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。通常做法都是创建一个匿名的比较器对象然后将其传递给sort方法。在Java 8 中你就没必要使用这种传统的匿名对象的方式了，Java 8提供了更简洁的语法，lambda表达式：
//
//        Collections.sort(names, (String a, String b) -> {
//            return b.compareTo(a);
//        });
//        看到了吧，代码变得更短且更具有可读性，但是实际上还可以写得更短：
//
//        Collections.sort(names, (String a, String b) -> b.compareTo(a));
//        还可以写得更短：
//
//        Collections.sort(names, (a, b) -> b.compareTo(a));
//        Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型。接下来我们看看lambda表达式还能作出什么更方便的东西来：
//        3. 函数式接口
//
//        Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，通常是接口类型。而“函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法。因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
//
//        我们可以将lambda表达式当作任意只包含一个抽象方法的接口类型，确保你的接口一定达到这个要求，你只需要给你的接口添加 @FunctionalInterface 注解，编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的。
//
//        @FunctionalInterface
//        interface Converter<F, T> {
//            T convert(F from);
//        }
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
//        Integer converted = converter.convert("123");
//        System.out.println(converted);    // 123
//        需要注意如果@FunctionalInterface如果没有指定，上面的代码也是对的。
//        4. 方法和构造函数引用
//        5. Lambda的范围
//        6. 内置函数式接口
//
//        Predicate，Function ，Supplier ，Consumer ，Comparator ，Optional ，Stream 接口
//        7. Streams
//        8. Parallel Streams
//        9. Map
//        10. 时间日期API
//        11. Annotations注解


    }
}
