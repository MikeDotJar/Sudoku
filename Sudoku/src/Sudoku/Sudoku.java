/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sudoku;

import static java.lang.System.arraycopy;

/**
 *
 * @author Admin
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    
    public static int[][] completeState = new int[9][9];
    public static void main(String[] args) {
        int[][] state = new int[9][9];
        
        state[0][3] = 9;
        state[0][5] = 2;
        state[0][6] = 6;
        state[0][8] = 4;
        
        state[1][0] = 6;
        state[1][2] = 4;
        state[1][3] = 3;
        state[1][7] = 7;
        
        state[2][1] = 7;
        state[2][3] = 1;
        state[2][5] = 4;
        
        state[3][2] = 3;
        state[3][4] = 1;
        state[3][5] = 9;
        state[3][6] = 8;
        
        state[4][0] = 1;
        state[4][1] = 5;
        state[4][4] = 4;
        state[4][7] = 9;
        state[4][8] = 7;
        
        state[5][2] = 7;
        state[5][3] = 8;
        state[5][4] = 2;
        state[5][6] = 3;
        
        state[6][3] = 2;
        state[6][5] = 6;
        state[6][7] = 5;
        
        state[7][1] = 3;
        state[7][5] = 7;
        state[7][6] = 1;
        state[7][8] = 2;
        
        state[8][0] = 9;
        state[8][2] = 2;
        state[8][3] = 5;
        state[8][5] = 1;
        
        System.out.println("Starting state: ");
        displayState(state);
        System.out.println("\nEnding state: ");
        Solution s = new Solution(state);
        displayState(completeState);
        
    }
    
    
    public static void displayState(int[][] arr){
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0){
                    System.out.println();
                }
            for(int j = 0; j < 9; j++){
                if(j % 3 == 0){
                    System.out.print(" ");
                }
                if(arr[i][j] == 0){
                    System.out.print(". ");
                }
                else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    
}
