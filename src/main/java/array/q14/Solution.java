package array.q14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        for (String s : strs) {
            if (null == s || s.length() == 0) {
                return "";
            }
        }

        if (strs.length == 1) {
            return strs[0] == null ? "" : strs[0];
        }
        StringBuilder sb = new StringBuilder();

        boolean finished = false;

        for (int i = 0; i < strs[0].length(); i++) {

            for (int index = 1; index < strs.length; index++) {
                // 如果超出了数组中某个元素的长度，则比较结束
                if (i > strs[index].length()-1) {
                    finished = true;
                    break;
                }

                if (strs[index].charAt(i) != strs[0].charAt(i)) {
                    finished = true;
                    break;
                }
            }
            if (finished) {
                break;
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s = {"aa", "a"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(s));
    }
}
