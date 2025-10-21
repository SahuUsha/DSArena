class Solution {
    public boolean canCross(int[] stones) {
          int n = stones.length;
        if (n == 2) {
            return stones[1] == 1;
        }
        Map<Integer, Set<Integer>> reachable = new HashMap<>();
        for (int i = 0; i < n; i++) {
            reachable.put(i, new HashSet<>());
        }
        reachable.get(0).add(0); 

        Map<Integer, Integer> stonePositions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            stonePositions.put(stones[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int lastJump : new HashSet<>(reachable.get(i))) {
                for (int nextJump : new int[]{lastJump - 1, lastJump, lastJump + 1}) {
                    if (nextJump > 0) {
                        int nextPos = stones[i] + nextJump;
                        if (stonePositions.containsKey(nextPos)) {
                            int nextIndex = stonePositions.get(nextPos);
                            reachable.get(nextIndex).add(nextJump);
                        }
                    }
                }
            }
        }

        return !reachable.get(n - 1).isEmpty();
    
    }

}