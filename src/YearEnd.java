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

class Result1 {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int length=q.size();
        int numberOfBribes=0;
        boolean tooChaotic=false;

        for(int i=0;i<length-1;i++){
            int element=q.get(i);
            int tempBribe=0;
            for(int j=i+1;j<length;j++){
                if(element>q.get(j)){
                    tempBribe++;
                    if(tempBribe>2){
                        tooChaotic=true;
                    }
                }
            }
            numberOfBribes+=tempBribe;
        }

        if(tooChaotic){
            System.out.println("Too chaotic");
        }
        else{
            System.out.println(numberOfBribes);
        }
    }

}

public class YearEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result1.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
