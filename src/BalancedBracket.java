import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBracket {
    
    public static boolean isBalanced(String e) {
        Stack s = new Stack();
        for (int i=0;i< e.length();i++)
        {
            if (e.charAt(i)==']' && (char)s.peek() =='[')
                s.pop();
            else if (e.charAt(i)=='}' && (char)s.peek() =='{')
                s.pop();
            else if (e.charAt(i)==')' && (char)s.peek() =='(')
                s.pop();
            else
                s.push(e.charAt(i));
        }
        return s.isEmpty();
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}