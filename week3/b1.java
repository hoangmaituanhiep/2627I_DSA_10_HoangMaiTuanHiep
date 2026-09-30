package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class b1 {
    public static String isBalanced(String s) {
        // Write your code here
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c=='[' || c=='{') stack.push(c);
            else {
                if (stack.empty()) return "NO";
                if (c==')' && stack.peek()=='(') stack.pop();
                else if (c==']' && stack.peek()=='[') stack.pop();
                else if (c=='}' && stack.peek()=='{') stack.pop();
                else return "NO";
            }
        }
        if (stack.empty()) return "YES";
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer inp = new StreamTokenizer(read);
        inp.nextToken(); int n = (int) inp.nval;
        while (n>0) {
            inp.nextToken(); String line = inp.sval;
            System.out.println(isBalanced(line));
            n--;
        }
    }
}
