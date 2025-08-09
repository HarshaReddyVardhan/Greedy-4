public class Solution {
    public int shortestWay(String s, String target) {
        int m = s.length(), n = target.length();
        if (n == 0) return 0;
        if (m == 0) return -1;

        boolean[] present = new boolean[26];
        for (int i = 0; i < m; i++) present[s.charAt(i) - 'a'] = true;

        int p1 = 0, p2 = 0, count = 1; // one current pass
        while (p2 < n) {
            char tc = target.charAt(p2);
            if (!present[tc - 'a']) return -1;         // impossible

            if (p1 == m) {                              // new pass over s
                p1 = 0;
                count++;
            }
            if (s.charAt(p1) == tc) p2++;               // match and advance target
            p1++;                                       // always advance on s
        }
        return count;
    }
}

// Complexity
// Time: O(answer * m) ≤ O(n * m) in worst case.
// Space: O(1) (just a presence array).
