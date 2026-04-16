package edu.sandiego.comp305;

public class Main {
    private Main() {
        // prevent instantiation
    }

    public static void main(final String[] args) {
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}
