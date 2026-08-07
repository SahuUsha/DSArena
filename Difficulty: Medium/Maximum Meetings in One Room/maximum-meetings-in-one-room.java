class Solution {

    class Pair {
        int start;
        int end;
        int pos;

        Pair(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {

        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            list.add(new Pair(s[i], f[i], i + 1));
        }

        Collections.sort(list, (a, b) -> {
            if (a.end == b.end) {
                return Integer.compare(a.pos, b.pos);
            }
            return Integer.compare(a.end, b.end);
        });

        ArrayList<Integer> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).start > prevEnd) {
                ans.add(list.get(i).pos);
                prevEnd = list.get(i).end;
            }
        }

        Collections.sort(ans);

        return ans;
    }
}