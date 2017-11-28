import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* 
    the concept is like two glass of water
    first you take the input from stream to the first glass
    if they ask you the most bottom one, add from first glass to the second glass
    give them the most top water from the second glass
    remember to not refill the ssecond glass unless it is empty
*/
public class QueueUsingTwoStack {
    public static class MyQueue<T>{
        private Stack<T> s; //input stack, you may only input to this stack
        private Stack<T> s2; //output stack, you may only output from this stack
        private T head;

        public MyQueue(){
            s = new Stack<>();
            s2 = new Stack<>();
            head = null;
        }

        public void enqueue(T input){
            s.push(input);
        }

        public T dequeue(){
            if (s2.isEmpty()){
                while (!s.isEmpty()){
                    s2.push(s.pop());
                }
            }
            T ret = s2.pop();
            return ret;
        }

        public T peek(){
            if (s2.isEmpty()){
                while (!s.isEmpty()){
                    s2.push(s.pop());
                }
            }
            return s2.peek();
        }
    }
    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}