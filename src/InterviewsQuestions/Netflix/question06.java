package InterviewsQuestions.Netflix;

/*
    How to design a tiny URL or URL shortener?
    How to design a system that takes big URLs like "https://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/"
    and converts them into a short 6 character URL.
    It is given that URLs are stored in the database and every URL has an associated integer id.

    One important thing to note is, the long URL should also be uniquely identifiable from the short URL. So we need a Bijective Function
 */
public class question06 {
    static String idSortUrl(int n)
    {
        char [] map= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder temp = new StringBuilder();

        while (n > 0) {
         temp.append(map[n % 62]);
         n = n/62;
        }
        return temp.reverse().toString();
    }
    static int shortUrlId (String shortUrl)
    {
        int n = shortUrl.length();
        int id =0;
        for (int i=0; i<n; i++){
            if ('a' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'z')
                id = id * 62 + shortUrl.charAt(i) - 'a';
            if ('A' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'A')
                id  = id * 62 + shortUrl.charAt(i) - 'A' + 26;
            if ('0' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= '9')
                id = id * 62 + shortUrl.charAt(i) - '0' + 52;
        }
        return id;
    }

    public static void main(String[] args) {
        int n = 12345;
        String url = idSortUrl(n);
       // System.out.println(idSortUrl(n));

        System.out.println(shortUrlId(url));
        System.out.println(idSortUrl(n));
    }
}
