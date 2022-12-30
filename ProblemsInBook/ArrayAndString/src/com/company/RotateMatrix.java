package com.company;

public class RotateMatrix{
// Rotate Matrix: Given an image represented by NxN matrix, where each pixel in the image is 4 bytes, write a method
    // to rotate the image by 90 degrees.

    public static boolean rotate(int [][]matrix){
        if(matrix.length ==0 || matrix.length != matrix[0].length ) return false; // base case
        // swap index by index
        // swap on each layer
        // temp -> top
        // top -> left
        // left -> bot
        // bot -> right
        // right -> temp
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n-1-layer;
            for (int i = first; i < last; i++) {
                int offset = i - first; // offset always start by 0, this uses to loop inside the layer
                int top = matrix[first][i]; // temp
                matrix[first][i] = matrix[last-offset][first]; // top => left, hang cuoi den 0, cot 0 (trai)
                matrix[last-offset][first] = matrix[last][last-offset]; // left => bottom , hang cuoi cot cuoi den 0
                matrix[last][last-offset] = matrix[i][last]; // bottom => right , hang i cot cuoi
                matrix[i][last] = top; // right => top
            }
        }
        return true;
    }
    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public static void main(String[] args) {

    }
}
