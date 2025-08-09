// Time: O(n) (each candidate scanned once)

// Space: O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int ans = Integer.MAX_VALUE;

        int r1 = check(tops, bottoms, tops[0]);
        if (r1 != -1) ans = Math.min(ans, r1);

        int r2 = check(tops, bottoms, bottoms[0]);
        if (r2 != -1) ans = Math.min(ans, r2);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // returns min rotations to make all values == target, or -1 if impossible
    private int check(int[] tops, int[] bottoms, int target) {
        int aRot = 0, bRot = 0;
        for (int i = 0; i < tops.length; ++i) {
            if (tops[i] != target && bottoms[i] != target) return -1;
            if (tops[i] != target) aRot++;
            if (bottoms[i] != target) bRot++;
        }
        return Math.min(aRot, bRot);
    }
}
