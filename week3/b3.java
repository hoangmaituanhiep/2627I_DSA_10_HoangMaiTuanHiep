package week3;

import java.io.*;
import java.util.*;

class Pair<K, V> {
    K key;
    V s;
    Pair (K k, V v) {
        key = k;
        s = v;
    }
    K getKey() {
        return key;
    }
    V getValue() {
        return s;
    }
}

public class b3 {

    public static void main(String[] args) throws Exception{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer inp = new StreamTokenizer(read);
        inp.nextToken(); int q= (int) inp.nval;
        Stack<Character> s = new Stack<>();
        Stack<Pair<Integer, Stack<Character>>> his = new Stack<>();
        while (q>0) {
            inp.nextToken(); int t = (int) inp.nval;
            if (t==1) {
                inp.nextToken(); String w = inp.sval;
                int n = w.length();
                his.push(new Pair<>(1, new Stack<>()));
                for (int i=0; i<n; i++) {
                    s.push(w.charAt(i));
                    his.peek().getValue().push(w.charAt(i));
                }
            }
            if (t==2) {
                inp.nextToken(); int k = (int) inp.nval;
                his.push(new Pair<>(2, new Stack<>()));
                while (k>0) {
                    his.peek().getValue().push(s.pop());
                    k--;
                }
            }
            if (t==3) {
                inp.nextToken(); int k = (int) inp.nval;
                Stack<Character> temp = new Stack<>();
                int n = s.size();
                for (int i=0; i<=n-k; i++) temp.push(s.pop());
                System.out.println(temp.peek());
                while (!temp.isEmpty()) s.push(temp.pop());
            }
            if (t==4) {
                Pair<Integer, Stack<Character>> undo = his.pop();
                if (undo.getKey()==1) {
                    while (!undo.getValue().isEmpty()) {
                        undo.getValue().pop();
                        s.pop();
                    }
                }
                else {
                    while (!undo.getValue().isEmpty()) {
                        s.push(undo.getValue().pop());
                    }
                }
            }
            q--;
        }
    }
}
