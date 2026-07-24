class Solution {

    class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        // Mark beginWord as visited if present
        set.remove(beginWord);

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            String word = curr.word;
            int steps = curr.steps;

            if (word.equals(endWord))
                return steps;

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;

                    String next = new String(arr);

                    if (set.contains(next)) {

                        q.offer(new Pair(next, steps + 1));

                        // Mark visited
                        set.remove(next);
                    }
                }

                arr[i] = original;
            }
        }

        return 0;
    }
}