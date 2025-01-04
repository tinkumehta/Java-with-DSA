package Arrays.Level1;

public class Question03 {

    public static void main(String[] args) {
        int a[] = { 2, 3, 4, 10, 40 };
        int n = a.length;
        int x = 40;
        System.out.println(binarySearch(a, 0, n-1, x));
    }

    //Methods for Java Binary Search
    static int binarySearch(int arr[], int l, int h, int x)
    {
        while (l <= h) {
            int mid = (l+h)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                h = mid -1;
            } else {
                l = mid +1;
            }
        }
        return -1;
    }
}
