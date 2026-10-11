package week4;

import java.io.*;
import java.util.*;

public class b4 {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer inp = new StreamTokenizer(read);
        inp.nextToken(); int s = (int) inp.nval;
        List<Integer> arr = new ArrayList<>();
        for (int i=0;i<s;i++) {
            inp.nextToken(); arr.add((int) inp.nval);
        }
        for (int i=0; i<s-1; i++) {
            if (arr.get(i)>arr.get(i+1)) {
                int j=i+1;
                while (j>0 && arr.get(j)<arr.get(j-1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j-1));
                    arr.set(j-1, temp);
                    j--;
                }
            }
        }
        for (int i=0; i<s; i++) System.out.print(arr.get(i)+ " ");
    }
}
