package com.example.demo.connect;

/**
 * Created by lianxifangshi on 2017/10/30.
 */
public class MyConnect {
    public static void main(String agrs[]){
        int[] arr = {1,5,9,3,8,7,2};
        int[] index = {0,1,2,1,3,0,4,1,5,0,6};
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < 11;i++){
            stringBuffer.append(arr[index[i]]);
        }
        System.out.println(stringBuffer.toString());
    }
}
