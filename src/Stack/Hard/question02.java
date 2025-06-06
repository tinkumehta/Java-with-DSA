package Stack.Hard;

import java.util.HashSet;
import java.util.Stack;

public class question02 {

    public static void main(String[] args) {
        int[] arr = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(getMaxArea(arr));
    }
    static int getMaxArea(int[] arr)
    {
        int res =0, n = arr.length;
        for (int i=0; i<n; i++){
            int curr = arr[i];
            for (int j= i-1; j >=0 && arr[j] >= arr[i] ; j--)
                curr += arr[i];
            for (int j= i+1; j< n && arr[j] >= arr[i] ; j++)
                curr += arr[i];
            res = Math.max(res, curr);

        }
        return res;
    }
    static int DistinctR(int[] arr, int n)
    {
        HashSet<Integer> dist = new HashSet<>();
        int firstMax, secondMax;
        for (int i=0; i<n -1; i++){
            firstMax = arr[i];
            secondMax = Integer.MIN_VALUE;
            for (int j = i+1; j<n; j++){
                if(firstMax < arr[j])
                {
                    secondMax = firstMax;
                    firstMax = arr[j];
                }
                else if(secondMax < arr[j])
                    secondMax = arr[j];

                dist.add(firstMax - secondMax);
            }
        }
        return dist.size();
    }
    static int leftindex(int[] heights, int idx, int n)
    {
        int h = heights[idx];
        for (int i= idx -1; i>=0 ; i--){
            if (heights[i] >= h)
                return i;
        }
        return -1;
    }
    static int rightindex(int heights[], int idx, int n)
    {
        int h = heights[idx];
        for (int i=idx +1; i<n; i++){
            if (heights[i] >= h)
                return i;
        }
        return n;
    }
    static int max_pepole(int height[], int n)
    {
        int ans =0;
        for (int i=0; i<n; i++){
            int left = leftindex(height, i, n);
            int right = rightindex(height, i, n);
            ans = Math.max(ans, right - left -1);
        }
        return ans;
    }
    static void sortStack(Stack<Integer> st)
    {
        if (st.isEmpty()) return;
        int top = st.pop();
            sortStack(st);

            Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty() && st.peek() > top) {
            temp.push(st.pop());
        }
        st.push(top);
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }
    static int celebrity(int[][] mat)
    {
        int n = mat.length;
        int inderge [] = new int[n];
        int outerderge [] = new int[n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int x = mat[i][j];

                outerderge[i] += x;
                inderge[j] += x;
            }
        }
        for (int i=0; i<n; i++)
            if (inderge[i] == n-1 && outerderge[i] == 0)
                return i;
        return -1;
    }
    static int getMaxArea01(int[] arr)
    {
        int res =0, n = arr.length;
        for (int i=0; i<n; i++){
            int curr = arr[i];
            for (int j= i-1; j>= 0 && arr[j] > arr[i]; j--)
                curr += arr[i];
            for (int j= i +1; j<n && arr[j] > arr[i]; j++)
                curr += arr[i];
            res = Math.max(res, curr);
        }
        return res;
    }
}
