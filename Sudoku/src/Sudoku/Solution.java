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
public class Solution {
    Node root;
    
    Solution(int[][] arr){
        root = new Node(arr);
        boolean result = Backtracking();
    }
    
    public boolean Backtracking(){
        return Backtracking(root);
    }
    
    public boolean Backtracking(Node n){
       if(isComplete(n)){
           Sudoku.completeState = n.state;
           return true;
       } 
       int[] coordinates = findCoordinates(n);
       int row = coordinates[0];
       int col = coordinates[1];
       for(int i = 1; i <= 9; i++){
           int[][] temp = new int[9][9];
           for(int j = 0; j < 9; j++){
               for(int k = 0; k < 9; k++){
                   temp[j][k] = n.state[j][k];
               }
           }
           temp[row][col] = i;
           if(!isConsistent(n.state,row,col)){
               System.out.println(i);
           }
           if(isConsistent(temp,row,col)){
               switch (i) {
                   case 1:
                       {
                           n.s1 = new Node(temp);
                           boolean result = Backtracking(n.s1);
                           if(result){
                               return true;
                           }       break;
                       }
                   case 2:
                       {
                           n.s2 = new Node(temp);
                           boolean result = Backtracking(n.s2);
                           if(result){
                               return true;
                           }       break;
                       }
                   case 3:
                       {
                           n.s3 = new Node(temp);
                           boolean result = Backtracking(n.s3);
                           if(result){
                               return true;
                           }       break;
                       }
                   case 4:
                       {
                           n.s4 = new Node(temp);
                           boolean result = Backtracking(n.s4);
                           if(result){
                               return true;
                           }       break;
                       }
                   case 5:
                       {
                           n.s5 = new Node(temp);
                           boolean result = Backtracking(n.s5);
                           if(result){
                               return true;
                           }       break;
                       }
                   case 6:
                       {
                           n.s6 = new Node(temp);
                           boolean result = Backtracking(n.s6);
                           if(result){
                               return true;
                           }       break;
                       }
                   case 7:
                       {
                           n.s7 = new Node(temp);
                           boolean result = Backtracking(n.s7);
                           if(result){
                               return true;
                           }       break;
                       }
                   case 8:
                       {
                           n.s8 = new Node(temp);
                           boolean result = Backtracking(n.s8);
                           if(result){
                               return true;
                           }       break;
                       }
                   default:
                       {
                           n.s9 = new Node(temp);
                           boolean result = Backtracking(n.s9);
                           if(result){
                               return true;
                           }       break;
                       }
               }
           }
       }
       return false;
    }
    
    public boolean isComplete(Node n){
        int[][] temp = n.state;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(temp[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[] findCoordinates(Node n){
        int[][] temp = n.state;
        //AIProject5.displayState(temp);
        int[] coord = new int[2];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(temp[i][j] == 0){
                    coord[0] = i;
                    coord[1] = j;
                    return coord;
                }
            }
        }
        return null;
    }
    
    public boolean isConsistent(int[][] arr, int row, int col){
        int[] valueRow = new int[9];
        int[] valueCol = new int[9];
        int[] valueBlock = new int[9];
        
        for(int i = 0; i < 9; i++){
            valueRow[i] = arr[row][i];
            valueCol[i] = arr[i][col];
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(valueRow[i] == valueRow[j] && i != j && valueRow[i] != 0){
                    return false;
                }
            }
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(valueCol[i] == valueCol[j] && i != j && valueCol[i] != 0){
                    return false;
                }
            }
        }
        
        int row1 = (row / 3) * 3;
        int col1 = (col / 3) * 3;
        
        int position = 0;
        for(int i = row1; i <= row1 + 2; i++){
            for(int j = col1; j <= col1 + 2; j++){
                valueBlock[position] = arr[i][j];
                position++;
            }
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(valueBlock[i] == valueBlock[j] && i != j && valueBlock[i] != 0 && valueBlock[j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
}
