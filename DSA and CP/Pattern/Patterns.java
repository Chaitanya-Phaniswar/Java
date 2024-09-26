public class Patterns {

    public static void pattern(int n) {
        System.out.println("Pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void pattern2(int n) {
        System.out.println("Pattern 2");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern3(int n) {
        System.out.println("Pattern 3");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            System.out.println("");
        }
    }

    public static void pattern4(int n) {
        System.out.println("Pattern 4");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1);
            }
            System.out.println("");
        }
    }

    public static void pattern5(int n) {
        System.out.println("Pattern 5");
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern6(int n) {
        System.out.println("Pattern 6");
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(n - j + 1);
            }
            System.out.println("");
        }
    }

    public static void pattern7(int n) {
        System.out.println("Pattern 7");
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (; j < n + i; j++) {
                System.out.print("*");
            }
            for (; j < 2 * n - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void pattern8(int n) {
        System.out.println("Pattern 8");
        for (int i = 0; i < n; i++) {
            int j = 2 * n - 1 - 2 * i;
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (; j > 0; j--) {
                System.out.print("*");
            }
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void pattern9(int n) {
        System.out.println("Pattern 9");
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (; j < n + i; j++) {
                System.out.print("*");
            }
            for (; j < 2 * n - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("");
        }
        for (int i = 0; i < n; i++) {
            int j = 2 * n - 1 - 2 * i;
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (; j > 0; j--) {
                System.out.print("*");
            }
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            System.out.println("");
        }

    }

    public static void pattern10(int n) {
        System.out.println("Pattern 8");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        // System.out.println("Pattern 5");
        for (int i = 1; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern11(int n) {
        System.out.println("Pattern 11");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i + j) % 2 == 1) {
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }

    public static void pattern12(int n) {
        System.out.println("Pattern 12");
        for (int i = 0; i < n - 1; i++) {
            int col = 0;
            for (; col <= i; col++) {
                System.out.print(col + 1);
            }
            for (int j = 2 * n - 2 * (col + 1); j > 0; j--)
                System.out.print(" ");
            col -= 1;
            for (; col >= 0; col--) {
                System.out.print(col + 1);
            }
            System.out.println();
        }
    }

    public static void pattern13(int n) {
        System.out.println("Pattern 13");
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }

    public static void pattern14(int n) {
        System.out.println("Pattern 14");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) (65 + j));
            }
            System.out.println();
        }
    }

    public static void pattern15(int n) {
        System.out.println("Pattern 15");
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print((char)(65+n - j));
            }
            System.out.println("");
        }
    }

    public static void pattern16(int n) {
        System.out.println("Pattern 15");
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print((char)(65+i));
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {

        pattern(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
        pattern5(5);
        pattern6(5);
        pattern7(5);
        pattern8(5);
        pattern9(5);
        pattern10(5);
        pattern11(5);
        pattern12(10);
        pattern13(5);
        pattern14(5);
        pattern15(5);
        pattern16(5);
    }
}