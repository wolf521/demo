package com.example.demo.collection;

import java.util.*;

/**
 * Created by cuizhixiang on 2017/6/23.
 **/
public class TestCollections {
    public static void main(String agrs[]) {
        TestCollections.test4();
    }

    public static void test() {
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("5");
        list.add("4");
        list.add("6");
        list.add("7");
        // 当参数为正数时，将list集合的后参数个元素“整体”移动到前面，当参数为负数时，将list集合的前参数个元素“整体”移动到后面
        Collections.rotate(list, 2);
        for (String str : list) {
            System.out.println(str);
        }
        // 反转指定列表中元素的顺序。
        Collections.reverse(list);
        // 对List集合元素进行随机排序。
        Collections.shuffle(list);
        // 根据元素的自然顺序对指定list集合的元素按升序进行排序
        Collections.sort(list);
        // 根据指定Comperator产生的顺序对List集合元素进行排序。
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) > 0) return -1;
                return 0;
            }
        });
        // 将指定List集合中的i处元素和j处元素进行交换。
        Collections.swap(list, 0, 7);
    }

    public static void test1(){
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("5");
        list.add("4");
        list.add("6");
        list.add("7");
        System.out.println(list);

        //如果父List中没有出现这样的子List，则返回-1。
        Collections.replaceAll(list,"5","9");
        // 返回指定集合中指定元素的出现次数。
        Collections.frequency(list,"9");
        // 根据Comparator指定的顺序，返回给集合中的最小元素。
        Collections.min(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2) > 0) return -1;
                return 0;
            }
        });
        // 根据元素的自然顺序，返回给集合中的最小元素。
        Collections.min(list);
        // 根据Comparator指定的顺序，返回给集合中的最大的元素。
        Collections.max(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2) > 0) return -1;
                return 0;
            }
        });
        // 根据元素的自然顺序，返回给定集合中的最大元素。
        Collections.max(list);
        // 使用二分法搜索指定的List集合，用来获得指定对象key在List集合中的索引。list必须有序
        Collections.binarySearch(list,"3");
        // 使用指定元素obj替换指定List集合中的所有元素。
        Collections.fill(list,"9");
    }
    public static void test3(){
        Collection<String> collection = Collections.synchronizedCollection(new ArrayList<String>());
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Set<String> set = Collections.synchronizedSet(new HashSet<String>());
        Map<String,String> map = Collections.synchronizedMap(new HashMap<String,String>());
    }
    public static void test4(){
        Collection<String> collection = new ArrayList<String>();
        Collection<String> collection1 = new ArrayList<String>();
        collection.add("a");
        collection1.add("b");
        System.out.println(Collections.disjoint(collection1,collection));
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        List<String> list1 = new ArrayList<String>();
        list1.add("6");
        list1.add("7");
        list1.add("8");
        list1.add("9");
        Collections.addAll(list1,  new  String[list.size()]);
        Collections.copy(list1,list);
        System.out.println(list);
        System.out.println(list1);
    }
    public static void test5(){
        //创建一个空的，不可变的Set对象
        Set set = Collections.emptySet();
        //创建一个只包含特定对象的List集合
        List<String> list = Collections.singletonList("abc");
        //创建一个普通的Map集合，将Map集合转变为一个不能在更改的Map对象
        Map map = new HashMap();
        map.put("123", "abc");
        map.put("456", "def");
        Map unmodifiableMap = Collections.unmodifiableMap(map);
    }
}

class Com implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}