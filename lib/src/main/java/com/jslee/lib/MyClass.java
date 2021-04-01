package com.jslee.lib;

import java.util.Stack;

public class MyClass {
    public static int n = 123402;

    public static void main(String[] args) {
        String result;
        String nString = Integer.toString(n);
        int length = nString.length();

        int leftSum = calculate(nString, 0, (length / 2)-1);
        int rightSum = calculate(nString, (length / 2), length-1);

        System.out.println(leftSum);
        System.out.println(rightSum);

        if (leftSum == rightSum)
            result = "LUCKY";
        else
            result = "READY";
        System.out.println(result);
    }

    public static int calculate(String nString, int start, int end) {
//        System.out.println(start);
//        System.out.println(end);

        int sum = 0;
        for (int i = start; i < end; i++) {
            char now = nString.charAt(i);
            sum = sum + Integer.parseInt(String.valueOf(now));

        }

        return sum;
    }


//        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
//        int[] moves = {1,5,3,5,1,2,1,4};
//        int answer = 0;
//
//        Stack<Integer> basket = new Stack<>();
//
//        for(int mv: moves){
//
//            for(int y=0; y<board.length; y++){
//                if (board[y][mv - 1] != 0) {
//
//
//                    if (basket.empty()) {
//                        basket.push(board[y][mv - 1]);
//                    } else if (basket.peek().equals(board[y][mv - 1])) {
//                        basket.pop();
//                        answer = answer + 2;
//                    } else {
//                        basket.push(board[y][mv - 1]);
//                    }
//
//                    board[y][mv - 1] = 0;
//                    break;
//
//                }
//            }
//        }
//        System.out.println(answer);
//    }

}