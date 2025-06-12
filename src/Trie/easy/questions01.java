package Trie.easy;

public class questions01 {
    static class Trie {
        boolean leaf;
        Trie children[] = new Trie[2];
    }

    static Trie getNewTrieNode ()
    {
        Trie node = new Trie();
        node.children[0] = null;
        node.children[1] = null;
        node.leaf = false;
        return node;
    }
    public static boolean insert(Trie head, int arr[], int N)
    {
        Trie curr = head;
        for (int i=0; i<N; i++) {
            if (curr.children[arr[i]] == null) {
                curr.children[arr[i]] = getNewTrieNode();
            }
            curr = curr.children[arr[i]];
        }
            if (curr.leaf)
                return false;

        curr.leaf = true;
        return true;
    }
    static void duplicatePrint(int mat[][], int M, int N)
    {
        Trie head = getNewTrieNode();
        for (int i=0; i< M; i++)
            if (!insert(head, mat[i], N))
                System.out.print("There is a duplicate row " + (i+1) + "\n");
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 0, 1 },
        };
        duplicatePrint(mat, 6, 6);
    }
}









