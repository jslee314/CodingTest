package com.jslee.lib;


public class MyClass {

    public static int n = 5;
    public static void main(String[] args) {
        int n =5;
        int result =0;
        for(int i=0; i<=n; i++){
            for(int m=0; m<60; m++){
                for(int s=0; s<60; s++){
                    String txt = Integer.toString(i) + Integer.toString(m) + Integer.toString(s);
                    if(txt.contains("3")) result++;
                }
            }
        }
        System.out.println(result);

    }



}