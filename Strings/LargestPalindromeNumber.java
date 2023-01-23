package Strings;

public class LargestPalindromeNumber {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        // count each number's frequency
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            count[c - '0']++;
        }

        StringBuilder res = new StringBuilder();
        // iterate from 9 to 1 (since no leading zeroes, need to check later)
        for (int digit = 9; digit > 0; digit--) {
            while (count[digit] >= 2) {
                res.append(digit);
                count[digit] -= 2;
            }
        }

        // avoid leading 0s
        while (count[0] >= 2 && res.length() > 0) {
            res.append(0);
            count[0] -= 2;
        }

        // check whether we pick the single digit
        boolean flag = false;
        // pick the biggest single digit(can be 0) and put it in the middle
        for (int digit = 9; digit >= 0; digit--) {
            if (count[digit] > 0) {
                res.append(digit);
                flag = true;
                break;
            }
        }

        // till now, we only form the left half part of palindromic number,
        // we need to finish the right part too
        // "744 9" -> "744 9 447"
        // "123" -> "123321"
        int index = flag ? res.length() - 2 : res.length() - 1;
        while (index >= 0) {
            char c = res.charAt(index--);
            res.append(c);
        }

        return res.toString();
    }

}
