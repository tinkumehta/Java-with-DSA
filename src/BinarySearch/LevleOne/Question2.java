package BinarySearch.LevleOne;



public class Question2 {

    public static void main(String[] args) {

        int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr, 3));
    }


    // search in two 2d matrix
    static  boolean searchMatrix(int matrix[][], int target)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int st=0, end =row * col -1;
        while (st <= end) {
            int mid = st +(end - st)/2;
            int midCR= matrix[mid/col][mid %col];
            if (midCR == target){
                return true;
            }
            if (target < midCR) {
                end = mid -1;
            } else {
                st = mid +1;
            }
        }
        return false;
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

