package Trie.Implements;

public class classRoom {
    static class Node {
        static final int ALPHA_BATE = 26;
        Node children[];
        boolean eow;
        Node () {
            children = new Node[ALPHA_BATE];
            for (int i=0; i<26; i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    static Node root = new Node();
    public static String ans ="";

    public static void main(String[] args) {
        String words[] = { "the", "a", "there",
                "answer", "any", "by",
                "bye", "their", "hero", "heroplane" };
    //    int n = keys.length;
        for (int i=0; i<words.length; i++){
            insert(words[i]);
        }
      //  System.out.println(wordBreak(key));
        //System.out.println(startWith(key));
       // longestWord(root, new StringBuilder(""));
      //  System.out.println(ans);
        System.out.println(remove(root, "hero",0 ));
    }
    public static void longestWord(Node root, StringBuilder temp)
    {
        if (root == null)return;

        for (int i=0; i<26; i++){
            if (root.children[i] != null && root.children[i].eow == true){
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() -1);
            }
        }
    }
    static int countNode(Node root)
    {
        int count =0;
        for (int i=0; i<26; i++){
            if (root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }
        return count+1;
    }
    public static boolean startWith(String perfix)
    {
        Node curr = root;
        for (int i=0; i<perfix.length(); i++){
            int idx = perfix.charAt(i) - 'a';
            if (curr.children[idx] == null) return false;

            curr = curr.children[idx];
        }
        return true;
    }
    public static boolean wordBreak(String key)
    {
        if (key.length() == 0) {
            return true;
        }
        for (int i=1; i<=key.length(); i++){
            String first = key.substring(0, i);
            String second = key.substring(i);
            if (search(first) && wordBreak(second)){
                return  true;
            }
        }
        return false;
    }
    public static void insert(String words)
    {
        // O(L)
        Node curr = root;
        for (int i=0; i<words.length(); i++){
            int index = words.charAt(i) - 'a';
            if (curr.children[index] == null){
                curr.children[index] = new Node();
            }
            // check empty
            if (i == words.length()-1){
                curr.children[index].eow = true;
            }
            curr = curr.children[index];
        }
    }
    public static boolean search(String key)
    {
        Node curr = root;
        for (int i=0; i<key.length(); i++){
            int index = key.charAt(i) -'a';
            if (curr.children[index] == null) {
                return false;
            }
            if (i == key.length() -1 && curr.children[index].eow == false)
                return false;
            curr = curr.children[index];
        }
        return true;
    }
    static boolean isEmpty(Node root)
    {
        for (int i=0; i<26; i++){
            if (root.children != null)
                return false;
        }
        return true;
    }
    static Node remove(Node root , String key, int depth)
    {
        Node curr = root;
        if (curr == null) {
            return null;
        }
        if (depth == key.length()) {
            if (curr.eow)
                curr.eow = false;
            if (isEmpty(curr)){
                curr = null;
            }
            return curr;
        }
        int idx = key.charAt(depth) - 'a';
        curr.children[idx] = remove(curr.children[idx], key, depth+1);
        if (isEmpty(root) && curr.eow == false)
            curr = null;
        return curr;
    }
}












