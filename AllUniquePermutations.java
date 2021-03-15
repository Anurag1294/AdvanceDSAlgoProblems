/*
All Unique Permutations
Problem Description

Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= |A| <= 9



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible unique permutation of the array.



Example Input
Input 1:

A = [1, 1, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Output 2:

[ [1, 2]
  [2, 1] ]


Example Explanation
Explanation 1:

 All the possible unique permutation of array [1, 1, 2].
Explanation 2:

 All the possible unique permutation of array [1, 2].




 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class AllUniquePermutations {
    private static ArrayList<ArrayList<Integer>> Ans;
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3));
        Ans = new ArrayList<>();
        Ans = permute(A);
        System.out.println(Ans);
        System.out.println(Ans.size());
    }
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Collections.sort(A);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:A){
            if (!map.containsKey(i)){
                map.put(i,1);
            }else{
                int Count = map.get(i);
                map.put(i,Count+1);
            }
        }
        ArrayList<Integer> Box = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            Box.add(-1);
        }
        backtrack(0,map,Box,A);
        return Ans;
    }
    public static void backtrack(int Index ,HashMap<Integer,Integer> map, ArrayList<Integer> Box ,ArrayList<Integer> A){
        if (Index == A.size()){
            ArrayList<Integer> R1 = new ArrayList<>(Box);
            Ans.add(R1);
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
            if (Countofvaluetillnow<Totalcount){
                Box.set(Index,k);
                backtrack(Index+1,map,Box,A);
            }
        }
    }
}
