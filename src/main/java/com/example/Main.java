package com.example;

public class Main {
    public static void main(String[] args) {
        String s = "abcd Option3, abcd";
        String st = s.split(" ")[1].substring(0, s.split(" ")[1].length()-1);
        System.out.println(st);

    }
}