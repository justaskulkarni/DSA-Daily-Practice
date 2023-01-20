package HashTable;

import java.util.HashSet;
import java.util.Set;

public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        /*
         * The Java.util.HashSet.add() method in Java HashSet is used to add a specific
         * element into a HashSet. This method will add the element only if the
         * specified element is not present in the HashSet else the function will return
         * False if the element is already present in the HashSet.
         */
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char number = board[row][column];
                if (number != '.') {
                    if (!set.add(number + " in row " + row) ||
                            !set.add(number + " in column " + column) ||
                            !set.add(number + " in block " + (row / 3) + "," + (column / 3)))
                        return false;
                }
            }
        }
        return true;
    }    
}
