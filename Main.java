
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the length of the secret code:");
        Scanner sc = new Scanner(System.in);
        try {
            int len = sc.nextInt();
            if (len > 0 && len <= 36) {
                System.out.println("Input the number of possible symbols in the code:");
                String[] ansBetween = isMore(len);
                if (ansBetween == null) {
                    return;
                }
                int[] random = rand(len,ansBetween );
                grader(random, ansBetween);
            } else {
                System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", len);
            }
        } catch (Exception e) {
            String a = sc.next();
            System.out.print("Error: \"");
            System.out.print(a);
            System.out.println("\" isn't a valid number.\n");
        }




    }


    public static String[] isMore(int len) {
        String[] ans = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] ansBetween;
        Scanner sc = new Scanner(System.in);
        String a = "";
        for (int i = 0; i < len; i++) {
            a+="*";
        }
        int ansLen = sc.nextInt();
        ansBetween = Arrays.copyOf(ans, ansLen);
        if (ansLen <= 10 && ansLen >= len) {
            System.out.printf("The secret is prepared: %s (0-%d).\n", a, ansLen-1);
            return ansBetween;
        } else if(ansLen <= 36 && ansLen >= len) {
            System.out.println("The secret is prepared: "+a+" (0-9, a-" + ans[ansLen-1] + ").");
            return ansBetween;
        } else if (ansLen > 36 ) {
            System.out.printf("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return null;
        } else {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.",len,ansLen);
            return null;
        }


    }

    public static int[] rand(int n, String[] list) {
        Random r = new Random();
        int[] a = new int[n];
        a[0] = r.nextInt(list.length);
        for (int i = 1; i < a.length; i++) {
            boolean c = true;
            while (c) {
                int b = r.nextInt(list.length),count = 0;
                for (int j = 0; j < i; j++) {
                    if (a[j] != b) {
                        count++;
                    }
                }
                if (count == i){
                    a[i] = b;
                    c = false;
                }

            }
        }
        return a;
    }

    public static void grader(int[] ans, String[] ansBetween) {
        boolean c = true;
        int i = 1;
        System.out.print("Okay, let's start a game!");
        do {
            System.out.printf("\nTurn %d:\n", i);
            int[] in = charToInt(ansBetween,ans);
            if (in == null) {
                return;
            }
            c = check(in, ans);
            i++;

        } while (c);
    }

    public static int[] charToInt(String[] ansBetween, int[] ans) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int check = 0;
        include(ansBetween,str);
        int[] a = new int[str.length()];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ansBetween.length; j++) {
                if (ansBetween[j].charAt(0) == str.charAt(i)) {
                    a[i] = j;
                    //System.out.println(Arrays.toString(a));
                    check++;
                }
            }
        }
        if (ans.length == check) {
            return a;
        }

        System.out.printf("Error: \""+str+"\" isn't a valid number.");
        return null;
    }

    public static boolean check( int[] n, int[] ans){
        boolean checker = true;
        int bull = 0;
        int cows = 0;
        //System.out.println(Arrays.toString(n));
        //System.out.println(Arrays.toString(ans));
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == n[i]) {
                bull++;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (ans[i] == n[j]) {
                    cows++;
                }
            }
        }
        cows = cows - bull;
        if (bull > 1 && cows > 1) {
            System.out.printf("Grade: %d bulls and %d cows", bull, cows);
        } else if (bull == 1 && cows == 1) {
            System.out.printf("Grade: %d bull and %d cow", bull, cows);
        } else if (bull > 1 && cows == 1) {
            System.out.printf("Grade: %d bulls and %d cow", bull, cows);
        } else if (bull == 1 && cows > 1) {
            System.out.printf("Grade: %d bull and %d cows", bull, cows);
        } else if (bull == ans.length) {
            System.out.printf("Grade: %d bulls ", bull);
            System.out.println("Congratulations! You guessed the secret code.");
            checker = false;
        } else if (bull == 0 && cows == 0) {
            System.out.println("Grade: None");
        } else if (bull == 0 && cows > 1) {
            System.out.printf("Grade: %d cows", cows);
        } else if (cows == 0 && bull > 1) {
            System.out.printf("Grade: %d bulls", bull);
        } else if (cows == 1) {
            System.out.printf("Grade: %d cow", cows);
        } else if (bull == 1) {
            System.out.printf("Grade: %d bull", bull);
        }
        return checker;
    }

    public static boolean include(String[] ansb, String str) {
        boolean inc = false;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < ansb.length; j++) {
                if (str.charAt(i) == ansb[j].charAt(0)) {
                    count++;
                }
            }
        }
        if (count == str.length()) {
            inc = true;
        }
        return inc;
    }
}
