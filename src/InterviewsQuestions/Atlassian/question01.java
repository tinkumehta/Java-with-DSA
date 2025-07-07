package InterviewsQuestions.Atlassian;
import java.util.*;


/*
    Find winner of an election where votes are represented as candidate names
    Input:  votes[] = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"}
            Output: John
            Explanation: We have four Candidates with name as 'John', 'Johnny', 'jamie', 'jackie'. The candidates John and Johny get maximum votes. Since John is alphabetically smaller.

            Input: votes[] = {"virat", "rohit", "rishabh", "rohit", "virat", "rohit"}
            Output: rohit
            Explanation: We have three Candidates with name as 'virat', 'rohit', 'rishabh'. rohit get maximum votes.


            Time Complexity: O(n * n * MAX_WORD_LEN).
            Auxiliary Space: O(MAX_WORD_LEN)
 */


import java.util.List;

public class question01 {
    public static void main(String[] args) {
        List<String> votes = new Vector<String>();
        votes.add("john");
        votes.add("johnny");
        votes.add("jackie");
        votes.add("johnny");
        votes.add("john");
        votes.add("jackie");
        votes.add("jamie");
        votes.add("jamie");
        votes.add("john");
        votes.add("johnny");
        votes.add("jamie");
        votes.add("johnny");
        votes.add("john");
        findWinner(votes);

    }
    public static void findWinner(List<String> votes)
    {
        int n = votes.size();
        int previousCount =0;
        String result = "";
        int count =0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (votes.get(i).equals(votes.get(j))){
                    count++;
                }
                if (count > previousCount){
                    previousCount = count;
                    result = votes.get(i);
                } else if (count == previousCount) {
                    if (votes.get(i).compareTo(result) < 0)
                     result =  votes.get(i);
                }
            }
        }
        System.out.println(result);
    }
}
