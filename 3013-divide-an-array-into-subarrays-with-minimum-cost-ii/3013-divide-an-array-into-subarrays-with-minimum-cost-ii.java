import java.util.*;

public class Solution {
    static class MultiSet {
        private final TreeMap<Long, Integer> map = new TreeMap<>();
        private long size = 0;

        void add(long x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            size++;
        }

        boolean remove(long x) {
            Integer cnt = map.get(x);
            if (cnt == null) return false;
            if (cnt == 1) map.remove(x);
            else map.put(x, cnt - 1);
            size--;
            return true;
        }

        long firstKey() {
            return map.firstKey();
        }

        long lastKey() {
            return map.lastKey();
        }

        boolean contains(long x) {
            return map.containsKey(x);
        }

        long getSize() {
            return size;
        }

        boolean isEmpty() {
            return map.isEmpty();
        }
    }

    public static long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        if (k == 1) return nums[0];
        int need = k - 2;
        long INF = Long.MAX_VALUE / 4;
        MultiSet small = new MultiSet();
        MultiSet large = new MultiSet();
        long sumSmall = 0L;
        int s1 = 1;
        int L = s1 + 1;
        int R = Math.min(n - 1, s1 + dist);
        for (int idx = L; idx <= R; idx++) {
            long val = nums[idx];
            if (need > 0 && small.getSize() < need) {
                small.add(val);
                sumSmall += val;
            } else if (need > 0 && !small.isEmpty() && val < small.lastKey()) {
                long move = small.lastKey();
                small.remove(move);
                sumSmall -= move;
                large.add(move);
                small.add(val);
                sumSmall += val;
            } else {
                large.add(val);
            }
        }
        long answer = INF;
        for (s1 = 1; s1 <= n - 1; s1++) {
            L = s1 + 1;
            R = Math.min(n - 1, s1 + dist);
            if (s1 > 1) {
                int oldRemoveIdx = s1;
                if (oldRemoveIdx >= 0 && oldRemoveIdx <= n - 1) {
                    long val = nums[oldRemoveIdx];
                    if (small.contains(val)) {
                        small.remove(val);
                        sumSmall -= val;
                        if (need > 0 && large.getSize() > 0 && small.getSize() < need) {
                            long move = large.firstKey();
                            large.remove(move);
                            small.add(move);
                            sumSmall += move;
                        }
                    } else {
                        large.remove(val);
                    }
                }
                int prevR = Math.min(n - 1, (s1 - 1) + dist);
                if (R > prevR) {
                    long val = nums[R];
                    if (need > 0 && small.getSize() < need) {
                        small.add(val);
                        sumSmall += val;
                    } else if (need > 0 && !small.isEmpty() && val < small.lastKey()) {
                        long move = small.lastKey();
                        small.remove(move);
                        sumSmall -= move;
                        large.add(move);
                        small.add(val);
                        sumSmall += val;
                    } else {
                        large.add(val);
                    }
                }
            }
            int windowLeft = s1 + 1;
            int windowRight = R;
            int windowSize = Math.max(0, windowRight - windowLeft + 1);
            if (need == 0) {
                long cost = (long) nums[0] + nums[s1];
                answer = Math.min(answer, cost);
            } else if (windowSize >= need && small.getSize() == need) {
                long cost = (long) nums[0] + nums[s1] + sumSmall;
                answer = Math.min(answer, cost);
            }
        }
        return answer == INF ? -1 : answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,2,6,4,2};
        System.out.println(minimumCost(nums1, 3, 3));
        int[] nums2 = {10,1,2,2,2,1};
        System.out.println(minimumCost(nums2, 4, 3));
        int[] nums3 = {10,8,18,9};
        System.out.println(minimumCost(nums3, 3, 1));
    }
}