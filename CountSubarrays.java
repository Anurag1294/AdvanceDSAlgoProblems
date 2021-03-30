import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountSubarrays {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,3,2,2));
        System.out.println(solve(A));
    }
    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        int i=0;
        int j=0;
        long cnt=0L;
        while(j<A.size()) {
            if(hs.containsKey(A.get(j))) {
                int Val = hs.get(A.get(j));
                if (i<Val){
                    i=Val;
                }
                //i=i<hs.get(A.get(j))?hs.get(A.get(j)):i;
            }
            cnt= (cnt%100000007)+ (((j%100000007-i%100000007)+1)+100000007)%100000007;
            cnt%=100000007;
            hs.put(A.get(j),j);
            j++;
        }
        return (int)cnt%100000007;
    }
}
