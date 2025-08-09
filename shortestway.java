// Complexity
// Build map: O(n).

// Each target char: binary search over its positions: O(log freq).

// O(m log k) which can be O(m log n) in the worst case. (m is length of target, n is length of source and k is the average occurrence of each character.)
public class Solution {
    public int shortestWay(String s, String target) {
        int n = s.length(), m = target.length();
        if (m == 0) return 0;
        if (n == 0) return -1;

        // map from char -> sorted positions in s
        Map<Character, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            pos.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        int passes = 1;        // we are in the first pass
        int iInS = -1;         // last matched index in s (use -1 then search > iInS)

        for (int j = 0; j < m; ) {
            char c = target.charAt(j);
            List<Integer> list = pos.get(c);
            if (list == null) return -1; // char not present in s at all

            // find first position > iInS
            int k = upperBound(list, iInS);
            if (k == list.size()) {
                // need a new pass over s
                passes++;
                iInS = -1;
            } else {
                // consume this character
                iInS = list.get(k);
                j++;
            }
        }
        return passes;
    }

    // first index where list.get(idx) > x
    private int upperBound(List<Integer> list, int x) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) <= x) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
