package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.IntFunction;

public class PriorityQueueUsage {
    private static PriorityQueue<Integer> pQueue=new PriorityQueue<>();

    public static void main(String argv[]){

        int[] arr={5,2,3,4,1};
        for(int value:arr){
            pQueue.add(value);
        }
        while(!pQueue.isEmpty()){

            System.out.println("pQueue  = " + pQueue.poll());
        }

        System.out.println("pQueue size= " + pQueue.size());
    }

    public static int compare(Integer a, Integer b){
        if(b>a){
            return -1;
        }
        else if(b==a){
            return 0;
        }
        else{
            return 1;
        }
    }
}
