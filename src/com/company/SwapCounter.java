package com.company;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SwapCounter {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swapCounter=0;
        int firstVar=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=(i+1)) {
                firstVar = arr[i];
            }
            else{
                continue;
            }
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]==(i+1)){
                    //System.out.println("Swaping (i,j)= (" +i+","+j+")::("+firstVar+","+arr[j]+")" );
                    int tmp=arr[j];
                    arr[j]=firstVar;
                    arr[i]=tmp;
                    swapCounter++;
                    break;
                }
            }
        }
        //Arrays.stream(arr).forEach(System.out::println);

        return swapCounter;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
