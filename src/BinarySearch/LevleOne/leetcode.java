package BinarySearch.LevleOne;

public class leetcode {
    public static void main(String[] args) {
        int nums[]= {7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(canSplit(nums, m));
    }
    public static int canSplit(int nums[], int m)
    {
        int start =0 ,end =0;
        for (int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        // apply binary search
        while (start < end) {
            int mid = start + (end -start)/2;
            int sum =0;
            int pices =1;
            for (int num : nums){
                if (sum + num > mid) {
                    // you cannot add this in this subarray, make new one
                    // say you add this num in new subarray , then sum = num
                    sum = num;
                    pices++;
                } else {
                    sum += num;
                }
            }
            if (pices > m) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
