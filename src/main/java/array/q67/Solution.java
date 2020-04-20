package array.q67;

public class Solution {
    public String addBinary(String a, String b) {
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        int alength = achar.length;
        int blength = bchar.length;
        if (alength > blength) {
            return plus(achar, bchar);
        }
        return plus(bchar, achar);
    }

    public String plus(char[] a, char[] b) {
        int alength = a.length;
        int blength = b.length;
        boolean plusOne = false;
        for (int i = 0; i < blength; i++) {
            if (a[alength - i - 1] == '1' && b[blength - i - 1] == '1') {
                if (plusOne) {
                    a[alength - i - 1] = '0';
                    plusOne = true;
                } else {
                    a[alength - i - 1] = '1';
                    plusOne = true;
                }
            } else if (a[alength - i - 1] == '0' && b[blength - i - 1] == '0') {
                if (plusOne) {
                    a[alength - i - 1] = '0';
                    plusOne = false;
                } else {
                    a[alength - i - 1] = '1';
                    plusOne = false;
                }
            } else {
                if (plusOne) {
                    a[alength - i - 1] = '1';
                    plusOne = false;
                } else {
                    a[alength - i - 1] = '0';
                    plusOne = true;
                }
            }
        }
        int rest = alength - blength;
        if (rest == 0) {
            if (a[0] == '0') {
                StringBuilder sb = new StringBuilder();
                sb.append('1');
                for (char achar : a) {
                    sb.append(achar);
                }
                return sb.toString();
            }
            StringBuilder sb = new StringBuilder();
            for (char achar : a) {
                sb.append(achar);
            }
            return sb.toString();
        } else {
            while (plusOne) {
                if ((rest - 1) >= 0 && a[rest - 1] == '1') {
                    a[rest - 1] = '0';
                    rest--;
                } else {
                    plusOne = false;
                    a[rest - 1] = '1';
                    break;
                }
            }
            if (a[0] == '0') {
                StringBuilder sb = new StringBuilder();
                sb.append('1');
                for (char achar : a) {
                    sb.append(achar);
                }
                return sb.toString();
            }
            StringBuilder sb = new StringBuilder();
            for (char achar : a) {
                sb.append(achar);
            }
            return sb.toString();
        }
    }
}
