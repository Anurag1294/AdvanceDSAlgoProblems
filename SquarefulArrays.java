import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SquarefulArrays {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5050, 879, 82, 18, 82, 18, 18, 31, 33, 88, 137));
        //cccArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,2,2));
        System.out.println(solve(A));
    }
    private static int count;
    private static int N;


    public static int solve(ArrayList<Integer> A) {
        count=0;
        N = A.size();
        Collections.sort(A);
        /* Hashmap to store Frequency array */ //Start
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:A){
            if (!map.containsKey(i)){
                map.put(i,1);
            }else{
                int Count = map.get(i);
                map.put(i,Count+1);
            }
        }
        /* Hashmap to store Frequency array */ //End
        /* Box */ //Start
        ArrayList<Integer> Box = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            Box.add(-1);
        }
        /* Box */ //End


        backtrack(0,map,Box);
        return count;
    }
    public static void backtrack(int Index ,HashMap<Integer,Integer> map, ArrayList<Integer> Box){
        if (Index ==N){
            if (N-1 != 0){
                int c=0;
                for(int i=0;i<N-1;i++){
                    int AdjSum = Box.get(i) + Box.get(i+1);
                    if (IsSquare(AdjSum)){
                        c++;
                    }
                }
                if (c==N-1){
                    count++;
                }
            }else{
                if (IsSquare(Box.get(0))){
                    count++;
                }
            }
            return;
        }
        for(int k:map.keySet()){
            int Totalcount = map.get(k);
            int Countofvaluetillnow=0;
            for (int j=0;j<Index;j++){
                if (Box.get(j)==k){
                    Countofvaluetillnow++;
                }
            }
            if (Index>1){
                int adjS = Box.get(Index-2) + Box.get(Index-1);
                if (!IsSquare(adjS)){
                    return;
                }
            }
            if (Countofvaluetillnow <Totalcount){
                Box.set(Index,k);
                backtrack(Index+1,map,Box);
            }
        }
    }
    public static boolean IsSquare(int num){
        double sqrt=Math.sqrt((double)num);
        if (Math.ceil(sqrt) == Math.floor(sqrt)){
                return true;
        }
        return false;
    }
}
