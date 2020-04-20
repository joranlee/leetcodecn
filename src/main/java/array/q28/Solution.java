package array.q28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (null == needle || "".equals(needle.trim())) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        int h = haystack.length();
        int n = needle.length();
        int head = -1;
        int recentHead = -1;
        boolean matched = false;
        for (int i = 0; i < (h - n + 1); ) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                head = i;
                recentHead = i;
                for (int j = 0; j < n; j++) {
                    if (haystack.charAt(i + j) == needle.charAt(j)) {
                        if (haystack.charAt(i + j) == needle.charAt(0)) {
                            recentHead = (recentHead == head) ? i + j : recentHead;
                        }
                        matched = true;
                    } else {
                        if (haystack.charAt(i + j) == needle.charAt(0)) {
                            recentHead = (recentHead == head) ? i + j : recentHead;
                        }
                        matched = false;
                        i = (i == recentHead) ? i + 1 : recentHead;
                        break;
                    }
                }
            } else {
                i++;
            }
            if (matched) {
                break;
            }
        }

        return matched ? head : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aacaaaacaaab", "aacaaab"));
    }
}
