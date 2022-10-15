package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      /*  Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
       **** Each row must contain the digits 1-9 without repetition.
       **** Each column must contain the digits 1-9 without repetition.
       **** Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        Note:
        A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.
        *
        * ******************************************
        One leetcode a day keep unemployment away
*/
        char[][] board = new char[9][9];
        HashSet set = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                   if (!set.add(number + "in row" + i) ||
                    !set.add(number + "in column" + j) ||
                    !set.add(number + "in board 3x3" + i / 3 + " - " + j / 3)) {
                       return false; // done in leetcode
                   }
                }
            }
        }
        return true;
        // row
        // column
        // i / 3 , j/3 for each board 3x3
    }
}