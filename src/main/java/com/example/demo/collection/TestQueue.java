package com.example.demo.collection;

import com.example.model.User;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by cuizhixiang on 2017/6/22.
 **/
public class TestQueue {
    public static void main(String agrs[]){
        TestQueue.test1();
    }
    public static void test(){
        Queue<User> queue = new LinkedList<>();
        queue.add(new User("银杏","156598486",456));
        queue.add(new User("金丝楠木","156598486",456));
        queue.add(new User("红木","156598486",456));
        queue.offer(new User("乌木","15644645",54));
        queue.offer(new User("红杉","15644645",54));
        queue.offer(new User("沉香木","15644645",54));
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.remove();
        System.out.println("************************");
        Iterator<User> iterator = queue.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void test1(){
        PriorityQueue pq = new PriorityQueue();
        pq.offer(1);
        pq.offer(3);
        pq.offer(9);
        pq.offer(6);
        pq.offer(5);
        pq.offer(8);
        pq.offer(4);
        pq.offer(2);
        System.out.println(pq.toString());
        while(pq.size()>0){
            System.out.print(pq.poll() + "  ");
        }
    }
}
