import java.util.*;
import java.lang.*;

public class LargestNumberFromArray {
    public static void main(String[] args) {
        ArrayList<Integer> A1 = new ArrayList<Integer>(Arrays.asList(3,30,34,5,9));
        //ArrayList<Integer> A1 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
        String Answer = largestNumber(A1);
        System.out.println(Answer);

    }


    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static  String largestNumber(final List<Integer> A) {
        ArrayList<Integer> B = new ArrayList<>(A);
        int N= A.size();
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                String P= B.get(i).toString();
                String Q= B.get(j).toString();
                String PQ = P+Q;
                String QP = Q+P;
                Long X = Long.parseLong(PQ);
                Long Y = Long.parseLong(QP);
                if (X < Y){
                    int temp = B.get(i);
                    int temp1 = B.get(j);
                    B.set(i,B.get(j));
                    B.set(j,temp);
                }
            }
        }
        String LarNo = "";
        for(int i=0;i<N;i++){
            if (B.get(i) >0) {
                LarNo += (B.get(i).toString());
            }
        }
        if (LarNo.isBlank()){
            LarNo += "0";
        }
        /*
        String[] arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = A.get(i).toString();
        }
        */
        return (LarNo);
    }
}
