import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class CountRectangles {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,2,2,3,3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,2,1,2,1,2));
        System.out.println(solve(A,B));
    }
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    // Hashtable to store X and Y
        Hashtable<Integer, Hashtable<Integer, Integer>> h1 = new Hashtable<>();
            for(int i= 0; i <A.size(); i++){
            if(h1.containsKey(B.get(i))){
                h1.get(B.get(i)).put(A.get(i),1);
            }else{
                Hashtable<Integer, Integer> c1 = new Hashtable<>();
                c1.put(A.get(i), 1);
                h1.put(B.get(i), c1);
            }
        }
            int count = 0;
            for(int i = 0; i<A.size(); i++){
                for(int j = 0; j<A.size(); j++){
                    if((A.get(j) > A.get(i)) && (B.get(j) > B.get(i))){
                        // New Point if A,B,C,D
                        // A is i loop and C in j loop
                        // B new point for rectangle
                        int x1 = A.get(j); int y1 = B.get(i);
                        // D new point for rectangle
                        int x2 = A.get(i); int y2 = B.get(j);
                        if(h1.containsKey(y1) && h1.containsKey(y2)){
                            if(h1.get(y1).containsKey(x1) && h1.get(y2).containsKey(x2)){
                                count++;
                            }
                        }
                    }
                }
            }
            return count;
    }
}
