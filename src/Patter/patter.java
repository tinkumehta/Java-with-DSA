package Patter;

public class patter {
    public static void main(String[] args) {
        int n =4;

//       for (int row =1; row<=n; row++){
//         for (int space =0; space< n-row; space++){
//             System.out.print(" ");
//         }
//         for (int col=row; col>=1; col--){
//             System.out.print(col);
//         }
//         for (int col =2; col<=row; col++){
//             System.out.print(col);
//         }
//        System.out.println();
//       }
     //   square(n);
      //  System.out.print(n);
    }
    static void square(int n)
    {
        int originalN= n;
        n = 2 *n;
        for (int row =0; row<= n; row++){
            for (int col =0; col<= n; col++){
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n-row, n-col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

}
