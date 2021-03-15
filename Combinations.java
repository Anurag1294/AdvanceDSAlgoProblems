/*
Combinations
Problem Description

Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A .

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.



Problem Constraints
1 <= A, B <= 10



Input Format
First argument is an integer A.
Second argument is an integer B.



Output Format
Return a 2-D vector denoting all possible combinations.



Example Input
Input 1:

 A = 4
 B = 2
Input 2:

 A = 3
 B = 2


Example Output
Output 1:

 [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 3],
  [2, 4],
  [3, 4],
 ]
Output 2:

 [
  [1, 2],
  [1, 3],
  [2, 3]
 ]


Example Explanation
Explanation 1:

All the possible combinations of size 2 in sorted order.




 */

import java.util.ArrayList;

public class Combinations {
    private static ArrayList<ArrayList<Integer>> Ans;
    public static void main(String[] args) {
        int A = 4;
        int B =2;
        Ans = new ArrayList<>();
        Ans = combine(A,B);
        System.out.println(Ans);
    }
    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<Integer> Box = new ArrayList<>();
        for(int i=0;i<B;i++){
            Box.add(-1);
        }
        Bactrack(0,B,A,Box);
        return Ans;
    }

    public static void Bactrack(int Index,int B ,int A, ArrayList<Integer> Box){
        if (Index==B){
            ArrayList<Integer> R1 = new ArrayList<>(Box);
            Ans.add(R1);
            return;
        }
        for(int i=1;i<=A;i++){
            boolean valid = true;
            for(int j=0;j<Index;j++){
                if(Box.get(j)>=i){
                    valid=false;
                    break;
                }
            }
            if(valid){
                Box.set(Index,i);
                Bactrack(Index+1,B,A,Box);
            }
        }
    }


}
