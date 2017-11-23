import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {
    
    public static String solve(HashMap<String,Integer> h,HashMap<String,Integer> h2){
        Iterator it = h2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            
            if ((h.get(pair.getKey())==null)||(h.get(pair.getKey())<(int)pair.getValue())){
                return "No";
            }
            
            //System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        
        HashMap<String,Integer> hash = new HashMap<>();
        HashMap<String,Integer> hash2 = new HashMap<>();
        
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
            hash.put(magazine[magazine_i], hash.getOrDefault(magazine[magazine_i], 0) + 1);
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
            hash2.put(ransom[ransom_i], hash2.getOrDefault(ransom[ransom_i], 0) + 1);
        }
        
        System.out.println(solve(hash,hash2));
    }
}