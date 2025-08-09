// Time: O(n) (each candidate scanned once)

// Space: O(1)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        if (n == 0) return 0; // or -1 depending on convention
        int cand1 = tops[0], cand2 = bottoms[0];

        int r1 = check(tops, bottoms, cand1);
        if (cand1 == cand2) return r1; // same candidate on first domino

        int r2 = check(tops, bottoms, cand2);
        if (r1 == -1) return r2;
        if (r2 == -1) return r1;
        return Math.min(r1, r2);
    }

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
