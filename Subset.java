/*
Subset
Problem Description

Given a set of distinct integers, A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX


Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a vector of vectors denoting the answer.



Example Input
Input 1:

A = [1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]


Example Explanation
Explanation 1:

 You can see that these are all possible subsets.
Explanation 2:

You can see that these are all possible subsets.



 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {
    static ArrayList<ArrayList<Integer>> Ans = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3,1,2));
        ArrayList<ArrayList<Integer>> Answer = new ArrayList<>();
        Answer = Subsets(A);
        System.out.println(Answer.size());
        System.out.println(Answer);
        //Custom Comparator
        Collections.sort(Ans, (ArrayList<Integer> first, ArrayList<Integer> second) -> {

            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if(first.get(i) < second.get(i))return -1;
                if(first.get(i) > second.get(i))return 1;
            }
            if (first.size() > second.size()) return 1;
            return -1;
        });
        // result array list
        System.out.println(Ans);

    }
    public static ArrayList<ArrayList<Integer>> Subsets(ArrayList<Integer> A){
        Collections.sort(A);
        ArrayList<Integer> Subset = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            Subset.add(-1);
        }
        Backtrack(A,0,A.size(),Subset);
        return Ans;

    }

    public static void Process(ArrayList<Integer> A ,ArrayList<Integer> S) {
            ArrayList<Integer> Subset = new ArrayList<>();
            for(int i=0;i<A.size();i++){
                if (S.get(i)==1){
                    Subset.add(A.get(i));
                }
            }
            Ans.add(Subset);
    }
    public static void Backtrack(ArrayList<Integer> A,int Index,int N , ArrayList<Integer> Subset){
        if (Index==N){
            Process(A,Subset);
        }else{
            for (int i=0;i<=1;i++){
                Subset.set(Index,i);
                Backtrack(A,Index+1,N,Subset);
            }
        }
    }
}
