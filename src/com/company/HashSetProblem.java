package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashSet<String> dataSet=new HashSet();
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        for(int i=0;i<t;i++){
            dataSet.add(pair_left[i]+"-"+pair_right[i]);
            System.out.println(dataSet.size());
        }

    }
}
