package BinarySearch.LevleOne;


public class Question03 {
    public static void main(String[] args) {
        int arr[] = {9,7,5,4,3,2,1};
        int[] arr1 = {1,2,3,4,5,6};
        System.out.println(countRotations(arr1));
        int target = 10;
      //  System.out.println(orderAgnosticBS(arr, 1));
//        int ans = sellingNumber(arr1,-5 );
//        System.out.println(ans);
       // System.out.println(ans(arr1, 10));
    }
    static int orderAgnosticBS(int arr[], int target)
    {
        int start =0, end = arr.length-1;
        boolean isAcc = arr[start] < arr[end];
        while (start <=end) {
            int mid = start + (end -start) /2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAcc) {
                if (arr[mid] > target) {
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            } else {
                if (arr[mid] < target){
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }
        }
        return -1;
    }
    // return the index of smalled no >= target
    static int sellingNumber(int arr[], int target)
    {
        // target value is greater but arr.length is not exits then return -1;
        if (target > arr[arr.length-1]){
            return -1;
        }
        int start =0, end = arr.length-1;
        while (start <= end){
            int mid = start + (end -start)/2;
            if (target < arr[mid]){
                end = mid-1;
            } else if (target > arr[mid]) {
                start = mid +1;
            } else {
                // found ans
                return mid;
            }
        }
        return start;
    }
    // InfiniteArray
    static int ans (int arr[], int target)
    {
        int start =0;
        int end = 1;
        while (target > arr[end]){
            int temp = end +1;
            end = end + (end -start+1) *2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }

    private static int binarySearch(int[] arr, int target, int start, int end)
    {
        while (start <= end){
            int mid = start + (end -start)/2;
            if (target < arr[mid]){
                end = mid -1;
            } else if (target > arr[mid]) {
                start = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    static int countRotations(int arr[])
    {
        int pivot = findPivot(arr);
        return pivot +1;
    }
    static int findPivot(int arr[])
    {
        int start =0, end = arr.length-1;
        while (start <= end) {
            int mid = start + (end -start) /2;
            if (mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid+1]){
                return  mid-1;
            }
            if (arr[mid] <= arr[start]){
                end = mid -1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
