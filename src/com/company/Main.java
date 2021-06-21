package com.company;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        double median=0;
        int notifications=0;
        System.out.println("Result.activityNotifications::"+expenditure.getClass());
        int wholeListSize=expenditure.size();
        Integer[] tmpArray=new Integer[d];
        if(d<wholeListSize){
            for(int i=0;i+d<wholeListSize;i++){
                long start=System.currentTimeMillis();
                int toPoint=wholeListSize<=(i+d)?wholeListSize:i+d;
                //    System.out.println(toPoint);
               // long timeMills= System.currentTimeMillis();

              //  System.out.println("toPoint = " + toPoint);
                copyArray(expenditure,tmpArray,i,d);
                //System.arraycopy(expenditure.toArray(tmpArray),
                //i,tmpArray,0,d);
                //List<Integer> tmpList=expenditure.toArray(tmpArray).subList(i,toPoint);
                //  System.out.println(tmpList);
                //Set<Integer>tmpSet=tmpList.stream().collect(Collectors.toSet());
                //System.out.println("List prep took = " + (System.currentTimeMillis()-timeMills));
                Arrays.parallelSort(tmpArray);//stream(tmpArray).sorted().toArray(Integer[]::new);
                int tmpListSize=tmpArray.length;

                if(tmpListSize%2>0){
                    median=tmpArray[((tmpListSize/2))];
                }
                else{
                    // System.out.println("tmpList = " + tmpList);
                    //System.out.println("tmpList.get((d/2)) = " + tmpList.get((d/2)));
                    //System.out.println("tmpList.get((d/2)+1) = " + tmpList.get((d/2)+1));
                    if(tmpListSize==2){
                        median=tmpArray[0]+tmpArray[1];
                        median=median/2;
                    }
                    else {
                        int mid = (tmpListSize / 2);

                        //     System.out.println("tmpList.get(mid) = " + tmpList.get(mid));
                        //     System.out.println("tmpList.get(mid- 1) = " + tmpList.get(mid- 1));
                        median = tmpArray[mid]
                                + tmpArray[mid- 1];
                        median /= 2;
                        //     System.out.println("median = " + median);
                    }
                }
                //   System.out.println("median::"+median*2+" item::"+expenditure.get(toPoint));
                if(expenditure.get(toPoint)>=(median*2)){
                    //System.out.println("Notify");
                    notifications++;
                }
                System.out.println("Loop takes = " + (System.currentTimeMillis()-start));
            }
        }
        return notifications;
    }

    private static void copyArray(List<Integer> expenditure, Integer[] tmpArray, int i, int d) {
        for(int j=0;i<d;i++,j++){
            tmpArray[j]=expenditure.get(i);
        }
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
