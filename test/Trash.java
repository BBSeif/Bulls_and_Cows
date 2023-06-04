//
//package bullscows.test;
//
//import java.util.Arrays;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Trash {
//    public static void main(String[] args) {
//        //grader();
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//
//        isMore(num);
//
//    }
//    public static StringBuilder Secret_code (int n) {
//        Random r = new Random();
//        long pseudoRandomNumber = r.nextInt();
//        StringBuilder a = new StringBuilder(""+pseudoRandomNumber);
//        //a.reverse();
//        StringBuilder str = new StringBuilder();
//        str.append(a.charAt(0));
//        for (int i = 0; n > str.length(); i++) {
//            unique(str,a.charAt(i));
//        }
//        return str;
//    }
//
//    public static StringBuilder unique (StringBuilder str,char c) {
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == c) {
//                count++;
//            }
//        }
//        if (count == 0) {
//            str.append(c);
//        }
//        return str;
//    }
//    public static void isMore (int n) {
//
//        if (n <= 10) {
//            StringBuilder b = Secret_code(n);
//            String bs = b.toString();
//            String[] a = bs.split("");
//            grader(charToInt(a));
//        } else {
//            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.",n);
//
//        }
//    }
//
//
//    public static void grader(int[] ans){
//        Scanner sc = new Scanner(System.in);
//        boolean c = true;
//        int i = 1;
//        System.out.println("Okay, let's start a game!");
//        do {
//            System.out.printf("Turn %d:\n",i);
//            String str = sc.next();
//            System.out.print("Grade: ");
//            String[] strToArr =(str.split(""));
//            int[] in = charToInt(strToArr);
//            c = check(in,ans);
//            i++;
//        } while (c);
//
//    }
//
//    public static int[] charToInt (String[] n) {
//        int[] a = new int[n.length];
//        for (int i = 0; i < n.length; i++) {
//            a[i] = Integer.valueOf(n[i]);
//        }
//        return a;
//    }
//
//    public static boolean check (int[] n, int[] ans) {
//        //int[] ans = {9,3,0,5};
//        boolean checker = true;
//        int bullCount = 0;
//        int cowCount = 0;
//        for (int i = 0; i < ans.length; i++) {
//            if (ans[i] == n[i]) {
//                bullCount++;
//            }
//            for (int j = 0; j < n.length; j++) {
//                if (ans[i] == n[j]) {
//                    cowCount++;
//                }
//            }
//        }
//        cowCount = cowCount - bullCount;
//        if (bullCount == 0 && cowCount == 0){
//            System.out.println("None");
//        }else {
//            if (bullCount > 1) {
//                System.out.print(bullCount + " bulls ");
//            } else if (bullCount == 1) {
//                System.out.print(bullCount + " bull ");
//            }
//            if (cowCount > 1) {
//                System.out.println(cowCount + " cows ");
//            } else if (cowCount == 1) {
//                System.out.println(cowCount + " cow ");
//            }
//            if ( bullCount == ans.length) {
//                System.out.println("Congratulations! You guessed the secret code.");
//                checker = false;
//            }
//        }
//        return checker;
//    }
//}
//
//
