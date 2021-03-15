import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutations {
    private static ArrayList<ArrayList<Integer>> Ans = new ArrayList<>();
    private static boolean Valid;

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,3,2));
        ArrayList<ArrayList<Integer>> Res = new ArrayList<>();
        Res =permute(A);
        System.out.println(Res);
        System.out.println(Res.size());
    }
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> Box = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            Box.add(-1);
        }
        Bactrack(0,A.size(),Box,A);
        return Ans;
    }

    public static void Bactrack(int Index,int N, ArrayList<Integer> Box,ArrayList<Integer> A){
        if (Index == N){
            ArrayList<Integer> R1 = new ArrayList<>(Box);
            Ans.add(R1);
            return;
        }
        for(int i:A){
            Valid=true;
            for(int j=0;j<Index;j++){
                if (Box.get(j)==i){
                    Valid=false;
                    break;
                }
            }
            if(!Valid) continue;
            else{
                Box.set(Index,i);
                Bactrack(Index+1,N,Box,A);
            }
        }
    }
}
