package lecture1.lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);
        Program Program = new Program();

        System.out.println("\n Choose Shape type [1-4]:");
        System.out.println("-------------------------------");
        System.out.println(" |");
        System.out.println(" | 1. Rectangle");
        System.out.println(" | 2. Square");
        System.out.println(" | 3. (Right) Trinagle");
        System.out.println(" | 4. Circle");
        System.out.println(" |");
        System.out.print(" | >  ");

        int shapeType = Scanner.nextInt();
        Program.run(shapeType);

        Scanner.close();
    }
}