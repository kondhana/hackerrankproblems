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


    public static void copyArray(List<Integer> expenditure, Integer[] tmpArray, int i,
                                 int d) {
        for (int j = 0; i < d; i++) {
            tmpArray[j++] = expenditure.get(i);
        }
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        double median = 0;
        int notifications = 0;
        System.out.println("Result.activityNotifications::" + expenditure.getClass());
        int wholeListSize = expenditure.size();
        IntSummaryStatistics statistics=new IntSummaryStatistics();

       // List<Integer> sortedList=expenditure.stream().sorted().toList();
        Integer[] tmpArray = new Integer[d];
        PriorityQueue<Integer> priorityQueue=new PriorityQueue();
        int head=0;
        int nextElement=0;
        if (d < wholeListSize) {
            priorityQueue.addAll(expenditure.subList(0,d));

            int i=0;
            while(i+d<expenditure.size()) {

                int toPoint = wholeListSize <= (i + d) ? wholeListSize : i + d;
                //int mid=priorityQueue.size()/2;
                if(i==0){
                    //find queue center only once
                    //even
                    int value=0;
                    Integer[] tmpArr=new Integer[d];
                    tmpArr=priorityQueue.toArray(tmpArr);
                    if(d%2==0){
                        int sum=tmpArr[d/2]+tmpArr[(d/2)-1];
                        median=sum/2;
                    }
                    else{
                        median=tmpArr[d/2];
                    }
                }
                else{
                    nextElement=expenditure.get(toPoint);
                    head=priorityQueue.poll();
                    int diff=0;
                    if(nextElement>head){
                        diff=nextElement-head;
                    }
                    else{
                        diff=head-nextElement;
                    }

                }

                if (expenditure.get(toPoint) >= (median * 2)) {

                    notifications++;
                }
                i++;
               // System.out.println("Loop takes = " + (System.currentTimeMillis() - start));
            }
        }
        return notifications;
    }
}
    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

