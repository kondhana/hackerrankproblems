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

class ResultSherlock {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        List<String> result=new ArrayList<>();
        int countValue=0;
        int rangeCounter=1;
        int startCounter=0;
        //for(int i=1;i<=s.length();i++){
            while(rangeCounter<=s.length()) {
                while ((startCounter+ rangeCounter) <= s.length()) {
                    String firstString=s.substring(startCounter, startCounter + rangeCounter);

                    for (int runIndex = startCounter+1; (runIndex + rangeCounter) <= s.length() ; runIndex++) {
                        String secondString = s.substring(runIndex, runIndex + rangeCounter);

                        if(rangeCounter==1){
                            if(firstString.equals(secondString)){
                                //System.out.println("firstString+secondString = " + firstString+secondString);
                                result.add(firstString+secondString);
                            }
                        }
                        else{
                            if(checkAnagram(firstString,secondString)){
                                //System.out.println("firstString+secondString = " + firstString+secondString);
                                result.add(firstString+secondString);
                            }
                        }
                    }
                    startCounter++;
                }
                startCounter=0;
                rangeCounter++;
            }
        //}
        return result.size();
    }

    private static boolean checkAnagram(String firstString,String secondString) {
        int i=0;
        StringBuffer buffer=new StringBuffer(secondString);
        if(firstString.length()!=secondString.length()){
            return false;
        }
        char[] secondStrArray=secondString.toCharArray();
        char[] firstStrArray=firstString.toCharArray();
        Arrays.sort(secondStrArray);
        Arrays.sort(firstStrArray);

        return new String(secondStrArray).equals(new String(firstStrArray));
    }

}

public class SherlockAndAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultSherlock.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

