//Given an entered n, it creates a Pascal triangle but replaces number with the respective Ascii character. If it exceeds 24, it returns to 1.

import java.util.Scanner;  // Import the Scanner class

public class ex1 {
    
    public static int triangulo(int linhas) {
        int num;
        for(int i=0;i<linhas;i++) {
            for(int k=0;k<linhas-i;k++) System.out.print(" ");
            for(int j=0;j<=i;j++) {
                num = (fatorial(i))/((fatorial(j))*(fatorial(i-j)));
                while(num>24){
                    num-=24;
                }
                num+=64;
                System.out.print((char)num + " ");
            }
            System.out.println();
        }
        return 0;
    }
    
    public static int fatorial(int n) {
        int temp = 1;
        for(int i=n;i>0;i--) {
            temp *= i;
        }
        return temp;
    }
    public static void main(String[] args) {
        try (Scanner myObj = new Scanner(System.in)) {
            System.out.println("Enter number of rows: ");
            int n = myObj.nextInt();  // Read user input
            if(n>0 && n < 13) {
                triangulo(n);
            } else {
                System.out.println("Error! Invalid number.");
            }
        } 
    }
}
