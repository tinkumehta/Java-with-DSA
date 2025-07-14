package InterviewsQuestions.Netflix;

/*
    Excel column name from a given column number
    MS Excel columns have a pattern like A, B, C, …, Z, AA, AB, AC, …., AZ, BA, BB, … ZZ, AAA, AAB ..... etc.
    In other words, column 1 is named "A", column 2 as "B", and column 27 as "AA".
    Given a column number, the task is to find its corresponding Excel column name.

Examples:

Input: 26
Output: Z

Input: 51
Output: AY

Input: 676
Output: YZ

Input: 705
Output: AAC
 */

public class question10 {
    static String excelNumber(int n)
    {
        if (n == 0) return "";
        n--;
        return excelNumber(n / 26) + (char) (n %26 + 'A');
    }

    public static void main(String[] args) {
        int n = 26;
        System.out.println(excelNumber(n));
    }
}
