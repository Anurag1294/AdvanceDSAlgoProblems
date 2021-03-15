/*
SIXLETS
Problem Description

Given a array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.



Problem Constraints
1 <= N <= 20

1 <= A[i] <= 1000

1 <= B <= N



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return number of subsequences of A of size B having sum <= 1000.



Example Input
Input 1:

    A = [1, 2, 8]
    B = 2
Input 2:

    A = [5, 17, 1000, 11]
    B = 4


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 {1, 2}, {1, 8}, {2, 8}
Explanation 1:

 No valid subsequence


 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SixLets {
    private static int CountSixlets;

    public static void main(String[] args) {
        //ArrayList<Integer> A = new ArrayList<>(Arrays.asList(123, 123, 123, 123, 123, 123, 123, 123, 123, 123));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int B =5;
        System.out.println(Solve(A,B));

    }
    public static int Solve(ArrayList<Integer> A, int B){
        // if array Size equals to B
        if (A.size()==B){
            int Sum =0;
            for(int j:A){
                Sum += j;
                if (Sum >1000) {
                    return 0;
                }
            }
            return 1;
        }
        //Collections.sort(A);
        CountSixlets=0;
        ArrayList<Integer> Box = new ArrayList<>();
        for(int i=0;i<B;i++){
            Box.add(-1);
        }
        GetSixletsThroughBacktrack(Box,0,B,A);
        return CountSixlets;
    }

    public static void GetSixletsThroughBacktrack(ArrayList<Integer> Box,int Index, int B , ArrayList<Integer> A){
        if (Index==B){
            int Sum=0;
            for(int k:Box){
                Sum += A.get(k);
            }
            if (Sum <=1000){
                CountSixlets++;
            }
            return;
        }
        for(int i=0;i<A.size();i++){
            boolean valid=true;
            for(int j=0;j<Index;j++){
                if(Box.get(j)<=i){
                    valid=false;
                    break;
                }
            }
            if(valid){
                Box.set(Index,i);
                GetSixletsThroughBacktrack(Box,Index+1,B,A);
            }
        }
    }
}
