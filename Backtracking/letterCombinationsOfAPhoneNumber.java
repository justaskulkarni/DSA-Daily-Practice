package Backtracking;

import java.util.List;
import java.util.ArrayList;

public class letterCombinationsOfAPhoneNumber {
    String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> result = null;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrack(0, digits, new StringBuilder());
        return result;
    }

    void backtrack(int length, String digits, StringBuilder temp) {
        if (length == digits.length()) {
            result.add(temp.toString());
            return;
        }
        char ch = digits.charAt(length);
        String str = mapping[ch - '0'];
        for (char c : str.toCharArray()) {
            temp.append(c);
            backtrack(length + 1, digits, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }    
}
