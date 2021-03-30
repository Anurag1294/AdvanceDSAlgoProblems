import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStackusinganotherStack {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(34,3,21,98,92,23));
        System.out.println(solve(A));
    }

    public  static ArrayList<Integer> solve(ArrayList<Integer> A) {

        Stack<Integer> S = new Stack<>();
        S.addAll(A);
        Stack<Integer> temp = new Stack<>();
        while(!S.empty()){
            int tmp = S.pop();
            while(!temp.empty() && temp.peek() > tmp  ){
                S.push(temp.pop());
            }
            temp.push(tmp);
        }

        return new ArrayList<>(temp);
    }
}
