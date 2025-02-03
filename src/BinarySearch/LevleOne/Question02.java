package BinarySearch.LevleOne;

public class Question02 {

    public static void main(String[] args) {
        int num [] = {1, 2,3,1};
        int num1 [] = {1, 2, 1,3, 5, 6, 4};
        System.out.println(findPeak(num1));
    }

    // find the peak element
    static int findPeak(int num[])
    {
        int start =0;
        int end = num.length-1;
        while (start < end) {
            int mid = start + ( end -start ) /2;
            if (num[mid] < num[mid+1]){
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
