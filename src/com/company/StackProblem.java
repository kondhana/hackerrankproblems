package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class StackProblem {
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            Deque<String> deque= new ArrayDeque<>();
            if(input.length()==1){
                System.out.println("false");
                continue;
            }
            boolean match=true;
            for (int i = 0; i < input.length(); i++) {
                String tmpStr=String.valueOf(input.charAt(i));
                switch (tmpStr) {
                    case "[", "{", "(" -> deque.addFirst(tmpStr);
                    case "]" -> match = match & !deque.isEmpty() && deque.removeFirst().equals("[");
                    case "}" -> match = match & !deque.isEmpty() && deque.removeFirst().equals("{");
                    case ")" -> match = match & !deque.isEmpty() && deque.removeFirst().equals("(");
                    default -> match = false;
                }
            }
            System.out.println( match & deque.isEmpty());
        }

    }
}

