package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class b2 {
    static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer inp = new StreamTokenizer(read);

        inp.nextToken(); int q = (int) inp.nval;
        Stack<Integer> first = new Stack<>();
        Stack<Integer> last = new Stack<>();
        while (q>0) {
            inp.nextToken(); int t = (int) inp.nval;
            if (t==1) {
                inp.nextToken(); int val = (int) inp.nval;
                first.push(val);
            }
            if (t==2) {
                if (last.isEmpty()) {
                    while (!first.isEmpty()) last.push(first.pop());
                }
                last.pop();
            }
            if (t==3) {
                if (!last.isEmpty()) System.out.println(last.peek());
                else if (!first.isEmpty()) {
                    while(!first.isEmpty()) last.push(first.pop());
                    System.out.println(last.peek());
                }
            }
            q--;
        }
    }
}
