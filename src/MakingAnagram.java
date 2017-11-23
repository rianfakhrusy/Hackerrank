import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class MakingAnagram {
    public static int numberNeeded(String first, String second) {
        char[] a = new char[26], b = new char[26];
        for (int i=0;i<first.length();i++){
            a[first.charAt(i) - 'a'] += 1;
        }
        for (int i=0;i<second.length();i++){
            b[second.charAt(i) - 'a'] += 1;
        }
        int tot = 0;
        for (int i=0;i<26;i++){
            tot += Math.abs(a[i] - b[i]);
        }
        return tot;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
