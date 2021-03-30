/*Merge Intervals
        Problem Description

        Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

        You may assume that the intervals were initially sorted according to their start times.



        Problem Constraints
        1 <= |intervals| <= 105



        Input Format
        First argument is the vector of intervals

        second argument is the new interval to be merged



        Output Format
        Return the vector of intervals after merging



        Example Input
        Input 1:

        Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
        Input 2:

        Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


        Example Output
        Output 1:

        [ [1, 5], [6, 9] ]
        Output 2:

        [ [1, 9] ]


        Example Explanation
        Explanation 1:

        (2,5) does not completely merge the given intervals
        Explanation 2:

        (2,6) completely merges the given intervals


*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval{
    int start,end;
    Interval() {
        start=0;
        end=0;
    }
    Interval(int s ,int e ){
        start=s;
        end=e;
    }
}


public class MergeIntervals{
    public static void main(String[] args) {
        ArrayList<Interval> A = new ArrayList<>();
        Interval I1 = new Interval(1,3);
        Interval I2 = new Interval(6,9 );
        A.add(I1);
        A.add(I2);
        Interval B = new Interval(4,5);
        System.out.println(insert(A,B));
    }


    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i=0;

        //Skip the no-overlapping intervals/Small intervals
        while(i<intervals.size() && intervals.get(i).end< newInterval.start){
            i++;
        }

        // Now we have skipped the intervals non required intervals
        while(i<intervals.size() && intervals.get(i).start<= newInterval.end){
            //compare the interval with merged new interval
            Interval inter = intervals.remove(i);
            newInterval.start=Math.min(inter.start,newInterval.start);
            newInterval.end=Math.max(inter.end,newInterval.end);
        }
        intervals.add(i,newInterval);
        return intervals;
    }
}
